package lotto.utils;

public final class StringValidator {
    
    private StringValidator() {}
    
    public static boolean isEmpty(String lineToValidate) {
        return lineToValidate.isEmpty();
    }
    
    public static boolean containsBlank(String lineToValidate) {
        return lineToValidate.contains(" ");
    }
    
    public static boolean containsNotDigit(String lineToValidate) {
        for (int i = 0; i < lineToValidate.length(); i++) {
            if (!Character.isDigit(lineToValidate.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOutOfRangeLottoNumber(String lineToValidate) {
        int numberToValidate;
        try {
            numberToValidate = Integer.parseInt(lineToValidate);
            return (numberToValidate < Constants.MIN_LOTTO_NUMBER
                    || numberToValidate > Constants.MAX_LOTTO_NUMBER);
        } catch (NumberFormatException e) {
            return true;
        }
    }

}
