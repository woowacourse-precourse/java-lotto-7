package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.model.db.Buyer;
import lotto.model.db.Lotto;

public class RandomLottoIssueService implements LottoIssueService {

    @Override
    public List<Lotto> issue(String prompt, int lottoCnt) {
        List<Lotto> lotties = IntStream.range(0, lottoCnt)
                .mapToObj(lotto -> issue(prompt))
                .toList();
        userRepository.save(Buyer.from(lotties));
        return lotties;
    }

    @Override
    public Lotto issue(String prompt) {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_NUM_SIZE));
    }
}

