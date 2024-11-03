package lotto.service;

import lotto.constants.LottoConstants;
import lotto.validation.PurchaseAmountValidator;
import lotto.validation.WinningNumberValidator;

import java.util.Arrays;
import java.util.List;

public class LottoServiceImpl implements LottoService {
    private int calculateLottoCount(String purchaseAmountInput) {
        PurchaseAmountValidator.validatePurchaseAmountInput(purchaseAmountInput);
        int purchaseAmount = parsePurchaseAmount(purchaseAmountInput);
        PurchaseAmountValidator.validatePurchaseAmount(purchaseAmount);

        return convertToLottoCount(purchaseAmount);
    }

    @Override
    public List<Integer> parseWinningNumbers(String winningNumbersInput) {
        WinningNumberValidator.validateWinningNumbersInput(winningNumbersInput);

        return Arrays.stream(winningNumbersInput.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    private int parsePurchaseAmount(String purchaseAmountInput) {
        return Integer.parseInt(purchaseAmountInput);
    }

    private int convertToLottoCount(int purchaseAmount) {
        return purchaseAmount / LottoConstants.LOTTO_PRICE_BASE_UNIT;
    }
}
