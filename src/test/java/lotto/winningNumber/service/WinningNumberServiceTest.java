package lotto.winningNumber.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import lotto.lottery.domain.Lotto;
import lotto.winningNumber.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumberServiceTest {
    private final WinningNumberService winningNumberService = new WinningNumberService();

    @Test
    @DisplayName("[,]로 구분하는 문자열과 보너스번호를 받아 당첨번호를 생성한다")
    void createWinningNumber() throws Exception {
        // given
        String numbers = "1,2,3,4,5,6";
        String bonus = "7";

        // when
        WinningNumber winningNumber = winningNumberService.create(numbers, bonus);

        // then
        assertThat(winningNumber).isNotNull()
                .extracting("numbers", "bonus")
                .containsExactlyInAnyOrder(List.of(1, 2, 3, 4, 5, 6), 7);
    }

    @ParameterizedTest
    @DisplayName("로또와 당첨번호를 받아 로또의 당첨개수를 센다")
    @MethodSource("providedMatchCount")
    void calculateMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers,
                             int bonus, int count) throws Exception {
        // given
        Lotto lotto = new Lotto(lottoNumbers);
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonus);

        // when
        int result = winningNumberService.calculateMatchCount(lotto, winningNumber);

        // then
        assertThat(result).isEqualTo(count);
    }

    private static Stream<Arguments> providedMatchCount() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 7, 6),
                Arguments.arguments(List.of(42, 32, 12, 22, 45, 2), List.of(13, 24, 24, 22, 32, 1), 2, 2)
        );
    }

    @ParameterizedTest
    @DisplayName("로또와 당첨번호를 받아 보너스가 맞았는지 확인한다")
    @MethodSource("providedMatchedBonus")
    void isBonusMatched(List<Integer> lottoNumbers, List<Integer> winningNumbers,
                             int bonus, boolean matchedBonus) throws Exception {
        // given
        Lotto lotto = new Lotto(lottoNumbers);
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonus);

        // when
        boolean result = winningNumberService.isBonusMatched(lotto, winningNumber);

        // then
        assertThat(result).isEqualTo(matchedBonus);
    }

    private static Stream<Arguments> providedMatchedBonus() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 7, false),
                Arguments.arguments(List.of(42, 32, 12, 22, 45, 2), List.of(13, 24, 24, 22, 32, 1), 2, true)
        );
    }

}