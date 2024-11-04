package lotto.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class User {

    int money;
    List<Lotto> lottos = new ArrayList<>();

    public User(String inputMoney) {
        this.money = validateInputMoney(inputMoney);
        this.lottos = generateLotto(money);
    }

    public int getMoney() {
        return money;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private int validateInputMoney(String inputMoney) {
        try {
            return validatePurchaseMoney(Integer.parseInt(inputMoney));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력하였습니다.");
        }
    }

    private int validatePurchaseMoney(int money) {
        if (money % 1000 != 0 || money < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위 및 1,000원 이상이여야 합니다.");
        }
        return money;
    }


    private List<Lotto> generateLotto(int money) {
        int count = money / 1000;
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(pickUniqueNumbersInRange(1, 45, 6)))
                .collect(Collectors.toList());
    }


}
