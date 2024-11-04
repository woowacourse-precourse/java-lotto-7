package lotto.converter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringToIntConverterTest {

    private StringToIntConverter stringToIntConverter = new StringToIntConverter();

    @DisplayName("하나의 숫자에 대한 정상적인 변환 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1230", "23", "45", "5454"})
    void 정상_변환(String input) {
        // given
        int expect = Integer.parseInt(input);

        // when, then
        Assertions.assertThat(stringToIntConverter.convertStringNumberToInteger(input))
                .isEqualTo(expect);
    }

    @DisplayName("구분자에 의한 여러 숫자에 대한 정상 변환 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,0", "23,123", "45,69695,3123 , 432423, 4", "54,54"})
    void 정상_변환2(String input) {
        // given
        List<Integer> expects = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        // when, then
        Assertions.assertThat(stringToIntConverter.convertStringNumbersToIntegers(input))
                .isEqualTo(expects);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void null_또는_공백_변환_예외(String input) {
        assertThrows(RuntimeException.class, () -> stringToIntConverter.convertStringNumberToInteger(input));
    }

}