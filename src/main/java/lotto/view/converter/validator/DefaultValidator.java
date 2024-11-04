package lotto.view.converter.validator;

public class DefaultValidator {
    public void validateNumberFromString(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또번호 및 보너스번호는 숫자만 입력 가능합니다.");
        }
    }
}
