package lotto.purchase.application;

import lotto.checker.domain.Lottos;
import lotto.purchase.domain.FortuneMachine;
import lotto.purchase.domain.Money;

public class FortuneMachineService {

    private final FortuneMachine fortuneMachine;

    public FortuneMachineService(FortuneMachine fortuneMachine) {
        this.fortuneMachine = fortuneMachine;
    }

    public Lottos getLotto(Money money) {
        return fortuneMachine.buyLotto(money);
    }

}
