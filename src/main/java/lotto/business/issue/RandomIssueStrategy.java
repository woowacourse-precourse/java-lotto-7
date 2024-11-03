package lotto.business.issue;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.lotto.Lotto.LOTTO_SIZE;
import static lotto.lotto.LottoNumber.MAX_NUMBER_INCLUSIVE;
import static lotto.lotto.LottoNumber.MIN_NUMBER_INCLUSIVE;

import java.util.ArrayList;
import java.util.List;
import lotto.lotto.Lotto;
import lotto.lotto.LottoNumber;

public class RandomIssueStrategy implements IssueStrategy {
    @Override
    public Lotto issue() {
        List<Integer> randomNumbers =
                pickUniqueNumbersInRange(MIN_NUMBER_INCLUSIVE, MAX_NUMBER_INCLUSIVE, LOTTO_SIZE);
        List<LottoNumber> lottoNumbers = randomNumbers.stream().map(LottoNumber::new).toList();
        return new Lotto(lottoNumbers);
    }

    @Override
    public List<Lotto> issueMany(int numOfLotto) {
        List<Lotto> lotteries = new ArrayList<>(numOfLotto);
        for (int i = 0; i < numOfLotto; i++) {
            lotteries.add(issue());
        }
        return lotteries;
    }
}
