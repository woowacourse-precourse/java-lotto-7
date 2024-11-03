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

    @Test
    @DisplayName("당첨 번호 변환 - 올바른 형식의 당첨 번호 변환 시도 시 당첨 번호 목록 반환")
    void properFormatWinningNumber_convert_returnWinningNumberList() {
        //given
        String inputWinningNumber = "1,2,3,4,5,6";

        //when
        List<Integer> winningNumber = WinningNumberConverter.convertWinningNumber(inputWinningNumber);

        //then
        assertThat(winningNumber).hasSize(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "2", "5"})
    @DisplayName("보너스 번호 변환 - 보너스 번호가 당첨 번호에 존재할 경우 예외 발생")
    void duplicateNumber_convert_throwException(String inputBonusNumber) {
        //given
        String inputWinningNumber = "1,2,3,4,5,6";

        //when
        Throwable throwable = catchThrowable(
                () -> WinningNumberConverter.convertBonusNumber(inputWinningNumber, inputBonusNumber)
        );

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage("[ERROR] 이미 존재하는 당첨 번호입니다.");
    }

    @Test
    @DisplayName("보너스 번호 변환 - 올바른 형식의 보너스 번호 입력시 정수형 번호 반환")
    void properFormatBonusNumber_convert_returnIntegerNumber() {
        //given
        String inputWinningNumber = "1,2,3,4,5,6";

        //when
        int bonusNumber = WinningNumberConverter.convertBonusNumber(inputWinningNumber, "7");

        //then
        assertThat(bonusNumber).isEqualTo(7);
    }
}