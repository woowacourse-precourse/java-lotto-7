package lotto.model.draw;

import static lotto.constant.ErrorMessage.INVALID_DRAW_NUMBER_COUNT;
import static lotto.constant.ErrorMessage.INVALID_DRAW_NUMBER_FORMAT;
import static lotto.constant.ErrorMessage.INVALID_DUPLICATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DrawNumbersTest {
    @Test
    void 당첨번호_입력_테스트() {
        // given
        String drawNumberInput = "1,2,3,4,5,6";

        // when
        DrawNumbers drawNumbers = new DrawNumbers(drawNumberInput);
        List<Integer> lottoNumbers = drawNumbers.getDrawNumbers();

        // then
        assertThat(lottoNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 당첨번호_쉼표분할예외_예외테스트() {
        assertThatThrownBy(() -> new DrawNumbers("1,2,3,4,56"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_DRAW_NUMBER_COUNT.getFormatMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,-1", "1,2,3,4,5,abc"})
    void 당첨번호_양의정수입력_예외테스트(String drawNumberInput) {
        assertThatThrownBy(() -> new DrawNumbers(drawNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_DRAW_NUMBER_FORMAT.getFormatMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,0", "1,2,3,4,5,46"})
    void 당첨번호_범위_예외테스트(String drawNumberInput) {
        assertThatThrownBy(() -> new DrawNumbers(drawNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_DRAW_NUMBER_FORMAT.getFormatMessage());
    }

    @Test
    void 당첨번호_중복_예외테스트() {
        assertThatThrownBy(() -> new DrawNumbers("1,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_DUPLICATE.getFormatMessage());
    }
}
