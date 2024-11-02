package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.converter.LottoWinningNumbersConverter;
import lotto.domain.Lotto;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.Lottos;
import lotto.domain.Ranking;
import lotto.dto.LottoOutputDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCheckServiceTest {

    private LottoCheckService lottoCheckService;

    @BeforeEach
    void setUp() {
        lottoCheckService = new LottoCheckService();
    }

    @DisplayName("사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 계산한다.")
    @Test
    void checkLottos() {
        // given
        String purchaseAmount = "8000";
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "7";
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbersConverter.toLottoWinningNumbers(winningNumbers,
                bonusNumber);

        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)),
                new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)),
                new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)),
                new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)),
                new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)),
                new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)),
                new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)),
                new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45))
        );
        Lottos lottos = new Lottos();
        lottoList.forEach(lottos::addLotto);

        // when
        LottoOutputDto lottoOutputDto = lottoCheckService.checkLottos(purchaseAmount, lottoWinningNumbers, lottos);
        Map<Ranking, Integer> lottoResult = lottoOutputDto.lottoResult().getLottoResult();
        double rateOfReturn = lottoOutputDto.rateOfReturn();

        // then
        assertThat(lottoResult.get(Ranking.FIFTH)).isEqualTo(1);
        for (Ranking ranking : Ranking.values()) {
            if (ranking != Ranking.FIFTH) {
                assertThat(lottoResult.get(ranking)).isEqualTo(0);
            }
        }
        assertThat(rateOfReturn).isEqualTo(62.5);
    }
}