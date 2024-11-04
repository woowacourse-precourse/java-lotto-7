package controller;

import domain.LottoResult;
import lotto.Lotto;
import view.InputView;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        LottoResult result = getTotalCost();
        setLottoAmount(result);

    }

    private LottoResult getTotalCost() {
        LottoResult result = new LottoResult();
        String purchaseAmount = inputView.getCost();
        result.setPurchaseAmount(Integer.parseInt(purchaseAmount));
        return result;
    }

    private void setLottoAmount(LottoResult result) {
        result.setTotalLottos(result.getPurchaseAmount() / 1000);
    }
}
