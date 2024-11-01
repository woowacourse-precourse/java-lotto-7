package lotto.service;

import lotto.constants.LottoConstants;
import lotto.validation.PurchaseAmountValidator;
import lotto.validation.WinningNumberValidator;

import java.util.Arrays;
import java.util.List;

public class LottoServiceImpl implements LottoService {
    @Override
    public int calculateLottoCount(String purchaseAmountInput) {
        PurchaseAmountValidator.validatePurchaseAmountInput(purchaseAmountInput);

        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        PurchaseAmountValidator.validatePurchaseAmount(purchaseAmount);

        return calculateLottoCountFromAmount(purchaseAmount);
    }

    @Override
    public List<Integer> parseWinningNumbers(String winningNumbersInput) {
        WinningNumberValidator.validateWinningNumbersInput(winningNumbersInput);

        return Arrays.stream(winningNumbersInput.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    private int calculateLottoCountFromAmount(int purchaseAmount) {
        return purchaseAmount / LottoConstants.LOTTO_PRICE;
    }
}
