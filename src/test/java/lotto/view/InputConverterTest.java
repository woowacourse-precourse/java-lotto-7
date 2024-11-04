package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputConverterTest {

    @DisplayName("문자열을 정수형 리스트로 변환할 수 있다.")
    @Test
    void convertToNumbers() {
        //given
        String input = "1,2,3,4,5,6";

        //when
        List<Integer> numbers = InputConverter.convertToNumbers(input);

        //then
        assertThat(numbers).isInstanceOf(List.class).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("문자열을 정수형으로 변환할 수 있다.")
    @Test
    void parseToNumber() {
        //given
        String input = "1000";

        //when
        int number = InputConverter.parseToNumber(input);

        //then
        assertThat(number).isInstanceOf(Integer.class).isEqualTo(1000);
    }
}
