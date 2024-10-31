package lotto;

import lotto.io.ProgramOutput;
import lotto.io.UserInput;

import java.util.List;

public class Application {
    private final ProgramOutput output;
    private final UserInput input;

    public Application() {
        this.output = new ProgramOutput();
        this.input = new UserInput();
    }

    public void run() {
        output.requestPurchaseAmount();
        int amount = input.getPurchaseAmount();

        List<Lotto> purChasedLotto = new LottoShop(amount).getPurChasedLotto();

    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application lottery = new Application();
        lottery.run();
    }
}
