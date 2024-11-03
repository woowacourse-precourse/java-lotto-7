package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final String PRICE_ERROR_MESSAGE = "[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.";
    public static final int PRICE_UNIT = 1000;

    public static List<Lotto> purchaseLotto(int price) {
        validate(price);
        int ticketCount = price / PRICE_UNIT;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    private static void validate(int price) {
        if (price <= 0 || price % PRICE_UNIT != 0) {
            throw new IllegalArgumentException(PRICE_ERROR_MESSAGE);
        }
    }

    public LottoResult calculateResult(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        return new LottoResult(tickets, winningNumbers, bonusNumber);
    }
}
