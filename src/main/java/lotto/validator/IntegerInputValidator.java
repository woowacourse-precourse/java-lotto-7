package lotto.validator;

public class IntegerInputValidator extends InputValidator<Integer>{
    @Override
    protected Integer parse(String input) {
        return Integer.parseInt(input);
    }
}
