package lotto;

import lotto.Model.Model;
import lotto.View.InputView;
import lotto.View.OutputView;

public class Controller {
    public InputView input;
    public OutputView output;
    public Model model;
    public int count;

    public Controller(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        this.count = input.getPurchaseCount();
        this.model = new Model(this.count);
    }

}
