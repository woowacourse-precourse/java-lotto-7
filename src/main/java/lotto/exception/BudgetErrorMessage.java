package lotto.exception;

public enum BudgetErrorMessage {
    BUDGET_RANGE_ERROR("[ERROR] 예산은 1000원 이상이어야 합니다."),
    BUDGET_UNIT_ERROR("[ERROR] 예산은 1000원 단위여야 합니다.");

    private final String message;

    BudgetErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
