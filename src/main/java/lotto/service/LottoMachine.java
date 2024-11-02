package lotto.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.util.ErrorMessage;
import lotto.util.NumberGenerate;

public class LottoMachine {

    public static final int LOTTO_PRICE = 1000;

    private final NumberGenerate lottoGenerate;
    private int money;

    public LottoMachine(NumberGenerate numberGenerate) {
        this.lottoGenerate = numberGenerate;
    }

    public PurchasedLottos issueLotto(int money) {
        validateMoneyLessThenZero(money);
        validateMoneyModLottoPrice(money);
        int lottoCnt = money / LOTTO_PRICE;

        // 로또 발행
        List<Lotto> lottos = new ArrayList<>();
        for (int cnt = 0; cnt < lottoCnt; cnt++) {
            List<Integer> numbers = lottoGenerate.randomGenerateInRange();
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
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_NOT_MOD_PRICE.getMsg());
        }
    }

    private void validateMoneyLessThenZero(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMsg());
        }
    }

    public LottoResult winLotto(PurchasedLottos purchasedLotto, WinningLotto winningLotto) {
        long max = 0;
        boolean bonus = false;
        for (Lotto lotto : purchasedLotto.getLottos()) {
            List<Integer> lottoNums = lotto.lottoNums();
            long count = winningLotto.lottoNums()
                    .stream()
                    .filter(lottoNums::contains)
                    .count();
            max = Math.max(count, max);
            if (lottoNums.contains(winningLotto.bonusBall().getNum())) {
                bonus = true;
            }
        }

        return new LottoResult(calculateRank(max, bonus));
    }

    private static Rank calculateRank(long count, boolean bonus) {
        return Rank.calculateRank(count, bonus);
    }
}
