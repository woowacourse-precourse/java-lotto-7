package lotto;


import lotto.domain.Lotties;
import lotto.domain.LottiesFactory;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.model.Budget;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Budget budget = inputView.readBudget();
        Lotties lotties = LottiesFactory.purchaseLotties(budget);
        outputView.printNumberOfLotto(lotties.size());
        outputView.printLotties(lotties);

        WinningLotto winningLotto =  inputView.readWinningLotto();
        System.out.println(winningLotto);
    }
}
