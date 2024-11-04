package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyLottoTest {
    private final Lotto lottoHitAll = new Lotto(List.of(1,2,3,4,5,6));

    private final Lotto lottoHitFive = new Lotto(List.of(2,3,4,5,6,7));


    private final Lotto lottoHitFour = new Lotto(List.of(3,4,5,6,7,8));

    @Test
    @DisplayName("로또 금액 여부를 확인한다")
    void 로또_당첨_금액_확인() {
        MyLotto lottos = MyLotto.createLottos(1, purchaseAmount -> List.of(lottoHitAll));

        Assertions.assertThat(lottos.getResultStatistic(new WinningLotto(lottoHitAll, 7)).getTotalPrize()).isEqualTo(2_000_000_000);

    }


    @Test
    @DisplayName("5개(2~6) + 보너스 번호(1) 맞출 시 2등 금액이 수령되는지")
    void 로또_2등_상금() {

        MyLotto lottos = MyLotto.createLottos(1, purchaseAmount -> new ArrayList<>());
        lottos.additionalLotto(lottoHitAll);

        Assertions.assertThat(lottos.getResultStatistic(new WinningLotto(lottoHitFive, 1)).getTotalPrize()).isEqualTo(30_000_000);
    }

    @Test
    @DisplayName("4개 + 보너스 번호 맞출 시 4등 금액 정상 수령 되는지")
    void 로또_2등_제외_보너스번호_상금_테스트() {

        MyLotto lottos = MyLotto.createLottos(1, purchaseAmount -> new ArrayList<>());
        lottos.additionalLotto(lottoHitAll);

        Assertions.assertThat(lottos.getResultStatistic(new WinningLotto(lottoHitFour, 1)).getTotalPrize()).isEqualTo(50000);
    }
}
