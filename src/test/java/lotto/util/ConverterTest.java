package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConverterTest {

    @DisplayName("쉼표로 구분된 입력문을 숫자 리스트로 변환")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,34,5,6", "1,2,3"})
    void Converter(String input) {
        assertThat(Converter.toNumberList(input))
                .isInstanceOf(List.class)
                .hasOnlyElementsOfType(Integer.class);
    }
}