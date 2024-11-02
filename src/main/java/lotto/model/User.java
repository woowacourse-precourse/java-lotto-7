package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Result;

public class User {
    public User(String money) {
        Validator.purchasePriceValidate(money);
        this.money = Integer.parseInt(money);
    }

    private final int money;

    private int bonusNumber;

    public List<List<Integer>> lotteryTickets;

    public int getMoney() {
        return money;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<List<Integer>> getLotteryTickets() {
        return lotteryTickets;
    }

    public void specifyBonusNumber(String bonusNumber, List<Integer> numbers) {
        Validator.bonusNumberValidate(bonusNumber, numbers);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public void moneyToTicket(int money) {
        publishLotto(money / 1000);
    }

    public void publishLotto(int count) {
        lotteryTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotteryTickets.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }

    public Double lateOfReturn() {
        double returnMoney = 0;
        for (Result result : Result.values()) {
            returnMoney += result.getMoney() * result.getCount();
        }
        double result = returnMoney / money * 100;
        return (double) Math.round(result * 100) / 100.0;
    }
}
