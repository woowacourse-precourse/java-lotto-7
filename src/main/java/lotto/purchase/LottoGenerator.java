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
            lotteries.add(new MyLotto(manufactureRawNumbers(randomNumbers)));
        }
        return lotteries;
    }

    public List<Integer> manufactureRawNumbers(List<Integer> rawNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>(rawNumbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
