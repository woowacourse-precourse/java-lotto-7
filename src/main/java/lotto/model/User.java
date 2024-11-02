package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Result;

public class User {

    public int money;

    public int bonusNumber;

    public List<List<Integer>> lotteryTickets = new ArrayList<>();

    public User(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money < 0 || (money % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 0원 이상의 1000원 단위로 나누어 떨어지는 금액을 입력해야합니다.");
        }
    }

    public void specifyBonusNumber(int bonusNumber) {
        bonusNumberValidate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void bonusNumberValidate(int bonusNumber) {
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR] 보너스 점수는 1~45인 정수를 입력 해야 합니다.");
        }
    }

    public void moneyToTicket(int money) {
        publishLotto(money / 1000);
    }

    public void publishLotto(int count) {
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
