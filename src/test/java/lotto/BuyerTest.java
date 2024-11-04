package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

class BuyerTest {

    @Test
    @DisplayName("purchaseLottos는 구매 금액에 따라 올바른 수의 로또를 생성한다.")
    void purchaseLottos_createsCorrectNumberOfLottos() {
        // given
        int purchaseAmount = 5000; // 구매 금액 설정
        Buyer buyer = new Buyer(purchaseAmount);

        // Mock LottoNumGenerator 생성
        LottoNumGenerator mockGenerator = new LottoNumGenerator() {
            @Override
            public List<Integer> generateNum() {
                return Arrays.asList(1, 2, 3, 4, 5, 6);
            }
        };

        // when
        buyer.purchaseLottos(mockGenerator);

        // then
        List<Lotto> purchasedLottos = buyer.getPurchasedLottos();
        int expectedNumberOfLottos = purchaseAmount / 1000;

        // 구매한 로또 개수 확인
        assertThat(purchasedLottos).hasSize(expectedNumberOfLottos);

        // 구매한 로또들이 실제로 존재하는지 확인
        for (Lotto lotto : purchasedLottos) {
            assertThat(lotto).isNotNull();
        }
    }
}
