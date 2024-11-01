package lotto.domain;

import lotto.utils.SortUtils;
import lotto.validator.LottoValidator;

import java.util.List;

public class LottoGenerator {
    private final LottoValidator lottoValidator;

    public LottoGenerator(LottoValidator lottoValidator) {
        this.lottoValidator = lottoValidator;
    }

    public List<Integer> generateLottoNumbers(List<Integer> randomNumbers) {
        lottoValidator.validateLottoRange(randomNumbers);
        return SortUtils.sortNumbers(randomNumbers);
    }
}
