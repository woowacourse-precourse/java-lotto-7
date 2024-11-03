package lotto.view;

import lotto.exception.LottoException;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String NUMBER_PATTERN = "\\d+";
    private static final String INSERT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final Integer LOTTO_PRICE = 1000;

    public Integer getPurchaseAmountInput() {
        System.out.println(INSERT_PURCHASE_AMOUNT_MESSAGE);
        return validateAndParsePurchaseAmount(readLine());
    }

    public Integer validateAndParsePurchaseAmount(String input) {
        validateNumber(input);
        int purchaseAmount = Integer.parseInt(input);
        validateAmount(purchaseAmount);
        return purchaseAmount;
    }

    public void validateNumber(String input) {
        if (!input.matches(NUMBER_PATTERN)) // 정수로 이루어진 문자열인지 검증 [0-9]+
            throw new IllegalArgumentException(LottoException.NUMBER_FORMAT_NOT_VALID.getMessage());
    }

    public void validateAmount(Integer purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) // 1,000원 단위로 나누어 떨어지지 않을 경우
            throw new IllegalArgumentException(LottoException.PURCHASE_AMOUNT_NOT_VALID.getMessage());
    }
}
