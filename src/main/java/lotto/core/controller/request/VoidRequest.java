package lotto.core.controller.request;

public class VoidRequest implements Request {

    private VoidRequest() {}

    public static VoidRequest type() {
        return new VoidRequest();
    }
}
