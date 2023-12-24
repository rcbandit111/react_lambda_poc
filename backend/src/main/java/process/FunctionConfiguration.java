package process;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import process.dto.Application;
import process.dto.Root;

import java.io.IOException;

public class FunctionConfiguration {

    public String process(Application request) throws IOException {
        // Do some processing. Return HTTP 200 if OK or return custom error code 500 with error message

        ObjectMapper om = new ObjectMapper();

        Root root = om.readValue(request.getBody(), Root.class);

        test();

        return "Hello, World " + root.getEmail();
    }


//    private void sendMail() throws MailjetException {
//
//        MailjetClient client;
//        MailjetRequest request;
//        MailjetResponse response;
//        client = new MailjetClient("6accc395a3fecafc1ead0d67bacefbca", "e72f2eb8c5d1453166fc6ab5a6e65b9a");
//        request = new MailjetRequest(Emailv31.resource)
//                .property(Emailv31.MESSAGES, new JSONArray()
//                        .put(new JSONObject()
//                                .put(Emailv31.Message.FROM, new JSONObject()
//                                        .put("Email", "peter.penzov@gmail.com")
//                                        .put("Name", "Mailjet Pilot"))
//                                .put(Emailv31.Message.TO, new JSONArray()
//                                        .put(new JSONObject()
//                                                .put("Email", "peter.penzov@gmail.com")
//                                                .put("Name", "passenger 1")))
//                                .put(Emailv31.Message.SUBJECT, "Your email flight plan!")
//                                .put(Emailv31.Message.TEXTPART, "Dear passenger 1, welcome to Mailjet! May the delivery force be with you!")
//                                .put(Emailv31.Message.HTMLPART, "<h3>Dear passenger 1, welcome to <a href=\"https://www.mailjet.com/\">Mailjet</a>!</h3><br />May the delivery force be with you!")));
//        response = client.post(request);
//        System.out.println(response.getStatus());
//        System.out.println(response.getData());
//    }

    private void test() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,
                "{\n" +
                        "    \"Messages\":[\n" +
                        "            {\n" +
                        "                    \"From\": {\n" +
                        "                            \"Email\": \"peter.penzov@gmail.com\",\n" +
                        "                            \"Name\": \"Mailjet Pilot\"\n" +
                        "                    },\n" +
                        "                    \"To\": [\n" +
                        "                            {\n" +
                        "                                    \"Email\": \"peter.penzov@gmail.com\",\n" +
                        "                                    \"Name\": \"passenger 1\"\n" +
                        "                            }\n" +
                        "                    ],\n" +
                        "                    \"Subject\": \"Your email flight plan!\",\n" +
                        "                    \"TextPart\": \"Dear passenger 1, welcome to Mailjet! May the delivery force be with you!\",\n" +
                        "                    \"HTMLPart\": \"<h3>Dear passenger 1, welcome to <a href=\\\"https://www.mailjet.com/\\\">Mailjet</a>!</h3><br />May the delivery force be with you!\"\n" +
                        "            }\n" +
                        "    ]\n" +
                        "}"
        );
        Request request = new Request.Builder()
                .url("https://api.mailjet.com/v3.1/send")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Basic NmFjY2MzOTVhM2ZlY2FmYzFlYWQwZDY3YmFjZWZiY2E6ZTcyZjJlYjhjNWQxNDUzMTY2ZmM2YWI1YTZlNjViOWE=")
                .build();
        Response response = client.newCall(request).execute();
    }

}
