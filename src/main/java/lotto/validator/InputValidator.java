package lotto.validator;

public class InputValidator {
    public int validate(String lottoPrice) {
        validateEmpty(lottoPrice);
        validateForm(lottoPrice);
        int lottoPrice = validateNumber(lottoPrice);
        
        return lottoPrice;
    }

    private void validateEmpty(String lottoPrice) {
        if(lottoPrice == null || lottoPrice.isEmpty())
            throw new IllegalArgumentException("[ERROR] 입력받은 문자열이 빈문자열 또는 null입니다.");
    }

}
