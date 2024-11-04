package lotto.basic.checker;

import lotto.checker.domain.BonusNumber;
import lotto.checker.domain.WinningNumbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BonusNumberTest {


    @Test
    void 입력_테스트() {
        // given
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        String correctInput = "12";
        Integer expectedValues = 12;

        // when
        BonusNumber bonusNumber = new BonusNumber(correctInput, winningNumbers);

        // then
        assertThat(bonusNumber.value())
                .isEqualTo(expectedValues);
    }

    @Test
    void 공백_입력_테스트() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        String errorInput = "";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BonusNumber(errorInput, winningNumbers));
    }

    @Test
    void 음수_입력_테스트() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        String errorInput = "-1";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BonusNumber(errorInput, winningNumbers));
    }

    @Test
    void 문자_입력_테스트() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        String errorInput = "일";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BonusNumber(errorInput, winningNumbers));
    }

    @Test
    void 중복_입력_테스트() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        String errorInput = "1";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BonusNumber(errorInput, winningNumbers));
    }

}
