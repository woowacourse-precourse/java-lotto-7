package lotto.service.purchase;

import java.util.Optional;
import lotto.domain.Lotto;

public interface LottoGameService {
    Optional<Lotto> register();
}