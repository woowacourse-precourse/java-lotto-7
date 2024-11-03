package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultAnalysisServiceTest {

    private List<Integer> winningNumbers;
    private LottoResultAnalysisService resultAnalysisService;

    @BeforeEach
    public void setUp() {
        winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        resultAnalysisService = new LottoResultAnalysisService(winningNumbers);
    }

    @DisplayName("당첨 번호에 대한 결과를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideValidLottoNumbers")
    public void shouldReturnsWinningResult_givenWinningNumbers(List<Integer> lottoNumbers, int matchedCount) {
        //when
        Lotto lotto = new Lotto(lottoNumbers);
        List<Lotto> lottos = List.of(lotto);
        List<Rank> ranks = resultAnalysisService.generateWinningResults(lottos);
        Rank expected = Rank.findByMatchedCount(matchedCount);

        //then
        assertThat(ranks.getFirst()).isEqualTo(expected);
    }

    @DisplayName("지출액이 주어지면 수익률을 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000,5500","4000,1375", "13_000,423.1", "10_000,550", "300_000,18.3"})
    public void shouldCalculateProfitRate_givenPayment(int payment, String expected) {
        //given
        List<Rank> winningResults = List.of(Rank.FIFTH, Rank.FOURTH);

        //when
        String lottoProfitRate = resultAnalysisService.getLottoProfitRate(winningResults, payment);

        //then
        assertThat(lottoProfitRate).isEqualTo(expected);
    }

    private static Stream<Arguments> provideValidLottoNumbers() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
            Arguments.of(List.of(1, 2, 3, 4, 5, 45), 5),
            Arguments.of(List.of(4, 5, 45, 1, 2, 3), 5),
            Arguments.of(List.of(1, 2, 3, 4, 10, 20), 4),
            Arguments.of(List.of(1, 2, 3, 7, 10, 20), 3),
            Arguments.of(List.of(40, 41, 42, 43, 44, 45), 0)
        );
    }
}