package lotto.dto;

public record PurchaseAmount(int amount) {

    public PurchaseAmount(String input) {
        this(parseAmount(input));
    }

    public int getValue() {
        return amount;
    }

    private static int parseAmount(String input) {
        validateNumericInput(input);
        int amount = Integer.parseInt(input);
        validatePositiveAmount(amount);
        return amount;
    }

    private static void validateNumericInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 입력된 금액이 숫자가 아닙니다.");
        }
    }

    private static void validatePositiveAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 금액은 양수여야 합니다.");
        }
    }
}
