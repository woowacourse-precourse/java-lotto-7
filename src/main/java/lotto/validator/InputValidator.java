package lotto.validator;

public class InputValidator {
    public int validate(String lottoPriceString) {
        validateEmpty(lottoPriceString);
        int lottoPrice = validateNumber(lottoPriceString);
        validateForm(lottoPrice);
        
        return lottoPrice;
    }

    private void validateForm(int lottoPrice) {
        if(lottoPrice % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야합니다.");
    }

    private int validateNumber(String lottoPriceString) {
        try {
            int lottoPrice = Integer.parseInt(lottoPriceString);
            validateNumberRange(lottoPrice);
            return lottoPrice;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력받은 문자열을 숫자로 변환할 수 없습니다.");
        }
    }

    private void validateNumberRange(int lottoPrice) {
        if(lottoPrice <= 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액이 0원 이하일 수 없습니다.");
        }
    }

    private void validateEmpty(String lottoPriceString) {
        if(lottoPriceString == null || lottoPriceString.isEmpty())
            throw new IllegalArgumentException("[ERROR] 입력받은 문자열이 빈문자열 또는 null입니다.");
    }

}
