package lotto.domain.lotto;

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
        validateDuplicationLottoNumbers(randomNumbers);
        return randomNumbers;
    }

    private void validateDuplicationLottoNumbers(List<Integer> randomNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : randomNumbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다. 중복된 번호: " + number);
            }
        }
    }

}
