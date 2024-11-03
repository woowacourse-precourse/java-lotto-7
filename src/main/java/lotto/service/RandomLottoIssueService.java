package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.Lotto;
import lotto.model.db.Buyer;
import lotto.model.db.UserRepository;

public class RandomLottoIssueService implements LottoIssueService {

    private final UserRepository userRepository = UserRepository.getInstance();

    @Override
    public List<Lotto> issue(int lottoCnt) {
        List<Lotto> lotties = IntStream.range(0, lottoCnt)
                .mapToObj(lotto -> issueRandomLotto())
                .toList();
        userRepository.save(Buyer.from(lotties));
        return lotties;
    }

    private static Lotto issueRandomLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}

