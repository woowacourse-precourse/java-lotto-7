package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView;
    private final InputView inputView;
    private Lotto lotto;
    private LottoNumbers lottoNumbers;
    private int cost;
    private int bonusNumber;

    public LottoController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        outputView.showStartComment();

        cost = requestCostInput();

        int purchaseCount = cost / 1000;

        outputView.showInsertNewLine();

        outputView.showPurchaseResult(purchaseCount);

        lottoNumbers = LottoNumbers.from(new ArrayList<>());

        lottoNumbers.purchaseLotto(purchaseCount, outputView);

        outputView.showInsertNewLine();

        outputView.showRequestLottoNumberComment();

        lotto = requestLottoNumberInput();

        outputView.showInsertNewLine();

        outputView.showRequestBonusNumberComment();

        bonusNumber = requestBonusNumberInput(lotto);

        outputView.showInsertNewLine();

        outputView.showWinningStatistics();

        int threeMatched = 0;
        int fourMatched = 0;
        int fiveMatched = 0;
        int bonusMatched = 0;
        int allMatched = 0;

        for (List<Integer> lottoNumber : lottoNumbers.getLottoNumbers()) {
            int lottoCount = 0;
            boolean isBonusMatched = lottoNumber.contains(bonusNumber);

            for (int number : lotto.getNumbers()) {
                if (lottoNumber.contains(number)) {
                    lottoCount++;
                }
            }

            if (lottoCount == 6) {
                allMatched++;
                continue;
            }
            if (lottoCount == 5 && isBonusMatched) {
                bonusMatched++;
                continue;
            }
            if (lottoCount == 5) {
                fiveMatched++;
                continue;
            }
            if (lottoCount == 4) {
                fourMatched++;
                continue;
            }
            if (lottoCount == 3) {
                threeMatched++;
            }
        }

        outputView.showWinningResult(threeMatched, fourMatched, fiveMatched, bonusMatched, allMatched);

        int totalWinnings = (5000 * threeMatched) + (50000 * fourMatched) +
                (1500000 * fiveMatched) + (30000000 * bonusMatched) +
                (2000000000 * allMatched);

        double earningRatio = ((double) totalWinnings / cost) * 100;
        String formatEarningRatio = String.format("%,.1f", earningRatio);
        outputView.showTotalEarningRatio(formatEarningRatio);

    }

    private int requestCostInput() {
        try {
            return inputView.getCost();
        } catch (NumberFormatException e) {
            outputView.showCostErrorMessage();
            return requestCostInput();
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e);
            return requestCostInput();
        }
    }

    private Lotto requestLottoNumberInput() {
        try {
            return inputView.getLottoNumber();
        } catch (NumberFormatException e) {
            outputView.showLottoNumberErrorMessage();
            return requestLottoNumberInput();
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e);
            return requestLottoNumberInput();
        }
    }

    private int requestBonusNumberInput(Lotto lotto) {
        try {
            return inputView.getBonusNumber(lotto);
        } catch (NumberFormatException e) {
            outputView.showBonusNumberErrorMessage();
            return requestBonusNumberInput(lotto);
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e);
            return requestBonusNumberInput(lotto);
        }
    }
}
