package lotto.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.util.NumberGenerate;

public class LottoMachine {

    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_RANGE_START = 1;
    public static final int LOTTO_RANGE_END = 45;

    private final NumberGenerate lottoGenerate;
    private int money;

    public LottoMachine(NumberGenerate numberGenerate) {
        this.lottoGenerate = numberGenerate;
    }

    public PurchasedLottos issueLotto(int money) {
        validateMoneyModLottoPrice(money);
        int lottoCnt = money / LOTTO_PRICE;

        // 로또 발행
        List<Lotto> lottos = new ArrayList<>();
        for (int cnt = 0; cnt < lottoCnt; cnt++) {
            List<Integer> numbers = lottoGenerate.randomGenerateInRange(LOTTO_RANGE_START, LOTTO_RANGE_END);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        
        this.money = money;
        return new PurchasedLottos(lottos);
    }

    public int inMoney() {
        return money;
    }

    private void validateMoneyModLottoPrice(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 돈은 천원 단위로 입력해야 합니다.");
        }
    }

    public LottoResult winLotto(PurchasedLottos purchasedLotto, WinningLotto winningLotto) {
        Set<Integer> prize = new HashSet<>();
        boolean bonus = false;
        for (Lotto lotto : purchasedLotto.getLottos()) {
            List<Integer> lottoNums = lotto.lottoNums();
            prize.addAll(winningLotto.lottoNums().stream()
                    .filter(lottoNums::contains)
                    .toList());

            if (lottoNums.contains(winningLotto.bonusBall().getNum())) {
                bonus = true;
            }
        }

        return new LottoResult(calculateRank(prize, bonus));
    }

    private static Rank calculateRank(Set<Integer> prize, boolean bonus) {
        return Rank.calculateRank(prize.size(), bonus);
    }
}
