package validator;

import static view.message.ExceptionMessage.DUPLICATE_NUMBER_EXCEPTION_MESSAGE;
import static view.message.ExceptionMessage.LOTTO_NUMBERS_COUNT_EXCEPTION_MESSAGE;
import static view.message.ExceptionMessage.LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbersValidator {

    public static void validateLottoNumbers(List<Integer> lottoNumbers) {
        validateLottoNumbersCount(lottoNumbers);
        validateLottoNumberRange(lottoNumbers);
        validateDuplicateNumber(lottoNumbers);
    }

    private static void validateLottoNumbersCount(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_COUNT_EXCEPTION_MESSAGE);
        }
    }

    private static void validateLottoNumberRange(List<Integer> lottoNumbers) {
        for (Integer lottoNumber : lottoNumbers) {
            if (lottoNumber < 1 || lottoNumber > 45) {
                throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE);
            }
        }
    }

    private static void validateDuplicateNumber(List<Integer> lottoNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer lottoNumber : lottoNumbers) {
            if (!uniqueNumbers.add(lottoNumber)) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER_EXCEPTION_MESSAGE + lottoNumber);
            }
        }
    }
}
