package lotto.validator;

public class CastingAndValidator {

    public Integer validPayment(String inputPayment) {
        try {
            return Integer.parseInt(inputPayment);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

}
