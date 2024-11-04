package lotto.utils.validator;

import lotto.utils.constants.LottoConstants;

public class InputValidator implements Validator<String> {
    private static final String INPUT_IS_INTEGER = ErrorMessage + "숫자 형식의 입력이 필요합니다.";
    private static final String LOTTO_PRICE_UNIT_ERROR = ErrorMessage + "로또 가격은 " + LottoConstants.LOTTO_PRICE +"원 단위여야 합니다.";
    private static final String LOTTO_PRICE_MINIMUM_ERROR = ErrorMessage + "로또 가격은 " + LottoConstants.LOTTO_PRICE + "원 이상이어야 합니다.";

    @Override
    public void validate(String value) {
        inputCharValidate(value);
    }

    private void inputCharValidate(String value) {
        if (!value.matches("\\d+")) {
            throw new IllegalArgumentException(INPUT_IS_INTEGER);
        }
    }

    public void validatePrice(int price) {
        if (price < LottoConstants.LOTTO_PRICE) {
            throw new IllegalArgumentException(LOTTO_PRICE_MINIMUM_ERROR);
        }
        if (price % LottoConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LOTTO_PRICE_UNIT_ERROR);
        }
    }

}
