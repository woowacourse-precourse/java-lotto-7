package lotto.model;


import lotto.util.InputValidator;
import lotto.view.error.ErrorType;
import lotto.view.error.InputErrorException;

public class LottoCount {

    public static final int UNIT_PURCHASE_AMOUNT = 1000;

    public static final String NEED_THOUSAND_UNITS_OF_NUMBER = "구매 금액은 1000단위여야 합니다.";
    public static final int REST_IS_ZERO = 0;


    private final int lottoCount;
    private final InputValidator inputValidator;


    public LottoCount(String purchaseAmount, InputValidator inputValidator) {
        this.inputValidator = inputValidator;
        this.lottoCount = parsedLottoCount(purchaseAmount);
    }

    public int getLottoCount() {
        return lottoCount;
    }

    private int parsedLottoCount(String purchaseAmount) {
        int parsedAmount = getValidPurchaseAmount(purchaseAmount);

        return calculateLottoCount(parsedAmount);
    }

    private static int calculateLottoCount(int parsedAmount) {
        if (parsedAmount % UNIT_PURCHASE_AMOUNT != REST_IS_ZERO) {
            throw new InputErrorException(NEED_THOUSAND_UNITS_OF_NUMBER);
        }
        return parsedAmount / UNIT_PURCHASE_AMOUNT;
    }

    private int getValidPurchaseAmount(String purchaseAmount) {
        String trimmedPurchaseAmount = purchaseAmount.trim();
        inputValidator.validateOnlyDigit(trimmedPurchaseAmount);
        int parsedAmount = parseInt(trimmedPurchaseAmount);
        inputValidator.checkValidRange(parsedAmount);
        return parsedAmount;
    }

    private int parseInt(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new InputErrorException(ErrorType.NEED_INTEGER);
        }
    }

}