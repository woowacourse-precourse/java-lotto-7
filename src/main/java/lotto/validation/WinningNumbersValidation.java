package lotto.validation;

public class WinningNumbersValidation {

    public void checkRange(int input) {
        if (input < 1 || input > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

}
