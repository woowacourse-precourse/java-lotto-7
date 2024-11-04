package lotto.model;

import lotto.model.exception.LottoNumberInvalidException;
import lotto.model.number.LottoNumber;
import lotto.model.number.LottoNumbers;
import lotto.model.number_generator.RandomNumberGenerator;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private final LottoNumbers lottoNumbers;

    private Lotto(LottoNumbers lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto generate(RandomNumberGenerator randomNumberGenerator) {
        return new Lotto(LottoNumbers.generate(LOTTO_NUMBER_SIZE, randomNumberGenerator));
    }

    private void validateLottoNumbers(LottoNumbers lottoNumbers) {
        if (!lottoNumbers.hasSize(LOTTO_NUMBER_SIZE)) {
            String detail = String.format("로또 번호의 개수는 %d 개여야 합니다.", LOTTO_NUMBER_SIZE);
            throw LottoNumberInvalidException.lottoNumberSize(detail);
        }
        if (!lottoNumbers.hasUniqueElements()) {
            throw LottoNumberInvalidException.lottoNumberDuplicate();
        }
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean containsLottoNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
