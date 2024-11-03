package lotto.model.lotto;

import lotto.model.Winning;
import lotto.model.lotto_result.DrawNumbers;

import java.util.List;
import java.util.Optional;

public class LottoMachine {

    private final DrawNumbers drawNumbers;

    public LottoMachine(DrawNumbers drawNumbers) {
        this.drawNumbers = drawNumbers;
    }

    public List<Integer> createLottoNumbers() {
        return numberGenerator.generate();
    }

    }
}
