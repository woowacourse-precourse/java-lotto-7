package lotto.model.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.dto.LottoResultDto;
import lotto.dto.WinningLottoDto;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultServiceTest {

    private final LottoResultService lottoResultService = new LottoResultService();

    @DisplayName("사용자의 당첨 내역 산출을 테스트 합니다.")
    @ParameterizedTest
    @MethodSource("generateTestCase")
    void resultFromTest(WinningLottoDto winningLottoDto, List<Lotto> lottos, Map<LottoPrize, Integer> expectedResult) {
        assertThat(lottoResultService.resultFrom(winningLottoDto, lottos).getResult()).isEqualTo(expectedResult);
    }

    static Stream<Arguments> generateTestCase() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(11, 12, 13, 4, 5, 6)), new Lotto(List.of(11, 12, 13, 14, 5, 6))
        );
        Map<LottoPrize, Integer> expectedResult = Map.of(
                LottoPrize.FIRST, 1, LottoPrize.SECOND, 1,
                LottoPrize.THIRD, 0, LottoPrize.FOURTH, 0, LottoPrize.FIFTH, 1
        );
        WinningLottoDto winningLottoDto = new WinningLottoDto(List.of(1, 2, 3, 4, 5, 6), 7);
        return Stream.of(
                Arguments.of(winningLottoDto, lottos, expectedResult)
        );
    }

    @DisplayName("사용자의 수익률 계산을 테스트 합니다.")
    @ParameterizedTest
    @MethodSource("generateWinningRateCase")
    void resultFromWinningRateTest(WinningLottoDto winningLottoDto, List<Lotto> lottos, String expectedWinningRate) {
        LottoResultDto lottoResultDto = lottoResultService.resultFrom(winningLottoDto, lottos);
        assertThat(lottoResultDto.getWinningRate()).isEqualTo(expectedWinningRate);
    }

    static Stream<Arguments> generateWinningRateCase() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(11, 12, 13, 4, 5, 6)), new Lotto(List.of(11, 12, 13, 14, 5, 6))
        );
        Double winningRate = (2030005000.0 / (lottos.size() * 1000)) * 100;
        String expectedWinningRate = String.format("%.1f", winningRate);
        WinningLottoDto winningLottoDto = new WinningLottoDto(List.of(1, 2, 3, 4, 5, 6), 7);
        return Stream.of(
                Arguments.of(winningLottoDto, lottos, expectedWinningRate)
        );
    }
}