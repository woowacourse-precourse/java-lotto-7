package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.exception.IllegalDuplicateException;
import lotto.exception.IllegalLottoNumberException;
import lotto.exception.IllegalNumberCountException;
import lotto.exception.IllegalRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("당첨 번호에 관한 기능을 확인한다.")
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
    @MethodSource("provideWinNumbers")
    void validateWinNumbersException(String winNumbers, IllegalArgumentException exception) {
        assertThatThrownBy(() -> WinNumbers.winNumbersFrom(winNumbers)).isInstanceOf(exception.getClass());
    }

    private static Stream<Arguments> provideWinNumbers() {
        return Stream.of(
                Arguments.of("1,j,3,4,5,6", new IllegalLottoNumberException()),
                Arguments.of("1,1,2,3,4,5", new IllegalDuplicateException()),
                Arguments.of("1,2,3,4,5", new IllegalNumberCountException()),
                Arguments.of("1,2,3,4,5,77", new IllegalRangeException())
        );
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
    @MethodSource("provideBonusNumber")
    void validateBonusNumberException(String bonusNumber, IllegalArgumentException exception) {
        //given
        WinNumbers winNumbers = new WinNumbers(List.of(1, 2, 3, 4, 5, 6), null);

        //when-then
        assertThatThrownBy(() -> winNumbers.bonusNumberFrom(bonusNumber)).isInstanceOf(exception.getClass());
    }


    private static Stream<Arguments> provideBonusNumber() {
        return Stream.of(
                Arguments.of("6", new IllegalDuplicateException()),
                Arguments.of("j", new IllegalLottoNumberException()),
                Arguments.of("99", new IllegalRangeException())
        );
    }
}