package lotto.dto;

import lotto.model.Lotto;

public record LottoWinningNumbers(Lotto winningLotto, int bonusNumber) {
}
