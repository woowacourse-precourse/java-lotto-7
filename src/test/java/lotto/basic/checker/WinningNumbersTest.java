package lotto.basic.checker;

import lotto.checker.domain.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WinningNumbersTest {

    @Test
    void 입력_테스트() {
        // given
        List<Integer> expectedValues = List.of(1, 2, 3, 4, 5, 6); // 정수형으로 변경

        // when
        WinningNumbers actualInput = new WinningNumbers("1,2,3,4,5,6");

        // then
        assertThat(actualInput.stream().toList())
                .isEqualTo(expectedValues); // getNumbers() 메서드 사용
    }


    @Test
    void 공백_입력_테스트() {
        // given
        String errorInput = "1,2,3,4, ,6";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningNumbers(errorInput));
    }

    @Test
    void 음수_입력_테스트() {
        // given
        String errorInput = "1,2,3,4,-1,6";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningNumbers(errorInput));
    }

    @Test
    void 문자_입력_테스트() {
        // given
        String errorInput = "1,2,3,4,일,6";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningNumbers(errorInput));
    }

    @Test
    void 짧은_길이_입력_테스트() {
        // given
        String errorInput = "1,2,3,4,5";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningNumbers(errorInput));
    }

    @Test
    void 긴_길이_입력_테스트() {
        // given
        String errorInput = "1,2,3,4,5,6,7";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningNumbers(errorInput));
    }

    @Test
    void 중복_입력_테스트() {
        // given
        String errorInput = "1,2,3,4,5,1";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningNumbers(errorInput));

    }

    @Test
    void 범위_입력_테스트() {
        // given
        String errorInput = "1,2,3,4,5,46";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningNumbers(errorInput));
    }

}
