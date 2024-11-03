package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningResult;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {


    private LottoGame lottoGame;
    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame(5000);
    }

    @Test
    void 로또_구매_금액에_따른_개수_생성_테스트(){

        //when
        List<Lotto> userLottoList = lottoGame.generateUserLotto();

        //then
        assertThat(userLottoList.size()).isEqualTo(5);
    }

    @Test
    void 로또_당첨_결과_생성_테스트() {
        // given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // 로또 번호를 고정된 값으로 설정하여 당첨 여부 테스트
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        lottoGame.getUserLottoList().add(lotto);

        // when
        lottoGame.generateWinningResults(winningNumbers, bonusNumber);

        // then
        Map<WinningResult, Integer> winningResultCount = lottoGame.getWinningResultCount();
        assertThat(winningResultCount.get(WinningResult.THREE_MATCH)).isEqualTo(1);
        assertThat(winningResultCount.get(WinningResult.SIX_MATCH)).isEqualTo(0);
    }

    @Test
    void 수익률_계산_테스트() {
        // given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        lottoGame.getUserLottoList().add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        int expectedPrize = WinningResult.SIX_MATCH.getPrize();
        int totalSpent = lottoGame.getUserLottoList().size() * 1000;
        double expectedProfit = (double) expectedPrize / totalSpent * 100;

        // when
        lottoGame.generateWinningResults(winningNumbers, bonusNumber);
        double actualProfit = lottoGame.calculateProfitStatics(lottoGame.getTotalPrize());

        // then
        assertThat(actualProfit).isCloseTo(expectedProfit, Percentage.withPercentage(0.01));

    }



}
