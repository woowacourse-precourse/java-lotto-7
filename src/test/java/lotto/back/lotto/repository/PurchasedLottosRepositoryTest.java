package lotto.back.lotto.repository;

import lotto.back.lotto.domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PurchasedLottosRepositoryTest {

    private final PurchasedLottosRepository purchasedLottosRepository = new PurchasedLottosRepository();

    @Test
    void 기본_동작_테스트() {
        // given
        Lottos lottos = Lottos.generateRandomLottos(1000);

        // when
        purchasedLottosRepository.save(lottos);
        Lottos savedLottos = purchasedLottosRepository.findById(lottos.getUuid());

        // then
        Assertions.assertThat(savedLottos).isEqualTo(lottos);
    }

}