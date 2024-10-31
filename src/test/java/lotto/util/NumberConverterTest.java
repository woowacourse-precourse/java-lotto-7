package lotto.util;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberConverterTest {
    @DisplayName("문자열 리스트가 숫자 리스트로 변환된다.")
    @Test
    void convertToIntegerList() {
        // given
        List<String> strings = List.of("1","2","3","4","5","6");

        // when
        List<Integer> integers = NumberConverter.convertToIntegerList(strings);

        // then
        Assertions.assertThat(integers).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @DisplayName("문자열이 숫자로 변환된다.")
    @Test
    void convertToInteger() {
        // given
        String input = "1";

        // when
        Integer converted = NumberConverter.convertToInteger(input);
        // then
        Assertions.assertThat(converted).isEqualTo(1);
    }

}