package lotto;

import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

//@Disabled
class ParserTest {
    @Test
    void 금액_파싱_테스트() {
        String dummyInput = "1000";

        int amount = Parser.parseAmount(dummyInput);
        assertThat(amount).isEqualTo(1000);
    }

    @Test
    void 숫자_파싱_테스트() {
        String dummyInput = "1,2,3,4,5,6";

        ArrayList<Integer> numbers = Parser.parseUserPickNumbers(dummyInput);
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 숫자_정렬_테스트() {
        String dummyInput = "6,5,4,3,2,1";

        ArrayList<Integer> numbers = Parser.parseUserPickNumbers(dummyInput);
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 보너스_파싱_테스트() {
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
        String dummyInput = "7";

        assertThat(Parser.parseUserPickBonus(dummyInput, numbers)).isEqualTo(7);
    }
}