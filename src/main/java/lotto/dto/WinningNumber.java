package lotto.dto;

import lotto.model.Lotto;

public record WinningNumber(Lotto winningLotto, int bonusNumber) {
}
