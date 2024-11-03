package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultAnalysisServiceTest {

    private List<Integer> winningNumbers;
    private LottoResultAnalysisService resultAnalysisService;

    @BeforeEach
    public void setUp() {
        int bonusNumber = 45;
        winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        resultAnalysisService = new LottoResultAnalysisService(winningNumbers, bonusNumber);
    }

    @DisplayName("당첨 번호에 대한 결과를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideValidLottoNumbers")
    public void shouldReturnsWinningResult_givenWinningNumbers(List<Integer> lottoNumbers, Rank expected) {

        //when
        Lotto lotto = new Lotto(lottoNumbers);
        List<Lotto> lottos = List.of(lotto);
        List<Rank> ranks = resultAnalysisService.generateWinningResults(lottos);

        //then
        assertThat(ranks.getFirst()).isEqualTo(expected);
    }

    @DisplayName("지출액이 주어지면 수익률을 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000,5500", "4000,1375", "13_000,423.1", "10_000,550", "300_000,18.3"})
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
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), Rank.FIRST),
            Arguments.of(List.of(1, 2, 3, 4, 5, 45), Rank.SECOND),
            Arguments.of(List.of(4, 5, 44, 1, 2, 3), Rank.THIRD),
            Arguments.of(List.of(1, 2, 3, 4, 10, 20), Rank.FOURTH),
            Arguments.of(List.of(1, 2, 3, 7, 10, 20), Rank.FIFTH),
            Arguments.of(List.of(40, 41, 42, 43, 44, 45), Rank.MISS)
        );
    }
}