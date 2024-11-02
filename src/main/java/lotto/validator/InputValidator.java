package lotto.validator;

public class InputValidator {
    public int validate(String lottoPriceString) {
        validateEmpty(lottoPriceString);
        int lottoPrice = validateNumber(lottoPriceString);
        
        return lottoPrice;
    }

    private int validateNumber(String lottoPriceString) {
        try {
            int lottoPrice = Integer.parseInt(lottoPriceString);
            return lottoPrice;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력받은 문자열을 숫자로 변환할 수 없습니다.");
        }
    }

    private void validateEmpty(String lottoPriceString) {
        if(lottoPriceString == null || lottoPriceString.isEmpty())
            throw new IllegalArgumentException("[ERROR] 입력받은 문자열이 빈문자열 또는 null입니다.");
    }

}
