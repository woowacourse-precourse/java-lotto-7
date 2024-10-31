package lotto;

import java.util.List;

public class LottoRunner {

    private final LottoMachine machine;
    private final LottoSystem system;

    public LottoRunner() {
        this.machine = new LottoMachine();
        system = new LottoSystem();
    }

    public void start() {
        List<Lotto> lotties = machine.issueRandomLotto();
        system.announceWinningLotto();

        Calculator calculator = new Calculator(lotties, system.getWinningLotto(), system.getBonusNum());
        System.out.println(calculator.getResult());
        System.out.println(calculator.getRateOfReturn());
    }
}
