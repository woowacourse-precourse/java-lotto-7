package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private final long moneyAmount;
    public static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos;

    public User(String moneyAmount) {
        this.moneyAmount = Long.parseLong(moneyAmount);
        this.lottos = new ArrayList<>();
    }

    public long getMoneyAmount() {
        return moneyAmount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Lotto> buyLotto() {
        long lottoCount = moneyAmount / LOTTO_PRICE;

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumbers);
            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }
}
