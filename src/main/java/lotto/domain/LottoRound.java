package lotto.domain;

import java.util.List;
import lotto.config.validation.FieldValidation;
import lotto.config.validation.annotation.Length;

public class LottoRound extends FieldValidation {

    @Length(min = 1)
    private final List<Lotto> round;

    public LottoRound(List<Lotto> round) {
        this.round = round;

        super.valid();
    }
}
