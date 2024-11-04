package lotto.exception;

public class InputException {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public void validateInputEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력이 되지 않았습니다");
        }
    }

    public void validateDivisibleByTicketPrice(int input, int ticketPrice) {
        if (input % ticketPrice != 0) {
            throw new IllegalArgumentException("로또 가격 단위는 " + ticketPrice + "원 입니다");
        }
    }

    public void validateNumericInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 입력해주세요");
        }
    }

    public void validateValueInRange(int input) {
        if (!(input >= MIN_LOTTO_NUMBER && input <= MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지입니다");
        }
    }
}
