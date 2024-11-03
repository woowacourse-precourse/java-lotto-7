package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {
    private final Money budget;
    private Money totalWinningMoney;
    private final MyLotto myLotto;
    private final Map<WinningType, Integer> winningHistory;

    public Customer(Money budget,
                     MyLotto myLotto,
                     Money totalWinningMoney,
                     Map<WinningType, Integer> winningHistory) {
        this.budget = budget;
        this.myLotto = myLotto;
        this.totalWinningMoney = totalWinningMoney;
        this.winningHistory = winningHistory;
    }

    public Customer(Money budget, MyLotto myLotto) {
        this(budget, myLotto, new Money("0"), new HashMap<>());
    }

    public void buyLotto(List<Lotto> lottos) {
        lottos.forEach(myLotto::addLotto);
    }

    public float getEarningRate(AnswerNumbers answerNumbers, BonusNumber bonusNumber) {
        checkMyLotto(answerNumbers, bonusNumber);
        return (float)totalWinningMoney.getValue() / budget.getValue();
    }

    public long getBudget() {
        return budget.getValue();
    }

    private void checkMyLotto(AnswerNumbers answerNumbers, BonusNumber bonusNumber) {
        myLotto.checkWinningLotto(answerNumbers, bonusNumber)
                .forEach(this::addWinningHistory);
        calculateTotalWinningMoney();
    }

    private void calculateTotalWinningMoney() {
        winningHistory.forEach((type, count) ->
                totalWinningMoney = totalWinningMoney.add(
                        getTotalValueOfType(type, count))
        );
    }

    private long getTotalValueOfType(WinningType type, Integer count) {
        return type.getPrize() * count;
    }

    private void addWinningHistory(WinningType type) {
        winningHistory.put(type, winningHistory.getOrDefault(type, 0) + 1);
    }
}
