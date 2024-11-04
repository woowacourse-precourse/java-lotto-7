package lotto.service.issuing;

import lotto.model.Lottos;

public interface LottoIssuingService {
    Lottos issueLottos(int purchaseAmount);
}
