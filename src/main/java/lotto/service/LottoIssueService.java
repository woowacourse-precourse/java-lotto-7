package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Stream;
import lotto.constant.LottoConfiguration;
import lotto.model.Lotto;
import lotto.model.PurchasePrice;

public class LottoIssueService {

    public List<Lotto> issueLotto(PurchasePrice purchasePrice) {
        int issueCount = purchasePrice.getPrice() / LottoConfiguration.LOTTO_PRICE;
        return Stream.generate(this::generateLotto).limit(issueCount).toList();
    }

    private Lotto generateLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                LottoConfiguration.LOTTO_NUMBER_RANGE_START,
                LottoConfiguration.LOTTO_NUMBER_RANGE_END,
                LottoConfiguration.LOTTO_NUMBER_COUNT
        );
        return new Lotto(lottoNumbers);
    }
}
