package lotto.util.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

@DisplayName("[유닛 테스트] - 당첨 번호 변환")
class WinningNumberConverterTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "1,2,3,4,5,a", "1 2 3 4 5 6"})
    @DisplayName("당첨 번호 변환 - 당첨 번호 형식이 올바르지 않을 경우 에외 발생")
    void invalidWinningNumberFormat_throwException(String inputWinningNumber) {
        //given & when
        Throwable throwable = catchThrowable(() -> new WinningNumberConverter(inputWinningNumber));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage("[ERROR] 당첨 번호 형식이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("당첨 번호 변환 - 올바른 형식의 당첨 번호 변환 시도 시 당첨 번호 목록 반환")
    void properFormatWinningNumber_convert_returnWinningNumberList() {
        //given
        String inputWinningNumber = "1,2,3,4,5,6";

        //when
        WinningNumberConverter winningNumberConverter = new WinningNumberConverter(inputWinningNumber);
        List<Integer> winningNumber = winningNumberConverter.convert();

        //then
        assertThat(winningNumber).hasSize(6);
    }
}