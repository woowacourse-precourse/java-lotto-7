package lotto.ui;

public class InputView {

    private static final int LOTTO_TICKET_PRICE = 1000;
    public static final int ZERO = 0;
    private static final String ERROR_NON_POSITIVE_AMOUNT = "[ERROR] 구매 금액은 0보다 커야 합니다.";
    private static final String ERROR_INVALID_AMOUNT = "[ERROR] 구매 금액은 1,000원 단위로 입력해야 합니다.";
    public static final String ERROR_NOT_NUMERIC = "[ERROR] 구매 금액은 숫자여야 합니다.";

    public int processUserInput(String input) {
        int amount = parseInput(input);
        validateAmount(parseInput(input));
        return calculateLottoTickets(amount);
    }
    private int parseInput(String input) {
        return Integer.parseInt(input);
    }

    private int calculateLottoTickets(int amount) {
        validateAmount(amount);
        return amount / LOTTO_TICKET_PRICE;
    }

    private void validateAmount(int amount) {
        if (amount <= ZERO) {
            throw new IllegalArgumentException(ERROR_NON_POSITIVE_AMOUNT);
        }

        if (amount % LOTTO_TICKET_PRICE != ZERO) {
            throw new IllegalArgumentException(ERROR_INVALID_AMOUNT);
        }
    }
}
