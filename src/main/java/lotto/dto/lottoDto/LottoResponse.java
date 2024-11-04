package lotto.dto.lottoDto;

import java.util.List;
import lotto.model.Lotto;

public record LottoResponse(int lottoCount, List<Lotto> issuedLotto) {
}
