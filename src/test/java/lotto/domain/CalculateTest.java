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
    @MethodSource("provideALLPrizeMoney")
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

    private static Stream<Arguments> provideALLPrizeMoney() {
        return Stream.of(
                Arguments.of(THREE_MATCH_LOTTO_NUMBERS, NOT_MATCH_BONUS_NUMBERS, THREE_MATCH_PRIZE),
                Arguments.of(FOUR_MATCH_LOTTO_NUMBERS, NOT_MATCH_BONUS_NUMBERS, FOUR_MATCH_PRIZE),
                Arguments.of(FIVE_MATCH_LOTTO_NUMBERS, NOT_MATCH_BONUS_NUMBERS, FIVE_MATCH_PRIZE),
                Arguments.of(FIVE_MATCH_LOTTO_NUMBERS, WINNING_BONUS_NUMBERS, FIVE_WITH_BONUS_MATCH_PRIZE),
                Arguments.of(WINNING_LOTTO_NUMBERS, NOT_MATCH_BONUS_NUMBERS, SIX_MATCH_PRIZE));
    }
}