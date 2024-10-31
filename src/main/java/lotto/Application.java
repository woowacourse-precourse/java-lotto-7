package lotto;

import lotto.io.ProgramOutput;

public class Application {
    private final ProgramOutput output;

    public Application() {
        this.output = new ProgramOutput();
    }

    public void run() {
        output.requestPurchaseAmount();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application lottery = new Application();
        lottery.run();
    }
}
