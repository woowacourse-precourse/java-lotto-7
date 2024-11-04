package lotto.domain;

import static lotto.enums.IntEnum.*;
import static lotto.enums.ListEnum.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculateTest {

    @DisplayName("로또 당첨 케이스 별 로또 당첨금을 계산한다.")
    @ParameterizedTest
    @MethodSource("provideAllPrizeMoney")
    void calculatePrizeMoney(List<Integer> lottoNumbers, int bonusNumber, int prizeMoney) {
        //given
        DrawNumbers winningDrawNumbers = new DrawNumbers(WINNING_LOTTO_NUMBERS.getList()
                , WINNING_BONUS_NUMBERS.getNumber());
        DrawNumbers randomDrawNumbers = new DrawNumbers(lottoNumbers, bonusNumber);
        //when
        Calculate calculate = new Calculate(winningDrawNumbers, randomDrawNumbers);
        int result = calculate.calculatePrizeMoney();
        //then
        assertThat(result).isEqualTo(prizeMoney);
    }

    private static Stream<Arguments> provideAllPrizeMoney() {
        return Stream.of(
                Arguments.of(THREE_MATCH_LOTTO_NUMBERS.getList(), NOT_MATCH_BONUS_NUMBERS.getNumber(), THREE_MATCH_PRIZE.getNumber()),
                Arguments.of(FOUR_MATCH_LOTTO_NUMBERS.getList(), NOT_MATCH_BONUS_NUMBERS.getNumber(), FOUR_MATCH_PRIZE.getNumber()),
                Arguments.of(FIVE_MATCH_LOTTO_NUMBERS.getList(), NOT_MATCH_BONUS_NUMBERS.getNumber(), FIVE_MATCH_PRIZE.getNumber()),
                Arguments.of(FIVE_MATCH_LOTTO_NUMBERS.getList(), WINNING_BONUS_NUMBERS.getNumber(), FIVE_WITH_BONUS_MATCH_PRIZE.getNumber()),
                Arguments.of(WINNING_LOTTO_NUMBERS.getList(), NOT_MATCH_BONUS_NUMBERS.getNumber(), SIX_MATCH_PRIZE.getNumber()));
    }
}