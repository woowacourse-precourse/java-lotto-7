package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameServiceTest {

    private final LottoGameService lottoGameService = new LottoGameService();

    @Test
    @DisplayName("구매한 로또 개수만큼 로또 번호가 생성되는지 확인")
    void 구매한_로또_개수만큼_로또_번호가_생성되는지_확인() {
        // given
        int purchaseCount = 5;

        // when
        List<Lotto> lottos = lottoGameService.generatePurchaserLottos(purchaseCount);

        // then
        assertThat(lottos).hasSize(purchaseCount);
    }

    @Test
    @DisplayName("각 로또 번호가 오름차순으로 정렬되어 생성되는지 확인")
    void 각_로또_번호가_오름차순으로_정렬되어_생성되는지_확인() {
        // given
        int purchaseCount = 3;

        // when
        List<Lotto> lottos = lottoGameService.generatePurchaserLottos(purchaseCount);

        // then
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers).isSorted();
        }
    }
}
