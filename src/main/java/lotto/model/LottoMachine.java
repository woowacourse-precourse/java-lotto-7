package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final long LOTTERY_PRICE = 1000;
    static List<Lotto> lottos;

    public LottoMachine() {
    }

    public void start(long amount) {
        int lotteryCnt = calculateLotteryCount(amount);
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
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        Lotto lotto = new Lotto(sortedNumbers);
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
