package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ConverterTest {

    @Test
    void 숫자로_구성된_문자열을_숫자로_변환한다() {
        String number = "1000";

        int actual = Converter.parseInt(number);

        assertThat(actual).isEqualTo(1000);
    }

    @Test
    void 컴마로_구분된_숫자_문자열을_숫자_리스트로_변환한다() {
        String number = "1,2,3,4,5,6";

        List<Integer> actual = Converter.splitComma(number);

        assertThat(actual).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

}
