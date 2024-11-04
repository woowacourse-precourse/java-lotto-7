package lotto.dto.request;

import lotto.Lotto;

public record LottoResultRequest(Lotto lotto, int bonusNumber) {
}
