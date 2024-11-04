package lotto.exception;

public class InputException {

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
}
