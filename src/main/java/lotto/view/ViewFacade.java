package lotto.view;

import lotto.model.UserNumber;
import lotto.model.UserNumbers;

import java.util.List;

public class ViewFacade {
    private final InputView inputView;
    private final OutputView outputView;

    public ViewFacade(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int getPurchaseAmount() {
        return inputView.getPurchaseAmount();
    }

    public String getLottoNumber() {
        return inputView.getLottoNumber();
    }

    public int getBonusNumber() {
        return inputView.getBonusNumber();
    }

    public void printUserLotto(UserNumbers userNumbers) {
        for (UserNumber userNumber : userNumbers.getUserNumbers()) {
            System.out.println(userNumber);
        }
    }

    public void printResult(List<Integer> results, int rate) {
        outputView.printResult(results, rate);
    }
}
