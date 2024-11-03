package lotto.validator;

public class BonusNumberValidator implements InputValidator<Integer> {

    @Override
    public Integer validate(String input) {
        int money = isNumber(input);
        return money;
    }

    private int isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 유효한 숫자를 입력해야 합니다.");
        }
    }
}
