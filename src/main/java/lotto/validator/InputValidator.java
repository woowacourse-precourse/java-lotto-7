package lotto.validator;

import lotto.domain.Constants;

public class InputValidator {

    public void validatePriceForm(int lottoPrice) {
        if(lottoPrice % Constants.PURCHASE_FORM != 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야합니다.");
    }

    public int validateNumber(String lottoPriceString) {
        try {
            int lottoPrice = Integer.parseInt(lottoPriceString);
            validateNumberRange(lottoPrice);
            return lottoPrice;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력받은 문자열을 숫자로 변환할 수 없습니다.");
        }
    }

    public void validateNumberRange(int lottoPrice) {
        if(lottoPrice <= 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액이 0원 이하일 수 없습니다.");
        }
    }

    public void validateEmpty(String lottoPriceString) {
        if(lottoPriceString == null || lottoPriceString.isEmpty())
            throw new IllegalArgumentException("[ERROR] 입력받은 문자열이 빈문자열 또는 null입니다.");
    }

    public void validateNumbersForm(String lottoWinningNumbers) {
        if(lottoWinningNumbers.startsWith(",") && lottoWinningNumbers.endsWith(",")){
            throw new IllegalArgumentException("[ERROR] 입력받은 당첨번호의 문자열 형식이 불일치합니다.");
            // 쉼표가 연달아 있을 경우에는?
        }
    }
}
