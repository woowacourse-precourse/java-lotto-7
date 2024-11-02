package lotto.purchase;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private final List<MyLotto> lotteries;

    public LottoGenerator() {
        this.lotteries = new ArrayList<>();
    }

    public List<MyLotto> createLotteries(int totalLotteryCount) {
        for (int i = 0; i < totalLotteryCount; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            manufactureRawNumbers(randomNumbers);
            lotteries.add(new MyLotto(randomNumbers));
        }
        return lotteries;
    }

    public void manufactureRawNumbers(List<Integer> rawNumbers) {
        Collections.sort(rawNumbers);
    }
}
