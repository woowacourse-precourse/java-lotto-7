package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.enums.LottoConstants;

public class LottoStore {

    public List<Lotto> orderLottos(Integer pay) {
        return generateLottos(getLottoTicketCount(pay));
    }

    private List<Lotto> generateLottos(Integer lottoTicketCount) {
        List<Lotto> lottos = new ArrayList<Lotto>();
        for (int i = 0; i < lottoTicketCount; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    private Integer getLottoTicketCount(Integer pay) {
        return pay / LottoConstants.LOTTO_PRICE.getValue();
    }

}
