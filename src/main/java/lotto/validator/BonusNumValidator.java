package lotto.validator;


public class BonusNumValidator extends Validator{
    @Override
    public void validate(String input) throws IllegalArgumentException {
        validateInt(input);
        validateRange(input);
    }


}
