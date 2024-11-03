package lotto.service;

import lotto.domain.FortuneMachine;
import lotto.domain.Lottos;
import lotto.domain.Money;

public class FortuneMachineService {

    FortuneMachine fortuneMachine;

    public FortuneMachineService(FortuneMachine fortuneMachine) {
        this.fortuneMachine = fortuneMachine;
    }

    public Lottos getLotto(Money money) {
        return fortuneMachine.buyLotto(money);
    }

}
