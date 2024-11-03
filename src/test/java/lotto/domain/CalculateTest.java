package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculateTest {
    private final static List<Integer> WINNING_LOTTO_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private final static List<Integer> THREE_MATCH_LOTTO_NUMBERS = List.of(1, 2, 3, 7, 8, 9);
    private final static List<Integer> FOUR_MATCH_LOTTO_NUMBERS = List.of(1, 2, 3, 4, 8, 9);
    private final static List<Integer> FIVE_MATCH_LOTTO_NUMBERS = List.of(1, 2, 3, 4, 5, 9);
    private final static int WINNING_BONUS_NUMBERS = 45;
    private final static int NOT_MATCH_BONUS_NUMBERS = 34;
    private final static int THREE_MATCH_PRIZE = 5000;
    private final static int FOUR_MATCH_PRIZE = 50000;
    private final static int FIVE_MATCH_PRIZE = 1500000;
    private final static int FIVE_WITH_BONUS_MATCH_PRIZE = 30000000;
    private final static int SIX_MATCH_PRIZE = 2000000000;

    @DisplayName("로또 당첨 케이스 별 로또 당첨금을 계산한다.")
    @ParameterizedTest
    @MethodSource("provideALLPrizeMoney")
    void calculatePrizeMoney(List<Integer> lottoNumbers, int bonusNumber, int prizeMoney) {
        //given
        DrawNumbers winningDrawNumbers = new DrawNumbers(WINNING_LOTTO_NUMBERS, WINNING_BONUS_NUMBERS);
        DrawNumbers randomDrawNumbers = new DrawNumbers(lottoNumbers, bonusNumber);
        //when
        Calculate calculate = new Calculate(winningDrawNumbers,randomDrawNumbers);
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