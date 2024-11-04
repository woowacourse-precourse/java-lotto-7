package lotto.model.user;

import static lotto.util.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.util.LottoConstant.LOTTO_NUMBER_END_WITH;
import static lotto.util.LottoConstant.LOTTO_NUMBER_START_WITH;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * LotteryNumbers : 자동 추첨된 로또 번호
 */
public class LottoNumbers {

    private final Set<Integer> lotteryNumbers;

    protected LottoNumbers() {
        lotteryNumbers = new HashSet<>(createLotteryNumbers());
    }

    protected Set<Integer> getLotteryNumbers() {
        return new HashSet<>(lotteryNumbers);
    }

    private List<Integer> createLotteryNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_START_WITH.getNumber(),
                LOTTO_NUMBER_END_WITH.getNumber(),
                LOTTO_NUMBER_COUNT.getNumber()
        );
    }

}
