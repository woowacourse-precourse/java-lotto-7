package lotto.controller;

import java.util.ArrayList;
import lotto.model.cost.CostUnit;
import lotto.model.lotto.CheckLotto;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView;
    private final InputView inputView;
    private Lotto lotto;
    private LottoNumbers lottoNumbers;
    private CheckLotto checkLotto;
    private int cost;
    private int purchaseCount;
    private int bonusNumber;

    public LottoController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        requestCost();

        selectLottoNumbers();

        requestWinningNumbers();

        requestBonusNumber();

        displayWinningStatus();

        displayEarningRatio();

    }

    private void requestCost() {
        outputView.showStartComment();

        cost = requestCostInput();

        purchaseCount = cost / CostUnit.COST_UNIT.getUnit();

        outputView.showInsertNewLine();
    }

    private void selectLottoNumbers() {
        outputView.showPurchaseResult(purchaseCount);

        lottoNumbers = LottoNumbers.from(new ArrayList<>());

        lottoNumbers.purchaseLotto(purchaseCount, outputView);

        outputView.showInsertNewLine();
    }

    private void requestWinningNumbers() {
        outputView.showRequestLottoNumberComment();

        lotto = requestLottoNumberInput();

        outputView.showInsertNewLine();
    }

    private void requestBonusNumber() {
        outputView.showRequestBonusNumberComment();

        bonusNumber = requestBonusNumberInput(lotto);

        outputView.showInsertNewLine();
    }

    private void displayWinningStatus() {
        outputView.showWinningStatistics();

        checkLotto = CheckLotto.create();

        checkLotto.checkLottoNumbers(lottoNumbers, lotto, bonusNumber);

        outputView.showWinningResult(checkLotto.getThreeMatched(), checkLotto.getFourMatched(),
                checkLotto.getFiveMatched(), checkLotto.getBonusMatched(), checkLotto.getAllMatched());
    }

    private void displayEarningRatio() {
        String earningRatio = checkLotto.getEarningRatio(cost);
        outputView.showTotalEarningRatio(earningRatio);
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
