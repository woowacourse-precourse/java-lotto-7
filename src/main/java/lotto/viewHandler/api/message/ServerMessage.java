package lotto.viewHandler.api.message;

public enum ServerMessage implements ApiMessage {
    서버_성공(new ApiMessageImpl("success server communicate", 200)),
    클라이언트_성공(new ApiMessageImpl("success client communicate", 200));

    private final ApiMessage message;

    ServerMessage(ApiMessage message) {
        this.message = message;
    }

    public String getMessage() {
        return message.getMessage();
    }

    public Integer getCode() {
        return message.getCode();
    }
}