package lotto.core.controller.response;

public class VoidResponse implements Response {

    private VoidResponse() {}

    public static VoidResponse type() {
        return new VoidResponse();
    }
}
