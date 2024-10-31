package lotto.model;

public class InputValidator {
    public void validateDivideByUnit(int input, int price) {
        if (input % price != 0) {
            throw new IllegalArgumentException("[ERROR] " + price + "원 단위의 값을 입력해주세요");
        }
    }
}
