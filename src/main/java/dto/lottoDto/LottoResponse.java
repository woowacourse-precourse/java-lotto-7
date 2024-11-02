package dto.lottoDto;

import java.util.List;
import lotto.Lotto;

public record LottoResponse(int lottoCount, List<Lotto> issuedLotto) {
}
