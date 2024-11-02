package lotto.util;

import lotto.constants.LottoConstants;

import java.util.HashSet;
import java.util.List;

public class Validator {

    public static final String DEFAULT_INPUT_ERROR = "[ERROR] 입력이 비어 있습니다. 값을 입력해주세요.";
    public static final String NOT_NUMBER_ERROR = "[ERROR] 올바른 숫자를 입력해주세요.";

    public static final String UNDER_PRICE_ERROR = "[ERROR] 최소 구입 금액은 " + LottoConstants.BASE_PRICE + "원 이상이어야 합니다.";
    public static final String UNIT_ERROR = "[ERROR] 금액은 " + LottoConstants.BASE_PRICE + "원 단위여야 합니다.";

    public static final String DUPLICATE_NUMBER_ERROR = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    public static final String NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 " + LottoConstants.RANDOM_LOWER_BOUND + "부터 " + LottoConstants.RANDOM_UPPER_BOUND + " 사이의 숫자여야 합니다.";
    public static final String LOTTO_NUMBER_COUNT_ERROR = "[ERROR] 로또 번호는 " + LottoConstants.NUMBER_OF_LOTTO + "개여야 합니다.";

    public static void validateNumber(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(DEFAULT_INPUT_ERROR);
        }
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }

    public static void validateCommaSeparatedNumbers(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(DEFAULT_INPUT_ERROR);
        }
        if (!input.matches("[0-9, ]+")) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }

    public static void validatePrice(int price) {
        if (price < LottoConstants.BASE_PRICE) {
            throw new IllegalArgumentException(UNDER_PRICE_ERROR);
        }
        if (price % LottoConstants.BASE_PRICE != 0) {
            throw new IllegalArgumentException(UNIT_ERROR);
        }
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.NUMBER_OF_LOTTO) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR);
        }
        for (Integer number : numbers) {
            if (number < LottoConstants.RANDOM_LOWER_BOUND || number > LottoConstants.RANDOM_UPPER_BOUND) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR);
            }
        }
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR);
        }
    }

}
