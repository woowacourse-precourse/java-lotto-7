package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("정수가 아닌 입력이 포함되어있을 때 예외를 확인한다.")
    void winNumbersIntegerException() {
        //given
        String originWinNumbers = "1,j,3,4,5,6";

        //then
        assertThatThrownBy(() -> WinNumbers.winNumbersFrom(originWinNumbers)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 숫자가 입력됐을 때 예외를 확인한다.")
    void winNumbersDuplicateException() {
        //given
        String originWinNumbers = "1,1,2,3,4,5";

        //then
        assertThatThrownBy(() -> WinNumbers.winNumbersFrom(originWinNumbers)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 6개가 아닐 경우 예외가 발생한다.")
    void winNumbersCountException() {
        //given
        String originWinNumbers = "1,2,3,4,5";

        //then
        assertThatThrownBy(() -> WinNumbers.winNumbersFrom(originWinNumbers)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 범위를 벗어났을 경우 예외가 발생한다.")
    void winNumbersRangeException() {
        //given
        String originWinNumbers = "1,2,3,4,5,77";

        //then
        assertThatThrownBy(() -> WinNumbers.winNumbersFrom(originWinNumbers)).isInstanceOf(
                IllegalArgumentException.class);
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

    @Test
    @DisplayName("보너스 숫자가 본래 당첨번호와 중복되는 숫자일 경우 예외를 확인한다.")
    void bonusNumberDuplicateException() {
        //given
        String bonusNumber = "6";
        WinNumbers winNumbers = new WinNumbers(List.of(1, 2, 3, 4, 5, 6), null);

        //then
        assertThatThrownBy(() -> winNumbers.bonusNumberFrom(bonusNumber)).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("숫자가 아닌 보너스 숫자가 입력되었을 경우 예외를 확인한다.")
    void bonusNumberIntegerException() {
        //given
        String bonusNumber = "j";
        WinNumbers winNumbers = new WinNumbers(List.of(1, 2, 3, 4, 5, 6), null);

        //then
        assertThatThrownBy(() -> winNumbers.bonusNumberFrom(bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("범위를 벗어나는 보너스 숫자의 예외를 확인한다.")
    void bonusNumberRangeException() {
        //given
        String bonusNumber = "99";
        WinNumbers winNumbers = new WinNumbers(List.of(1, 2, 3, 4, 5, 6), null);

        //then
        assertThatThrownBy(() -> winNumbers.bonusNumberFrom(bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }
}