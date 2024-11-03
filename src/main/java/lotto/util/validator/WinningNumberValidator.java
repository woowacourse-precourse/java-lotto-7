package lotto.util.validator;

public class WinningNumberValidator implements Validator {
    @Override
    public void validate(String input) throws IllegalArgumentException {
        String winningNumber = Validator.removeSpace(input);
        // 추가적인 당첨 번호 검증 로직이 필요하면 여기에 구현
    }
}