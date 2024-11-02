package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.Purchase;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PurchaseController {
    private final int PRICE_OF_SINGLE_LOTTO = 1000;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private final ResultController resultController = new ResultController();

    public void processLottoGame() {
        Purchase purchase = makePurchase();
        List<Prize> result = countResult(purchase);
        showStatistic(result,purchase.getBoughtLottos().size() * PRICE_OF_SINGLE_LOTTO);
    }

    private Purchase makePurchase() {
        int buyingAmount = inputView.getBuyingAmount();
        List<Lotto> boughtLottos = lottoNumberGenerator.issueLottos(buyingAmount / PRICE_OF_SINGLE_LOTTO);
        outputView.printBoughtLottoNumbers(getBoughtLottoNumbers(boughtLottos));
        return new Purchase(boughtLottos);
    }

    private List<List<Integer>> getBoughtLottoNumbers(List<Lotto> boughtLottos) {
        List<List<Integer>> boughtLottoNumbers = new ArrayList<>();
        for (Lotto lotto : boughtLottos) {
            boughtLottoNumbers.add(lotto.getNumbers());
        }
        return boughtLottoNumbers;
    }

    private List<Prize> countResult(Purchase purchase) {
        List<Integer> winningNumbers = inputView.getWinningNumbers();
        int bonusNumber = inputView.getBonusNumber(winningNumbers);

        purchase.checkEachLottosResult(winningNumbers, bonusNumber);
        List<Prize> prizes = new ArrayList<>();
        for (Lotto lotto : purchase.getBoughtLottos()) {
            prizes.add(lotto.getPrize());
        }
        return prizes;
    }

    private void showStatistic(List<Prize> prizes, int buyingAmount) {
        Map<Prize, Integer> matchCounts = resultController.makeWinningStatistic(prizes);
        String earningRatio = resultController.calculateEarningRatio(matchCounts, buyingAmount);
        outputView.printWinningStatistic(matchCounts, earningRatio);
    }
}
