package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.util.ErrorMessage;
import lotto.util.NumberGenerate;

public class LottoMachine {

    public static final int LOTTO_PRICE = 1000;
    public static final int MONEY_MAX = 1_000_000;
    public static final int LOTTO_NUM_START = 1;
    public static final int LOTTO_NUM_END = 45;
    public static final int LOTTO_NUM_SIZE = 6;

    private final NumberGenerate lottoGenerate;
    private int money;

    public LottoMachine(NumberGenerate numberGenerate) {
        this.lottoGenerate = numberGenerate;
    }

    public PurchasedLottos issueLotto(int money) {
        validateMoney(money);
        int lottoCount = calculateLottoCount(money);

        List<Lotto> lottos = new ArrayList<>();
        for (int cnt = 0; cnt < lottoCount; cnt++) {
            List<Integer> numbers = lottoGenerate.randomGenerateInRange(LOTTO_NUM_START, LOTTO_NUM_END, LOTTO_NUM_SIZE);
            lottos.add(new Lotto(numbers));
        }
        
        this.money = money;
        return new PurchasedLottos(lottos);
    }

    public LottoResult calculateLottoWins(PurchasedLottos purchasedLotto, WinningLotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : purchasedLotto.lottos()) {
            boolean bonus = false;
            List<Integer> lottoNums = lotto.numbers();

            long count = sameNumberCountOf(winningLotto, lottoNums);
            if (lottoNums.contains(winningLotto.bonusNumber())) {
                bonus = true;
            }
            ranks.add(calculateRank(count, bonus));
        }
        return LottoResult.from(ranks);
    }

    private long sameNumberCountOf(WinningLotto winningLotto, List<Integer> lottoNums) {
        return winningLotto.numbers()
                .stream()
                .filter(lottoNums::contains)
                .count();
    }

    private Rank calculateRank(long count, boolean bonus) {
        return Rank.calculateRank(count, bonus);
    }

    private int calculateLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    public int inMoney() {
        return money;
    }

    private void validateMoney(int money) {
        validateMoneyLessThenMax(money);
        validateMoneyLessThenZero(money);
        validateMoneyModLottoPrice(money);
    }

    private void validateMoneyModLottoPrice(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_NOT_MODED_PRICE.getMsg());
        }
    }

    private void validateMoneyLessThenZero(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_LESS_THEN_MINIMUM.getMsg());
        }
    }

    private void validateMoneyLessThenMax(int money) {
        if (money > MONEY_MAX) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_MORE_THEN_MAXIMUM.getMsg());
        }
    }
}
