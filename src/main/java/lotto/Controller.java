package lotto;

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
        this.tryCount = input.getPurchaseCount();
        this.model = new Model(this.tryCount);
        output.printLottoNum(model.getNumbers());
        model.setWinNumbers(input.getWinNumber());
        model.setBonusNumber(input.getBonusNum());
        model.countPrizeNum();
    }

}
