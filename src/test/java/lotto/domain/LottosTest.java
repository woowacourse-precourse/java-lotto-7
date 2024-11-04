package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.dto.PurchaseAmount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottosTest {
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        // 테스트를 위해 임의의 구매 금액을 설정 (예: 5장)
        PurchaseAmount purchaseAmount = new PurchaseAmount("5000");
        lottos = new Lottos(purchaseAmount);
    }

    @Test
    void generateRandomLottoNumbers() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("3000");
        Lottos newLottos = new Lottos(purchaseAmount);

        // 로또 번호가 올바르게 생성되었는지 확인
        List<Lotto> generatedLottos = newLottos.getLottos();

        // 로또 개수가 올바른지 확인
        assertThat(generatedLottos).hasSize(3);

        // 각 로또 번호가 유효한지 확인
        for (Lotto lotto : generatedLottos) {
            assertThat(lotto.getNumbers()).hasSize(6);
            for (Integer number : lotto.getNumbers()) {
                assertThat(number).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(45);
            }
        }
    }

    @Test
    void getLottos() {
        List<Lotto> retrievedLottos = lottos.getLottos();

        assertThat(retrievedLottos).hasSize(5);
    }

    @Test
    void displayLottos() {
        String displayedNumbers = lottos.displayLottos();

        assertThat(displayedNumbers).contains("[");
        assertThat(displayedNumbers).contains("]");
    }
}