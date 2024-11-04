package lotto.controller;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsControllerTest {


    @DisplayName("로또 구입 금액, 로또, 당첨번호를 가지고 결과를 생성한다.")
    @Test
    void calculateLottoPrizes() {
        // given
        LottoStatisticsController controller = new LottoStatisticsController();

        long userPurchaseMoney = 1000;

        Lotto lotto = Lotto.createLotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);
        Lottos lottos = Lottos.createLottos(lottoList);

        Set<Integer> winningNumbers = new HashSet<>(List.of(4, 5, 6, 7, 8, 9));
        int bonusNumber = 10;
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.createLottoWinningNumbers(winningNumbers, bonusNumber);

        // when
        LottoResult lottoResult = controller.calculateLottoPrizes(lottos, lottoWinningNumbers, userPurchaseMoney);

        // then
        assertThat(lottoResult.getLottoPrizeCounts(LottoPrize.FIFTH_PRIZE))
            .isEqualTo(1);
    }
}