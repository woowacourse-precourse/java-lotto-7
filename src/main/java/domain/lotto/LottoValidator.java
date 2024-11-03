package domain.lotto;

import constants.ErrorMessage;
import java.util.HashSet;
import java.util.List;

public class LottoValidator {

    private static final int LOTTO_SIZE = 6;

    public static void validate(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        checkDuplicate(lottoNumbers);
    }

    private static void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MATCH_LOTTO_SIZE);
        }
    }

    private static void checkDuplicate(List<LottoNumber> lottoNumbers) {
        if (new HashSet<>(lottoNumbers).size() < lottoNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.EXISTS_DUPLICATE_NUMBER);
        }
    }
}
