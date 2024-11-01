package lotto.utils.validator;

public class PositiveIntValidator implements Validator<String> {

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
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    private static void validateNumber(String rawPurchasePrice) {
        try{
            Double.parseDouble(rawPurchasePrice);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다");
        }
    }


    private static void validateInt(String rawPurchasePrice) {
        try{
            Integer.parseInt(rawPurchasePrice);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("입력값이 정수가 아닙니다");
        }
    }

    private static void validatePositiveInt(int purchasePrice) {
        if (purchasePrice <= 0) {
            throw new IllegalArgumentException("입력값이 양의 정수가 아닙니다");
        }
    }
}
