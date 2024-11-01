package lotto;

import lotto.Model.Lotto;
import lotto.Model.Model;
import lotto.View.InputView;
import lotto.View.OutputView;

public class Controller {
    public InputView input;
    public OutputView output;
    public Model model;
    public int tryCount;

    public Controller(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        purchase();

        getPrizeNumber();

        printResult();
    }

    private void purchase() {
        this.tryCount = input.getPurchaseCount();
        this.model = new Model(this.tryCount);
        output.printLottoNum(model.getNumbers());
    }

    private void getPrizeNumber() {
        model.setWinNumbers(new Lotto(input.getWinNumber()).getNumbers());
        model.setBonusNumber(input.getBonusNum());
        model.countPrizeNum();
    }

    private void printResult() {
        output.printPrize(model.getPrizeNum(), tryCount, model.sumPrizeMoney());
    }

}
