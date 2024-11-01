package lotto.message;

public enum SuccessMessage {
    SUCCESS_TEST_MONEY_TICKET("구매했습니다.");

    private final String successDescription;

    SuccessMessage(String successDescription) {
        this.successDescription = successDescription;
    }

    public String getSuccessDescription() {
        return successDescription;
    }
}
