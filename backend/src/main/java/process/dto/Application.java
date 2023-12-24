package process.dto;

public class Application {
    private String version;
    private String routeKey;
    private String rawPath;
    private String rawQueryString;
    Headers HeadersObject;
    RequestContext RequestContextObject;
    private String body;
    private boolean isBase64Encoded;


    // Getter Methods

    public String getVersion() {
        return version;
    }

    public String getRouteKey() {
        return routeKey;
    }

    public String getRawPath() {
        return rawPath;
    }

    public String getRawQueryString() {
        return rawQueryString;
    }

    public Headers getHeaders() {
        return HeadersObject;
    }

    public RequestContext getRequestContext() {
        return RequestContextObject;
    }

    public String getBody() {
        return body;
    }

    public boolean getIsBase64Encoded() {
        return isBase64Encoded;
    }

    // Setter Methods

    public void setVersion( String version ) {
        this.version = version;
    }

    public void setRouteKey( String routeKey ) {
        this.routeKey = routeKey;
    }

    public void setRawPath( String rawPath ) {
        this.rawPath = rawPath;
    }

    public void setRawQueryString( String rawQueryString ) {
        this.rawQueryString = rawQueryString;
    }

    public void setHeaders( Headers headersObject ) {
        this.HeadersObject = headersObject;
    }

    public void setRequestContext( RequestContext requestContextObject ) {
        this.RequestContextObject = requestContextObject;
    }

    public void setBody( String body ) {
        this.body = body;
    }

    public void setIsBase64Encoded( boolean isBase64Encoded ) {
        this.isBase64Encoded = isBase64Encoded;
    }
}
