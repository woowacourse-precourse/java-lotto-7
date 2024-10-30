package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoSystem {
    private static final String MONEY_NOT_DIVIDED_BY_1000 = "[ERROR] 로또 구입 금액은 1,000원 단위로 입력 가능합니다.";

    private static LottoCustomer customer = new LottoCustomer();

    public void sellLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(MONEY_NOT_DIVIDED_BY_1000);
        }
        customer.addBetMoney(money);
        for (int i = 0; i < money / 1000; ++i) {
            Lotto luckyLotto = createAutoLotto();
            customer.collectLotto(luckyLotto);
        }
    }

    private Lotto createAutoLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
