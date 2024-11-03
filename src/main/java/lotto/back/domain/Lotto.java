package lotto.back.domain;

import java.util.List;
import lotto.global.exception.DuplicatedLottoNumberException;
import lotto.global.exception.InvalidLottoNumberCountException;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream().map(LottoNumber::new).toList();
    }

    private void validate(List<Integer> lottoNumbers) {
        validateLottoNumberCount(lottoNumbers);
        validateDuplication(lottoNumbers);
    }

    private void validateLottoNumberCount(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new InvalidLottoNumberCountException();
        }
    }

    private void validateDuplication(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() != lottoNumbers.size()) {
            throw new DuplicatedLottoNumberException();
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream().map(LottoNumber::getLottoNumber).toList();
    }

    public Integer getDrawnNumberMatchCount(List<Integer> drawnNumbers) {
        // 추첨 번호와 동일한 로또 번호의 개수를 반환
        return (int) lottoNumbers.stream().map(LottoNumber::getLottoNumber).filter(drawnNumbers::contains).count();
    }

    public Integer getBonusMatchCount(Integer bonusNumber) {
        // 보너스 번호와 동일한 로또 번호의 개수를 반환
        return (int) lottoNumbers.stream().map(LottoNumber::getLottoNumber).filter(bonusNumber::equals).count();
    }
}