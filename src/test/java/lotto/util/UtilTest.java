package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UtilTest {

    @DisplayName("금액을 포맷팅하여 천 단위로 구분된 문자열로 반환한다")
    @ParameterizedTest
    @CsvSource(delimiter = '|',value = {
            "1000 | 1,000",
            "1500000 | 1,500,000",
            "2000000000 | 2,000,000,000"
    })
    void cashFormat(int amount, String expected) {
        assertThat(Util.cashFormat(amount)).isEqualTo(expected);
    }

    @DisplayName("입력된 문자열을 지정된 구분자로 분리하여 리스트로 반환한다")
    @Test
    void seperateInput_ValidInput() {
        String input = "1, 2, 3, 4,5";
        List<String> expected = List.of("1", "2", "3", "4", "5");

        assertThat(Util.seperateInput(input)).isEqualTo(expected);
    }

    @DisplayName("문자열 리스트를 정수 리스트로 변환하고 숫자가 아닌 경우 예외를 발생시킨다")
    @Test
    void toNumbers_ValidAndInvalidInputs() {
        List<String> validInputs = List.of("1", "2", "3", "4", "5");
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5);

        assertThat(Util.toNumbers(validInputs)).isEqualTo(expectedNumbers);

        List<String> invalidInputs = List.of("1", "a", "3");
        assertThatThrownBy(() -> Util.toNumbers(invalidInputs))
                .isInstanceOf(IllegalArgumentException.class);
    }

}