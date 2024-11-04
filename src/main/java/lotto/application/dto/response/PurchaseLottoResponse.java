package lotto.application.dto.response;

import java.util.List;
import lotto.domain.lotto.Lotto;

public record PurchaseLottoResponse(Integer numberOfLotto, List<Lotto> lottos, Integer totalCost) {

}
