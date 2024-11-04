package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;

class NumberValidateTest {

    @Test
    @DisplayName("기호 문자가 입력된 경우")
    void 기호_문자가_입력된_경우() {
        //given
        String value = ";.";
        String expected = "[ERROR] 숫자만 입력해주세요.";

        //when
        NumberFormatException e = assertThrows(NumberFormatException.class,
                () -> NumberValidate.isNumeric(value));

        //then
        assertThat(e.getMessage()).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력값이 null이거나 공백을 포함한 경우")
    void 입력값이_null_또는_공백인_경우() {
        //given
        String value = " ";
        String expected = "[ERROR] 입력값이 null이거나 공백을 포함하고 있습니다.";

        //when
        NullPointerException e = assertThrows(NullPointerException.class,
                () -> NumberValidate.isEmpty(value));

        //then
        assertThat(e.getMessage()).isEqualTo(expected);
    }

    @Test
    @DisplayName("1,000원 이하 금액을 입력한 경우")
    void 천원_이하_금액_입력_경우() {
        //given
        String value = "500";
        String expected = "[ERROR] 최소금액은 1,000원 입니다.";

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> NumberValidate.isOverThousand(value));

        //then
        assertThat(e.getMessage()).isEqualTo(expected);
    }

    @Test
    @DisplayName("1,000으로 나누어떨어지지 않는 금액 입력한 경우")
    void 천원으로_나누어떨어지지_않는_금액_입력_경우() {
        //given
        String value = "1500";
        String expected = "[ERROR] 1,000으로 나누어 떨어지는 숫자를 입력해주세요.";

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> NumberValidate.isDivisibleByThousand(value));

        //then
        assertThat(e.getMessage()).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 번호의 크기가 6이 아닌 경우")
    void 로또_번호_크기가_6이_아닌_경우() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        String expected = "[ERROR] 로또 번호는 6개여야 합니다.";

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> NumberValidate.isSizeSix(numbers));

        //then
        assertThat(e.getMessage()).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 번호가 범위를 벗어나는 경우")
    void 로또_번호_범위를_벗어난_경우() {
        //given
        String value = "50";
        String expected = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> NumberValidate.isOutOfRange(value));

        //then
        assertThat(e.getMessage()).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 번호가 중복 된 경우")
    void 로또_번호가_중복_된_경우() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 4, 5);
        String expected = "[ERROR] 중복된 번호는 입력이 불가합니다.";

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> NumberValidate.isduplicated(numbers));

        //then
        assertThat(e.getMessage()).isEqualTo(expected);
    }
}
