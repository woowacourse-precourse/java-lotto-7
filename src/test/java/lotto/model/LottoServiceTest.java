package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoServiceImpl();
    }

    @DisplayName("로또 구매 금액 오류")
    @Test
    void buyLottoTest_Failure() {
        //given
        int amount = 5100;
        //when & then
        assertThatThrownBy(() -> lottoService.buyLotto(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 로또 구매 테스트")
    @Test
    void buyLottoTest_Success() {
        //given
        int amount = 5000;
        //when
        lottoService.buyLotto(amount);

        //then
        List<Lotto> lottoList = lottoService.getLottoList();
        assertThat(lottoList).hasSize(5);
    }

    @DisplayName("로또 번호와 보너스 번호에 따라 올바른 Rank를 반환한다.")
    @ParameterizedTest(name = "{index}: lottoNumbers={0}, rank={1}")
    @CsvSource({
            "'1, 2, 3, 4, 5, 6', FIRST",
            "'1, 2, 3, 4, 5, 7', SECOND",
            "'1, 2, 3, 4, 8, 9', FOURTH",
            "'1, 2, 3, 8, 9, 10', FIFTH",
            "'8, 21, 23, 41, 42, 43', NONE"
    })
    void checkWinningTest(String lottoNumbers, Rank rank) {
        // given
        List<Integer> numbers = Arrays.stream(lottoNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Lotto testLotto = new Lotto(numbers);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        Rank testRank = lottoService.checkWinning(testLotto, winningNumbers, bonusNumber);

        // then
        assertThat(testRank).isEqualTo(rank);
    }

    @DisplayName("구매한 로또와 당첨 번호, 보너스 번호를 통해 올바른 당첨 결과를 계산한다.")
    @Test
    void calculateResultsTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lottoService.buyLotto(8000); // 로또 8장 구매
                },
                List.of(1, 2, 3, 4, 5, 6), // 1등
                List.of(7, 8, 9, 10, 11, 12), // NONE
                List.of(1, 2, 3, 4, 5, 7), // 2등
                List.of(1, 2, 3, 4, 5, 8), // 3등
                List.of(1, 2, 3, 4, 7, 8), // 4등
                List.of(1, 2, 3, 7, 8, 9), // 5등
                List.of(8, 9, 10, 11, 12, 13), // NONE
                List.of(14, 15, 16, 17, 18, 19) // NONE
        );

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Map<Rank, Integer> results = lottoService.calculateResults(winningNumbers, bonusNumber);

        assertThat(results.get(Rank.FIRST)).isEqualTo(1);
        assertThat(results.get(Rank.SECOND)).isEqualTo(1);
        assertThat(results.get(Rank.THIRD)).isEqualTo(1);
        assertThat(results.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(results.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(results.get(Rank.NONE)).isEqualTo(3);
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void calculateProfitTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lottoService.buyLotto(5000); // 로또 5장 구매
                },
                List.of(1, 2, 3, 4, 5, 6), // 1등
                List.of(8, 9, 10, 11, 12, 13), // NONE
                List.of(1, 2, 3, 4, 5, 7), // 2등
                List.of(1, 2, 3, 4, 8, 9), // 4등
                List.of(2, 3, 4, 5, 6, 8)  // 3등
        );

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Map<Rank, Integer> results = lottoService.calculateResults(winningNumbers, bonusNumber);
        double profit = lottoService.calculateProfit(results);

        // 예상 수익률: (2,000,000,000 + 30,000,000 + 1,500,000 + 50,000) / (5 * 1000) * 100
        double expectedProfit = ((2_000_000_000 + 30_000_000 + 1_500_000 + 50_000) / (5 * 1000.0)) * 100;
        assertThat(profit).isEqualTo(expectedProfit);
    }
}
