package lotto.model;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResultCalculator;
import lotto.model.Ranking;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoResultManagerTest {

  LottoResultCalculator lottoResultCalculator;
  Lotto winningLotto;
  Lotto userLotto;
  @BeforeEach
  void setUp() {
    //given
    lottoResultCalculator = new LottoResultCalculator();
    winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6), 7);
    userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
  }

  @Test
  void 당첨_번호와_로또_번호를_비교해서_1등을_반환한다() {
    // when
    Ranking ranking = lottoResultCalculator.getLottoRanking(winningLotto, userLotto, 7);
    // then
    Assertions.assertThat(ranking).isEqualTo(Ranking.FIRST);
  }

  @Test
  void 구입금액과_당첨_금액을_이용해_총수익률을_계산한다(){
    // given
    Ranking ranking = lottoResultCalculator.getLottoRanking(winningLotto, userLotto, 7);
    int totalPurchasedPrice = 1000;
    // when
    int totalWinningPrice = ranking.getWinPrice();
    double result = lottoResultCalculator.calculateTotalEarningRate(totalPurchasedPrice, totalWinningPrice);
    // then
    Assertions.assertThat(result).isEqualTo(200000000.0);
  }
}
