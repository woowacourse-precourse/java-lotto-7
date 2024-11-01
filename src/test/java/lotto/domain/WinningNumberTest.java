package lotto.domain;

import static lotto.Lotto.LOTTO_NUMBER_DUPLICATE_ERROR_MSG;
import static lotto.Lotto.LOTTO_NUMBER_SIZE_ERROR_MSG;
import static lotto.LottoMachine.LOTTO_NUMBER_RANGE_ERROR_MSG;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberTest {

    @Test
    public void 당첨번호파싱_정상테스트() throws Exception {
        //Given
        String input = "1,10,20,30,40,45";
        String expected = "[1, 10, 20, 30, 40, 45]";

        //When
        String actual = WinningNumber.parseWinningNumber(input).retrieveLottoNumber();

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1,,3,4,5,6", "1,2,3,4,5,46", "1,2,3,4,5, 6"})
    public void 당첨번호파싱_로또숫자_예외테스트(String input) throws Exception {
        //Given

        //When, Then
        Assertions.assertThatThrownBy(() -> WinningNumber.parseWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_RANGE_ERROR_MSG);
    }

    @Test
    public void 당첨번호파싱_중복_예외테스트() throws Exception {
        //Given
        String input = "1,2,3,4,6,6";

        //When, Then
        Assertions.assertThatThrownBy(() -> WinningNumber.parseWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_DUPLICATE_ERROR_MSG);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    public void 당첨번호파싱_개수_예외테스트(String input) throws Exception {
        //Given

        //When, Then
        Assertions.assertThatThrownBy(() -> WinningNumber.parseWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_SIZE_ERROR_MSG);
    }
}