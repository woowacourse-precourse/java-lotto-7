package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinNumbersTest {

    @Test
    @DisplayName("정상적인 입력을 받았을 때 동작을 확인한다.")
    void winNumbersFrom() {
        //given
        String originWinNumbers = "1,2,3,4,5,6";
        WinNumbers expectWinNumbers = new WinNumbers(List.of(1, 2, 3, 4, 5, 6), null);

        //when
        WinNumbers winNumbers = WinNumbers.winNumbersFrom(originWinNumbers);

        //then
        assertThat(winNumbers).isEqualTo(expectWinNumbers);
    }

    @ParameterizedTest
    @DisplayName("당첨 번호의 예외를 확인한다.")
    @ValueSource(strings = {"1,j,3,4,5,6", "1,1,2,3,4,5", "1,2,3,4,5", "1,2,3,4,5,77"})
    void validateWinNumbersException(String winNumbers) {
        assertThatThrownBy(() -> WinNumbers.winNumbersFrom(winNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상적인 보너스 숫자 입력을 받았을 때 동작을 확인한다.")
    void bonusNumberFrom() {
        //given
        String bonusNumber = "7";
        WinNumbers winNumbers = new WinNumbers(List.of(1, 2, 3, 4, 5, 6), null);
        WinNumbers expectWinNumbers = new WinNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        //when
        WinNumbers winNumbersWithBonusNumber = winNumbers.bonusNumberFrom(bonusNumber);

        //then
        assertThat(winNumbersWithBonusNumber).isEqualTo(expectWinNumbers);
    }

    @ParameterizedTest
    @DisplayName("보너스 숫자의 예외를 확인한다.")
    @ValueSource(strings = {"6", "j", "99"})
    void validateBonusNumberException(String bonusNumber) {
        //given
        WinNumbers winNumbers = new WinNumbers(List.of(1, 2, 3, 4, 5, 6), null);

        //when-then
        assertThatThrownBy(() -> winNumbers.bonusNumberFrom(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}