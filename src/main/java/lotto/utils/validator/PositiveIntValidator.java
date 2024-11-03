package lotto.utils.validator;


import static lotto.exception.ErrorMessages.EMPTY_INPUT;
import static lotto.exception.ErrorMessages.NOT_NUMBER;
import static lotto.exception.ErrorMessages.NOT_INT;
import static lotto.exception.ErrorMessages.NOT_POSITIVE_INT;

public class PositiveIntValidator implements InputValidator<String> {

    @Override
    public void validate(String rawNumber) {
        validateNotEmpty(rawNumber);
        validateNumber(rawNumber);
        validateInt(rawNumber);

        int number = Integer.parseInt(rawNumber);
        validatePositiveInt(number);
    }

    private static void validateNotEmpty(String rawPurchasePrice) {
        if (rawPurchasePrice.isBlank()) { //strip().isEmpty() 대체.
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }

    private static void validateNumber(String rawPurchasePrice) {
        try{
            Double.parseDouble(rawPurchasePrice);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }


    private static void validateInt(String rawPurchasePrice) {
        try{
            Integer.parseInt(rawPurchasePrice);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_INT.getMessage());
        }
    }

    private static void validatePositiveInt(int purchasePrice) {
        if (purchasePrice <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_INT.getMessage());
        }
    }
}
