package lotto.validation;

public class LottoValidation {
    public void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력 금액에 공백을 입력하면 안됩니다.");
        }
    }
}
