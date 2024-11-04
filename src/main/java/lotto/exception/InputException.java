package lotto.exception;

import java.util.List;

public class InputException {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int WINNING_NUMBERS_SIZE = 6;

    public void validateInputEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력이 되지 않았습니다");
        }
    }

    public void validateDivisibleByTicketPrice(int input, int ticketPrice) {
        if (input % ticketPrice != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 가격 단위는 " + ticketPrice + "원 입니다");
        }
    }

    public void validateNumericInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자로 입력해주세요");
        }
    }

    public void validateValueInRange(int input) {
        if (!(input >= MIN_LOTTO_NUMBER && input <= MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45까지입니다");
        }
    }

    public void validateSizeOfWinningNumbers(List<Integer> input) {
        if (input.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }
}
