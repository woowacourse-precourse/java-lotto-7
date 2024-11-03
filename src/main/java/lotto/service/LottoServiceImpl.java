package lotto.service;

import lotto.constants.LottoConstants;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import lotto.generator.RandomLottoNumberGenerator;
import lotto.validation.BonusNumberValidator;
import lotto.validation.PurchaseAmountValidator;
import lotto.validation.WinningNumberValidator;

import java.util.Arrays;
import java.util.List;

public class LottoServiceImpl implements LottoService {
    @Override
    public LottoTicket generateLottoTicket(String purchaseAmountInput) {
        int lottoCount = calculateLottoCount(purchaseAmountInput);
        return new LottoTicket(new RandomLottoNumberGenerator(), lottoCount);
    }

    @Override
    public WinningLotto createWinningLotto(String winningNumbersInput, String bonusNumberInput) {
        List<Integer> winningNumbers = parseWinningNumbers(winningNumbersInput);

        BonusNumberValidator.validateBonusNumberInput(bonusNumberInput);
        int bonusNumber = parseBonusNumber(bonusNumberInput);
        BonusNumberValidator.validateBonusNumber(winningNumbers, bonusNumber);

        return new WinningLotto(new Lotto(winningNumbers), bonusNumber);
    }

    private int calculateLottoCount(String purchaseAmountInput) {
        PurchaseAmountValidator.validatePurchaseAmountInput(purchaseAmountInput);
        int purchaseAmount = parsePurchaseAmount(purchaseAmountInput);
        PurchaseAmountValidator.validatePurchaseAmount(purchaseAmount);

        return convertToLottoCount(purchaseAmount);
    }

    private int parsePurchaseAmount(String purchaseAmountInput) {
        return Integer.parseInt(purchaseAmountInput.trim());
    }

    private int convertToLottoCount(int purchaseAmount) {
        return purchaseAmount / LottoConstants.LOTTO_PRICE_BASE_UNIT;
    }

    private List<Integer> parseWinningNumbers(String winningNumbersInput) {
        WinningNumberValidator.validateWinningNumbersInput(winningNumbersInput);

        return Arrays.stream(winningNumbersInput.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
    private int parseBonusNumber(String bonusNumberInput) {
        return Integer.parseInt(bonusNumberInput.trim());
    }
}
