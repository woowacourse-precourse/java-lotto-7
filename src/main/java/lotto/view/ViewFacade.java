package lotto.view;

import lotto.model.UserLottos;

import java.util.List;

public class ViewFacade {
    private final InputView inputView;
    private final OutputView outputView;

    public ViewFacade(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String getPurchaseAmount() {
        return inputView.getPurchaseAmount();
    }

    public String getLottoNumber() {
        return inputView.getLottoNumber();
    }

    public String getBonusNumber() {
        return inputView.getBonusNumber();
    }

    public void printUserLotto(UserLottos userLottos) {
        outputView.printUserLotto(userLottos);
    }

    public void printResult(List<Integer> results, String rate) {
        outputView.printResult(results, rate);
    }
}
