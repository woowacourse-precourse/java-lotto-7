package lotto.utils;


public class InputValidator implements Validator<String> {
    private final static Integer MIN_LOTTO_NUMBER = 1;
    private final static Integer MAX_LOTTO_NUMBER = 45;

    @Override
    public void validate(String value) {
        inputCharValidate(value);
    }

    private void inputCharValidate(String value) {
        if (!value.matches("\\d+")) {
            throw new IllegalArgumentException("숫자 형식의 입력이 필요합니다.");
        }
    }

    public void integerValidate(Integer value) {
        if (value < MIN_LOTTO_NUMBER || value > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("범위를 벗어났습니다.");
        }
    }

}
