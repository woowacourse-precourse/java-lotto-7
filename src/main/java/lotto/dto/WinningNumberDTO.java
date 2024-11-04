package lotto.dto;

import lotto.model.Lotto;

public record WinningNumberDTO(Lotto winningLotto, int bonusNumber) {
}
