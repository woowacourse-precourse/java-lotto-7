package lotto.purchase;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.statistics.LottoBall;

class LottoGenerator {

    private static final int LOTTO_BALL_COUNT = 6;

    private final List<MyLotto> lotteries;

    LottoGenerator() {
        this.lotteries = new ArrayList<>();
    }

    public List<MyLotto> createLotteries(int totalLotteryCount) {
        for (int i = 0; i < totalLotteryCount; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                    LottoBall.MIN_NUMBER.getValue(),
                    LottoBall.MAX_NUMBER.getValue(),
                    LOTTO_BALL_COUNT);
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
