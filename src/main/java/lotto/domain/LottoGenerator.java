package lotto.domain;

import lotto.utils.RandomNumbersSelector;
import lotto.utils.SortUtils;

import java.util.List;

public class LottoGenerator {

    public List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = RandomNumbersSelector.selectRandomNumbers();
        validateLottoRange(lottoNumbers);
        return SortUtils.sortNumbers(lottoNumbers);
    }

    private void validateLottoRange(List<Integer> lottoNumbers) {
        for (Integer number : lottoNumbers) {
            if (number < 1 | number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 정수여야 합니다. 잘못된 번호: " + number);
            }
        }
    }
}
