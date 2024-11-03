package lotto.app.dto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PositiveNumber;

public record LottoPurchaseResponseDto(PositiveNumber price, List<Lotto> lottoList) {

}
