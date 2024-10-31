package lotto.dto;

public record PurchaseAmount(int amount) {

    private static final int MAX_LIMIT = 100_000_000;
    private static final int UNIT_PRICE = 1000;

    public static PurchaseAmount from(String input) {
        validateIsNumeric(input);
        int parsedAmount = parseAmount(input);
        validateWithinLimit(parsedAmount);
        validateMultipleOfUnit(parsedAmount);
        return new PurchaseAmount(parsedAmount);
    }

    private static int parseAmount(String input) {
        int amount = Integer.parseInt(input);
        validatePositiveAmount(amount);
        return amount;
    }

    private static void validateIsNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 입력된 금액이 숫자가 아닙니다.");
        }
    }

    private static void validatePositiveAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 금액은 양수여야 합니다.");
        }
    }

    private static void validateWithinLimit(int amount) {
        if (amount > MAX_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 입력된 금액이 너무 큽니다. 최대 금액은 " + MAX_LIMIT + "원입니다.");
        }
    }

    private static void validateMultipleOfUnit(int amount) {
        if (amount % UNIT_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
