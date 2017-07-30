package hello.movement.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response implements MustRespond {

    @JsonProperty
    private final long id;

    @JsonProperty
    private final String content;

    public Response() {
        this(0L, "blank");
    }

    public Response(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}