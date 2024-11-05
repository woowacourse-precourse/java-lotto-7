package lotto.dto;

import lotto.model.Lotto;

public record WinningNumberDto(Lotto lotto, int bonus) {
}
