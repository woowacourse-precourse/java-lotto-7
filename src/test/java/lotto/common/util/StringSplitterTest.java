package lotto.common.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringSplitterTest {

    @Test
    @DisplayName("문자열이 null인 경우 예외가 발생해야 한다.")
    void should_throwException_When_StringIsNull() {
        // when & then
        assertThatThrownBy(() -> StringSplitter.splitByComma(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 문자열인 경우 예외가 발생해야 한다.")
    void should_throwException_When_StringIsEmpty() {
        // when & then
        assertThatThrownBy(() -> StringSplitter.splitByComma(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1 , 2, 3", " 1 ,2, 3"})
    @DisplayName("쉼표로 문자를 구분할 수 있어야 한다.")
    void should_splitStringByComma(String value) {
        // when
        List<String> values = StringSplitter.splitByComma(value);

        // then
        assertThat(values).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {",1,2,3", "1,2,3,", ",1,2,3,"})
    @DisplayName("문자열의 앞이나 뒤에 쉼표가 있다면 예외가 발생해야 한다.")
    void should_throwException_When_ExistsInvalidComma(String value) {
        // when & then
        assertThatThrownBy(() -> StringSplitter.splitByComma(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
