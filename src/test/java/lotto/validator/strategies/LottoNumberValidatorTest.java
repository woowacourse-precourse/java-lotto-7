package lotto.validator.strategies;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.view.ErrorMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoNumberValidatorTest {

    private final LottoNumberValidator validator = new LottoNumberValidator();

    @ParameterizedTest
    @CsvSource({
            "'1,2,3,4,5', LOTTO_NUMBER_COUNT_INVALID",      // 숫자 개수가 부족할 때
            "'1,2,3,4,5,6,7', LOTTO_NUMBER_COUNT_INVALID"   // 숫자 개수가 초과될 때
    })
    void validate_WhenNumberCountInvalid_ShouldThrowException(String input, String errorMessage) {
        List<Integer> numbers = parseToIntegerList(input);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(numbers))
                .withMessage(ErrorMessage.valueOf(errorMessage).getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "'0,2,3,4,5,6', LOTTO_NUMBER_RANGE_INVALID",    // 최소 범위 미달
            "'1,2,3,4,5,46', LOTTO_NUMBER_RANGE_INVALID"    // 최대 범위 초과
    })
    void validate_WhenNumberRangeInvalid_ShouldThrowException(String input, String errorMessage) {
        List<Integer> numbers = parseToIntegerList(input);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(numbers))
                .withMessage(ErrorMessage.valueOf(errorMessage).getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "'1,2,3,4,5,6'",         // 정상 입력
            "'10,15,20,25,30,35'"    // 정상 입력
    })
    void validate_WhenNumberListValid_ShouldNotThrowException(String input) {
        List<Integer> numbers = parseToIntegerList(input);
        assertThatNoException().isThrownBy(() -> validator.validate(numbers));
    }

    // 문자열을 정수 리스트로 변환하는 헬퍼 메소드
    private List<Integer> parseToIntegerList(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
