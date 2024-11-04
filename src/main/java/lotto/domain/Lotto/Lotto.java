package lotto.domain.Lotto;

import static lotto.domain.Lotto.LottoConstants.LOTTO_NUMBER_SIZE;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final String INVALID_NUMBER_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String INVALID_DUPLICATED_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private final List<LottoNumber> lottoLottoNumbers;

    protected Lotto(List<LottoNumber> lottoNumbers) {
        validateLotto(lottoNumbers);
        this.lottoLottoNumbers = sortLottoNumber(lottoNumbers);
    }

    private List<LottoNumber> sortLottoNumber(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .sorted(Comparator.comparing(LottoNumber::getValue))
                .collect(Collectors.toList());
    }

    private void validateLotto(List<LottoNumber> lottoNumbers) {
        validateNumberSize(lottoNumbers);
        validateDuplicatedNumber(lottoNumbers);
    }

    private void validateNumberSize(List<LottoNumber> lottoNumbers) {
        if (isValidNumberSize(lottoNumbers)) {
            throw new IllegalArgumentException(INVALID_NUMBER_SIZE_ERROR_MESSAGE);
        }
    }

    private boolean isValidNumberSize(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != LOTTO_NUMBER_SIZE;
    }

    private void validateDuplicatedNumber(List<LottoNumber> lottoNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            if (hasDuplicatedNumber(uniqueNumbers, lottoNumber)) {
                throw new IllegalArgumentException(INVALID_DUPLICATED_ERROR_MESSAGE);
            }
        }
    }

    private boolean hasDuplicatedNumber(Set<Integer> uniqueNumbers, LottoNumber lottoNumber) {
        return !uniqueNumbers.add(lottoNumber.getValue());
    }

    @Override
    public String toString() {
        return lottoLottoNumbers.stream()
                .map(number -> String.valueOf(number.getValue()))
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoLottoNumbers);
    }
}
