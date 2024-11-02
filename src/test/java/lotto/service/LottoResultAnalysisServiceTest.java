package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultAnalysisServiceTest {

    @DisplayName("당첨 번호에 대한 결과를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideValidLottoNumbers")
    public void shouldReturnsWinningResult_givenWinningNumbers(List<Integer> lottoNumbers, int matchedCount) {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoResultAnalysisService resultAnalysisService
            = new LottoResultAnalysisService(winningNumbers);

        //when
        Lotto lotto = new Lotto(lottoNumbers);
        List<Lotto> lottos = List.of(lotto);
        List<Rank> ranks = resultAnalysisService.generateWinningResults(lottos);
        Rank expected = Rank.findByMatchedCount(matchedCount);

        //then
        assertThat(ranks.getFirst()).isEqualTo(expected);
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