package dto.lottoDto;

import java.util.List;
import model.Lotto;

public record LottoResponse(int lottoCount, List<Lotto> issuedLotto) {
}
