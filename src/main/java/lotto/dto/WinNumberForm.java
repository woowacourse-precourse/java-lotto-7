package lotto.dto;

import lotto.model.lotto.Bonus;
import lotto.model.lotto.Lotto;

public record WinNumberForm(Lotto lotto, Bonus bonus) {
}
