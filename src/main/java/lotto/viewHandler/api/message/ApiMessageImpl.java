package lotto.viewHandler.api.message;

public class ApiMessageImpl implements ApiMessage {
    private final String message;
    private final Integer code;

    public ApiMessageImpl(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
