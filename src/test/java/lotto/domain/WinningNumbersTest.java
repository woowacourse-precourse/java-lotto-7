package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumbersTest {

    @ParameterizedTest
    @MethodSource("provideWinningNumbers")
    void 당첨_번호_생성_테스트(List<Integer> winningNumber) {
        //when & then
        assertThrows(IllegalArgumentException.class,
            () -> new WinningNumbers(winningNumber));
    }

    static List<List<Integer>> provideWinningNumbers() {
        return List.of(
            List.of(1,2,3,4,5),
            List.of(1,2,3,4,5,5)
        );
    }

    @Test
    void 보너스_번호_당첨번호_중복_테스트() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 1;

        //then
        assertThrows(IllegalArgumentException.class,
            () -> winningNumbers.setBonusNumber(bonusNumber));
    }
}