package lotto.application.dto.response;

import java.util.List;
import lotto.domain.lotto.Lotto;

public record PurchaseLottoResponse(
    Integer lottoCount,
    List<Lotto> lottos
) implements Response {}
