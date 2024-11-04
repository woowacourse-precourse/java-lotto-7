package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.LottoWinnerPrize;
import lotto.model.PurchasedLotto;
import lotto.util.ErrorMessage;
import lotto.util.InputValidator;
import lotto.util.Separator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;

    private final InputValidator inputValidator;

    public LottoController(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        int lottoQuantity = purchaseAmount / LOTTO_PRICE;
        OutputView.printPurchaseAmount(lottoQuantity);

        PurchasedLotto purchasedLotto = new PurchasedLotto(lottoQuantity);
        OutputView.printPurchasedLottos(purchasedLotto.getLottos());

        LottoManager lottoManager = new LottoManager(createWinningLotto(), getBonusNumber());
        Map<LottoWinnerPrize, Integer> prizeCount = lottoManager.getWinningPrizes(purchasedLotto.getLottos());
        printPrize(prizeCount);

        double rateOfReturn = getRateOfReturn(prizeCount, purchaseAmount);
        OutputView.printRateOfReturn(rateOfReturn);
    }

    private double getRateOfReturn(Map<LottoWinnerPrize, Integer> prizeCount, int purchaseAmount) {
        int earnMoney = calculateTotalEarnMoney(prizeCount);
        return ((double) earnMoney / (purchaseAmount)) * 100;
    }

    private int calculateTotalEarnMoney(Map<LottoWinnerPrize, Integer> prizeCount) {
        return prizeCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                int purchaseAmount = parseInt(InputView.getPurchaseAmount());
                inputValidator.validatePurchaseAmount(purchaseAmount, LOTTO_PRICE);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto createWinningLotto() {
        while (true) {
            try {
                List<Integer> winningNumbers = Separator.splitWithCommaToInteger(InputView.getWinningNumbers());
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber() {
        while (true) {
            try {
                int bonusNumber = parseInt(InputView.getBonusNumber());
                inputValidator.validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TYPE_INT.getMessage());
        }
    }

    private void printPrize(Map<LottoWinnerPrize, Integer> prizeCount) {
        OutputView.promptWINNING_STATISTICS();
        List<LottoWinnerPrize> result = prizeCount.keySet()
                .stream()
                .sorted(Comparator.comparingInt(LottoWinnerPrize::getPrize))
                .toList();
        for (LottoWinnerPrize prize : result) {
            int count = prizeCount.get(prize);
            OutputView.printPrizeCount(prize.getDescription(), count);
        }
    }


}
