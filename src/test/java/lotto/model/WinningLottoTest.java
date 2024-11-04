package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {
    @Test
    @DisplayName("WinningLotto 객체 생성 성공")
    void testWinningLottoCreationWithValidNumbers() {
        // given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        // then
        assertEquals(winningNumbers, winningLotto.getWinningNums().getNumbers());
        assertEquals(bonusNumber, winningLotto.getBonusNum());
    }

    @ParameterizedTest
    @MethodSource("invalidWinningNumberCountData")
    @DisplayName("당첨 번호가 6개가 아니면 예외 발생")
    void testWinningLottoCreationWithInvalidWinningNumbers(List<Integer> numbers, int bonusNum) {
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(numbers, bonusNum),
                "로또 번호는 6개여야 합니다.");
    }

    @ParameterizedTest
    @MethodSource("invalidBonusNumberData")
    @DisplayName("보너스 번호가 범위를 벗어나거나 당첨 번호와 중복될 경우 예외 발생")
    void testWinningLottoCreationWithInvalidBonusNumber(List<Integer> winningNumbers, int bonusNum) {
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(winningNumbers, bonusNum),
                "보너스 번호는 1~45 사이 숫자여야합니다.");
    }

    static Stream<Arguments> invalidWinningNumberCountData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5), 6),
                Arguments.of(Arrays.asList(1, 2, 3), 4),
                Arguments.of(Arrays.asList(1, 2), 3),
                Arguments.of(Arrays.asList(1), 2),
                Arguments.of(Arrays.asList(), 1)
        );
    }

    static Stream<Arguments> invalidBonusNumberData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 0),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 46),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 5)
        );
    }
}