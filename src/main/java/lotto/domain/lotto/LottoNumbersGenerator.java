package lotto.domain.lotto;

import lotto.exception.ExceptionMessages;
import lotto.validator.LottoValidator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbersGenerator {
    private final LottoValidator lottoValidator;

    public LottoNumbersGenerator(LottoValidator lottoValidator) {
        this.lottoValidator = lottoValidator;
    }

    public List<Integer> generateLottoNumbers(List<Integer> randomNumbers) {
        lottoValidator.validateLottoRange(randomNumbers);
        lottoValidator.validateLottoNumbersDuplication(randomNumbers);
        return randomNumbers;
    }
}
