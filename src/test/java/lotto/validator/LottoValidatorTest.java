package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoValidatorTest {

    @DisplayName("로또 번호가 유효한 경우 예외가 발생하지 않음")
    @Test
    void validate_WhenLottoNumbersAreValid_ShouldNotThrowException() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatNoException().isThrownBy(() -> LottoValidator.validate(validNumbers));
    }

    @DisplayName("로또 번호 유효성 검사 실패 시 올바른 예외 메시지 발생")
    @ParameterizedTest(name = "[{index}] {1}")
    @CsvSource({
            "'1, 2, 3, 4, 5', '[ERROR] 로또 번호는 6개의 숫자여야 합니다.'",  // 숫자 개수 부족
            "'1, 2, 3, 4, 5, 46', '[ERROR] 로또 번호는 1부터 45 사이여야 합니다.'", // 범위를 벗어남
            "'1, 2, 3, 4, 5, 5', '[ERROR] 로또 번호에는 중복된 숫자가 없어야 합니다.'" // 중복 숫자 존재
    })
    void validate_WhenInvalidLottoNumbers_ShouldThrowException(String numbers, String expectedMessage) {
        List<Integer> lottoNumbers = Arrays.asList(
                Arrays.stream(numbers.split(", "))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new)
        );

        assertThatThrownBy(() -> LottoValidator.validate(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }
    
}
