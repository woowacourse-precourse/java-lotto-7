package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultStatisticTest {
    private final Lotto lottoHitAll = new Lotto(List.of(1,2,3,4,5,6));

    private final Lotto lottoHitFive = new Lotto(List.of(2,3,4,5,6,7));

    @Test
    @DisplayName("수익률 테스트 한장 구매 시 3등으로 테스트하므로 300.0")
    void 수익률_테스트() {

        MyLotto lottos = MyLotto.createLottos(150, purchaseAmount -> new ArrayList<>());
        lottos.additionalLotto(lottoHitAll);
        LottoResultStatistic resultStatistic = lottos.getResultStatistic(new WinningLotto(lottoHitFive,10));
        Assertions.assertThat(resultStatistic.calculateProfit(150000)).isEqualTo(1000.0);
    }
}
