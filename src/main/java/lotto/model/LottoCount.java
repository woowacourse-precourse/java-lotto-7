package lotto.model;


import lotto.view.error.ErrorType;
import lotto.view.error.InputErrorException;

public class LottoCount {

    public static final String WHITE_SPACE_REGEX = "\\s";
    public static final int UNIT_PURCHASE_AMOUNT = 1000;
    public static final int MIN_PURCHASE_AMOUNT = 1000;

    public static final int MAX_PURCHASE_AMOUNT = 100000;
    public static final String EMPTY_STRING = "";
    public static final String NEED_NUMBER_IN_RANGE = "구매 금액은 1000이상 100000이하여야 합니다.";
    public static final String NEED_THOUSAND_UNITS_OF_NUMBER = "구매 금액은 1000단위여야 합니다.";


    private final int lottoCount;

    public LottoCount(String purchaseAmount) {
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
        if (parsedAmount % UNIT_PURCHASE_AMOUNT != 0) {
            throw new InputErrorException(NEED_THOUSAND_UNITS_OF_NUMBER);
        }
        return parsedAmount / UNIT_PURCHASE_AMOUNT;
    }

    private int getValidPurchaseAmount(String purchaseAmount) {
        String trimmedPurchaseAmount = purchaseAmount.trim();
        validateOnlyDigit(trimmedPurchaseAmount);
        int parsedAmount = parseInt(trimmedPurchaseAmount);
        checkValidRange(parsedAmount);
        return parsedAmount;
    }

    private void checkValidRange(int parsedAmount) {
        if (parsedAmount < MIN_PURCHASE_AMOUNT || parsedAmount > MAX_PURCHASE_AMOUNT) {
            throw new InputErrorException(NEED_NUMBER_IN_RANGE);
        }
    }

    private void validateOnlyDigit(String purchaseAmount) {
        checkIfEmpty(purchaseAmount);
        checkIfDigit(purchaseAmount);
    }

    private void checkIfEmpty(String purchaseAmount) {
        if (purchaseAmount.isEmpty()) {
            throw new InputErrorException(ErrorType.NEED_NOT_EMPTY);
        }
        if (purchaseAmount.replaceAll(WHITE_SPACE_REGEX, EMPTY_STRING).isEmpty()) {
            throw new InputErrorException(ErrorType.NEED_NOT_EMPTY);
        }
    }

    private void checkIfDigit(String purchaseAmount) {
        for (int i = 0; i < purchaseAmount.length(); i++) {
            if (!Character.isDigit(purchaseAmount.charAt(i))) {
                throw new InputErrorException(ErrorType.NEED_NUMBER);
            }
        }
    }

    private int parseInt(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new InputErrorException(ErrorType.NEED_INTEGER);
        }
    }

}