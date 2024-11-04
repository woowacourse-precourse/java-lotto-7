package lotto.validation;

import static lotto.util.Constants.COUNT_OF_LOTTO_NUMBER;
import static lotto.util.Constants.DELIMITER;
import static lotto.util.Constants.ERROR_CONTAIN_LETTER_MSG;
import static lotto.util.Constants.ERROR_EXCEED_LOTTO_END_NUMBER_MSG;
import static lotto.util.Constants.ERROR_INIT;
import static lotto.util.Constants.ERROR_IS_UNDER_LOTTO_START_NUMBER_MSG;
import static lotto.util.Constants.ERROR_IS_VACANT_MSG;
import static lotto.util.Constants.LOTTO_END_NUMBER;
import static lotto.util.Constants.LOTTO_START_NUMBER;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator {
    private static final String ERROR_MSG_INFIX = "로또 번호";
    private static final String ERROR_IS_DUPLICATED_LOTTO_NUMBER_MSG = "로또 번호는 중복되지 않는 번호를 입력하셔야 합니다.";
    public static final String ERROR_NOT_CONTAIN_SAME_NUMBER_MSG = "는 중복되지 않아야 합니다.";
    public static final String ERROR_HAVE_COUNT_OF_LOTTO_NUMBER_MSG = "는 %d개여야 합니다."
            .formatted(COUNT_OF_LOTTO_NUMBER);

    public static void isValid(List<Integer> numbers) {
        haveCountOfLottoNumber(numbers);

        containSameNumber(numbers);
    }

    private static void haveCountOfLottoNumber(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != COUNT_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR_INIT + ERROR_MSG_INFIX + ERROR_HAVE_COUNT_OF_LOTTO_NUMBER_MSG);
        }
    }

    private static void containSameNumber(List<Integer> lottoNumbers) {
        Set<Integer> numbersSet = new HashSet<>(lottoNumbers);
        if (numbersSet.size() != COUNT_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR_INIT + ERROR_MSG_INFIX + ERROR_NOT_CONTAIN_SAME_NUMBER_MSG);
        }
    }

    public static void isValid(String numbers) {
        isVacant(numbers);

        isValidWinningLottoNumbers(numbers);
    }

    private static void isVacant(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException(ERROR_INIT + ERROR_MSG_INFIX + ERROR_IS_VACANT_MSG);
        }
    }

    private static void isValidWinningLottoNumbers(String numbers) {
        List<Integer> lottoNumbers = new ArrayList<>();

        for (String number : numbers.split(DELIMITER, -1)) {
            number = number.trim();

            try {
                int lottoNumber = Integer.parseInt(number);

                UnderLottoStartNumber(lottoNumber);

                ExceedLottoEndNumber(lottoNumber);

                isDuplicatedLottoNumber(lottoNumbers, lottoNumber);

                lottoNumbers.add(lottoNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_INIT + ERROR_MSG_INFIX + ERROR_CONTAIN_LETTER_MSG);
            }
        }

        haveCountOfLottoNumber(lottoNumbers);
    }

    private static void UnderLottoStartNumber(int lottoNumber) {
        if (lottoNumber < LOTTO_START_NUMBER) {
            throw new IllegalArgumentException(ERROR_INIT + ERROR_MSG_INFIX + ERROR_IS_UNDER_LOTTO_START_NUMBER_MSG);
        }
    }

    private static void ExceedLottoEndNumber(int lottoNumber) {
        if (lottoNumber > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(ERROR_INIT + ERROR_MSG_INFIX + ERROR_EXCEED_LOTTO_END_NUMBER_MSG);
        }
    }

    private static void isDuplicatedLottoNumber(List<Integer> lottoNumbers, int lottoNumber) {
        if (lottoNumbers.contains(lottoNumber)) {
            throw new IllegalArgumentException(ERROR_INIT + ERROR_IS_DUPLICATED_LOTTO_NUMBER_MSG);
        }
    }
}
