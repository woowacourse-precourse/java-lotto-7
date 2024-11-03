package lotto.model.winlotto;

import lotto.utils.Constants;
import lotto.utils.ExceptionMessage;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static lotto.utils.StringValidator.containsBlank;
import static lotto.utils.StringValidator.isEmpty;
import static lotto.utils.StringValidator.isOutOfRangeLottoNumber;

/**
 * 기본 우승 로또 번호를 저장하는 클래스
 * 생성자 매개변수를 검증한 후 맞지 않으면 예외 호출
 */
public class BasicWinLottoNumbers {

    private static final String EXCEPTION_MESSAGE_WRONG_LOTTO_NUMBER_COUNT =
                    Constants.EXCEPTION_MESSAGE_PREFIX +
                    " 로또 숫자는 " + Constants.COUNT_LOTTO_NUMBERS +
                    "개로 이루어져야 합니다.";

    private static final String EXCEPTION_MESSAGE_WRONG_FORMAT =
                    Constants.EXCEPTION_MESSAGE_PREFIX +
                    " 올바른 기본 당첨 숫자 형식이 아닙니다.";

    private static final String NUMBER_IN_RANGE = "([1-9]|[1-3][0-9]|4[0-5])";
    
    private static final String REGEX_FORMAT =
            "^(" + NUMBER_IN_RANGE + ",){5}" + NUMBER_IN_RANGE + "$";
    
    private static final Pattern PATTERN = Pattern.compile(REGEX_FORMAT);
    
    private final Set<Integer> numbers;

    /**
     * @param 문자열
     * @throws 문자열이 형식에 맞지 않으면 IllegalArgumentException 호출
     */
    public BasicWinLottoNumbers(String numbersToValidate) {
        validateInput(numbersToValidate);

        String[] numbers = numbersToValidate.split(",");
        this.numbers = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableSet());
    }

    private void validateInput(String numbersToValidate) {
        if (isEmpty(numbersToValidate)) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_INPUT.toString());
        }
        if (containsBlank(numbersToValidate)) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK_INPUT.toString());
        }
        if (isIncorrectNumberCount(numbersToValidate)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_WRONG_LOTTO_NUMBER_COUNT);
        }
        if (isOutOfRangeNumbers(numbersToValidate)) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_LOTTO_NUMBER_RANGE.toString());
        }
        if (isIncorrectFormat(numbersToValidate)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_WRONG_FORMAT);
        }
    }

    private boolean isIncorrectNumberCount(String numbersToValidate) {
        int count = (int) numbersToValidate.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> (c == ','))
                .count();
        return count != Constants.COUNT_LOTTO_NUMBERS - 1;
    }

    private boolean isOutOfRangeNumbers(String numbersToValidate) {
        String[] numbers = numbersToValidate.split(",");
        for (String number : numbers) {
            if (isOutOfRangeLottoNumber(number)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isIncorrectFormat(String numbersToValidate) {
        Matcher matcher = PATTERN.matcher(numbersToValidate);
        return !matcher.matches();
    }
    
    public boolean contains(int number) {
        return numbers.contains(number);
    }
    
    public Set<Integer> get() {
        return numbers;
    }
    
}
