package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoMaker {

    public List<Lotto> generateLotteries(int inputPurchaseAmount) {
        List<Lotto> lotteries = new ArrayList<>();
        int lottoTicket = calculateMoneyToLotto(inputPurchaseAmount);
        for (int i = 0; i < lottoTicket; i++) {
            lotteries.add(new Lotto(makeLottoNumber()));
        }
        return lotteries;
    }

    public static int transInputToInt(String inputPurchaseAmount) {
        try {
            int amount = Integer.parseInt(inputPurchaseAmount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해 주세요.");
        }
    }

    private int calculateMoneyToLotto(int money) {
        moneyValidate(money);
        int lottoTicket = money / 1000;
        return lottoTicket;
    }

    private void moneyValidate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000단위의 금액만 받습니다.");
        }

    }

    public List<Integer> makeLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
