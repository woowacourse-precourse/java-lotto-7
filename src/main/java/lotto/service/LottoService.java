package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.LottoWinnerPrize;
import lotto.model.PurchasedLotto;
import lotto.util.ErrorMessage;
import lotto.util.InputValidator;
import lotto.util.Separator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENT = 100;

    private final InputValidator inputValidator;

    public LottoService(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int calculateLottoQuantity(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public PurchasedLotto createPurchasedLotto(int lottQuantity) {
        return new PurchasedLotto(lottQuantity);
    }

    public LottoManager createLottoManager(Lotto winningLotto, int bonusNumber) {
        return new LottoManager(winningLotto, bonusNumber);
    }

    public double getRateOfReturn(Map<LottoWinnerPrize, Integer> prizeCount, int purchaseAmount) {
        int earnMoney = calculateTotalEarnMoney(prizeCount);
        return ((double) earnMoney / (purchaseAmount)) * PERCENT;
    }

    public List<LottoWinnerPrize> getPrizeList(Map<LottoWinnerPrize, Integer> prizeCount) {
        return prizeCount.keySet()
                .stream()
                .sorted(Comparator.comparingInt(LottoWinnerPrize::getPrize))
                .toList();
    }

    public Lotto createWinningLotto(String winningNumbersInput) {
        return new Lotto(Separator.splitWithCommaToInteger(winningNumbersInput));
    }

    public int getPurchaseAmount(String purchaseAmountInput) {
        int purchaseAmount = parseInt(purchaseAmountInput);
        inputValidator.validatePurchaseAmount(purchaseAmount, LOTTO_PRICE);
        return purchaseAmount;
    }

    public int getBonusNumber(String bonusNumberInput) {
        int bonusNumber = parseInt(bonusNumberInput);
        inputValidator.validateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TYPE_INT.getMessage());
        }
    }

    private int calculateTotalEarnMoney(Map<LottoWinnerPrize, Integer> prizeCount) {
        return prizeCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

}
