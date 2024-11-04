package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Machine {
    public Machine(String money) {
        Validator.purchasePriceValidate(money);
        this.money = Integer.parseInt(money);
    }

    private final int money;

    public List<List<Integer>> lotteryTickets;

    public int getMoney() {
        return money;
    }

    public List<List<Integer>> getLotteryTickets() {
        return lotteryTickets;
    }

    public void publishLotto(int count) {
        lotteryTickets = new ArrayList<>();
        for (int i = 0; i < count / 1000; i++) {
            lotteryTickets.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }

    public Double lateOfReturn() {
        double returnMoney = 0;
        for (Result result : Result.values()) {
            returnMoney += result.getMoney() * result.getCount();
        }
        double result = returnMoney / money * 100;
        return (double) Math.round(result * 10) / 10.0;
    }
}
