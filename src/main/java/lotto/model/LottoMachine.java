package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final long LOTTERY_PRICE = 1000;
    static int lotteryCnt;
    static List<Lotto> lottos;

    public LottoMachine() {
    }

    public void start(long amount) {
        lotteryCnt = calculateLotteryCount(amount);
        lottos = new ArrayList<>();
        for (int i = 0; i < lotteryCnt; i++) {
            issueLottos();
        }
    }

    private static int calculateLotteryCount(long amount) {
        return Math.toIntExact(amount / LOTTERY_PRICE);
    }

    private static void issueLottos() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        Lotto lotto = new Lotto(numbers);
        lottos.add(lotto);
    }

    public int getLotteryCnt() {
        return lotteryCnt;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
