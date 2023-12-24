package process.dto;

public class Http {
    private String method;
    private String path;
    private String protocol;
    private String sourceIp;
    private String userAgent;


    // Getter Methods

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public String getUserAgent() {
        return userAgent;
    }

    // Setter Methods

    public void setMethod( String method ) {
        this.method = method;
    }

    public void setPath( String path ) {
        this.path = path;
    }

    public void setProtocol( String protocol ) {
        this.protocol = protocol;
    }

    public void setSourceIp( String sourceIp ) {
        this.sourceIp = sourceIp;
    }

    public void setUserAgent( String userAgent ) {
        this.userAgent = userAgent;
    }
}
