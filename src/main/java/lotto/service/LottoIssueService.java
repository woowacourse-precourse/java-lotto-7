package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.util.LottoConstant;

public class LottoIssueService {

    public List<Lotto> issueLottos(int issueNumber) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < issueNumber; i++) {
            lottos.add(issueOneLotto());
        }
        return lottos;
    }

    public Lotto issueOneLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(
                LottoConstant.LOTTO_NUMBER_RANGE_START,
                LottoConstant.LOTTO_NUMBER_RANGE_END,
                LottoConstant.THE_NUMBER_OF_LOTTO_NUMBER));
    }
}
