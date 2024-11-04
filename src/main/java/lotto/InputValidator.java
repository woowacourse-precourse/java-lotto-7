package lotto;

public class InputValidator {
    public static final int TICKET_PRICE = 1000;

    private InputValidator() {
        // Prevent instantiation
    }

    public static int parsePurchaseAmount(String input) {
        String trimmedInput = input.trim();
        if (trimmedInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 공백일 수 없습니다.");
        }
        try {
            int purchaseAmount = Integer.parseInt(trimmedInput);

            if (purchaseAmount <= 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 음수일 수 없습니다.");
            }

            if (purchaseAmount % TICKET_PRICE != 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위이어야 합니다.");
            }

            return purchaseAmount / TICKET_PRICE;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
    }

    public static int parseBonusNumber(String input) {
        String trimmedInput = input.trim();
        if (trimmedInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 공백일 수 없습니다.");
        }
        try {
            int bonusNumber = Integer.parseInt(trimmedInput);

            if (bonusNumber <= 0 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }

            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }
}
