package lotto;

import constants.Constants;
import constants.ErrorMessage;
import java.util.HashSet;
import java.util.List;

public class LottoValidator {

    public static void validate(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        checkDuplicate(lottoNumbers);
    }

    private static void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MATCH_LOTTO_SIZE);
        }
    }

    private static void checkDuplicate(List<LottoNumber> lottoNumbers) {
        if (new HashSet<>(lottoNumbers).size() < lottoNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.EXISTS_DUPLICATE_NUMBER);
        }
    }
}
