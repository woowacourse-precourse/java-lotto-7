package lotto.model;

import java.util.List;

public class Customer {
    private final Money budget;
    private final MyLotto myLotto;

    public Customer(Money budget, MyLotto myLotto) {
        this.budget = budget;
        this.myLotto = myLotto;
    }

    public void buyLotto(List<Lotto> lottos) {
        lottos.forEach(myLotto::addLotto);
    }

    public List<WinningType> checkMyLotto(AnswerNumbers answerNumbers, BonusNumber bonusNumber) {
        return myLotto.checkWinningLotto(answerNumbers, bonusNumber);
    }
}
