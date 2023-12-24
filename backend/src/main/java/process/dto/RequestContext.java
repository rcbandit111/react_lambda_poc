package process.dto;

public class RequestContext {
    private String accountId;
    private String apiId;
    private String domainName;
    private String domainPrefix;
    private Http HttpObject;
    private String requestId;
    private String routeKey;
    private String stage;
    private String time;
    private float timeEpoch;


    // Getter Methods

    public String getAccountId() {
        return accountId;
    }

    public String getApiId() {
        return apiId;
    }

    public String getDomainName() {
        return domainName;
    }

    public String getDomainPrefix() {
        return domainPrefix;
    }

    public Http getHttp() {
        return HttpObject;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getRouteKey() {
        return routeKey;
    }

    public String getStage() {
        return stage;
    }

    public String getTime() {
        return time;
    }

    public float getTimeEpoch() {
        return timeEpoch;
    }

    // Setter Methods

    public void setAccountId( String accountId ) {
        this.accountId = accountId;
    }

    public void setApiId( String apiId ) {
        this.apiId = apiId;
    }

    public void setDomainName( String domainName ) {
        this.domainName = domainName;
    }

    public void setDomainPrefix( String domainPrefix ) {
        this.domainPrefix = domainPrefix;
    }

    public void setHttp( Http httpObject ) {
        this.HttpObject = httpObject;
    }

    public void setRequestId( String requestId ) {
        this.requestId = requestId;
    }

    public void setRouteKey( String routeKey ) {
        this.routeKey = routeKey;
    }

    public void setStage( String stage ) {
        this.stage = stage;
    }

    public void setTime( String time ) {
        this.time = time;
    }

    public void setTimeEpoch( float timeEpoch ) {
        this.timeEpoch = timeEpoch;
    }
}
