package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class ViewFacade {
    private final InputView inputView;
    private final OutputView outputView;

    public ViewFacade(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void getPurchaseAmount() {
        inputView.getPurchaseAmount();
    }

    public void getLottoNumber() {
        inputView.getLottoNumber();
    }

    public void getBonusNumber() {
        inputView.getBonusNumber();
    }

    public void printUserLotto(List<Integer> userLotto) {
        outputView.printUserLotto(userLotto);
    }

    public void printResult(List<Integer> results, int rate) {
        outputView.printResult(results, rate);
    }
}
