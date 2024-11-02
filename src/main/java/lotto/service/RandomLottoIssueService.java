package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.Lotto;
import lotto.model.db.LottoRepository;

public class RandomLottoIssueService implements LottoIssueService {

    private final LottoRepository lottoRepository = LottoRepository.getInstance();

    @Override
    public List<Lotto> issue(int lottoCnt) {
        return lottoRepository.save(
                IntStream.range(0, lottoCnt)
                        .mapToObj(lotto -> issueRandomLotto())
                        .toList());
    }

    private static Lotto issueRandomLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}

