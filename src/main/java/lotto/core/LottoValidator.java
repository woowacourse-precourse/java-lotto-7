package lotto.core;

import constants.Constants;
import constants.ErrorMessage;
import java.util.HashSet;
import java.util.List;

public enum LottoValidator {

    LOTTO_VALIDATOR;

    public void validate(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        checkDuplicate(lottoNumbers);
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MATCH_LOTTO_SIZE);
        }
    }

    private void checkDuplicate(List<LottoNumber> lottoNumbers) {
        if (new HashSet<>(lottoNumbers).size() < lottoNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.EXISTS_DUPLICATE_NUMBER);
        }
    }
}
