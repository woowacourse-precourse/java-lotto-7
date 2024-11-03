package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PublishLotteriesTest {
    @Test
    @DisplayName("구매 개수만큼 로또가 발행된다.")
    void publishing() {
        int purchaseCount = 5;
        PublishLotteries publishLotteries = new PublishLotteries(purchaseCount);

        assertThat(publishLotteries.get()).hasSize(purchaseCount);
    }

    @Test
    @DisplayName("각 로또는 6개의 고유한 번호를 가지고 있다.")
    void eachLottoShouldHaveSixUniqueNumbers() {
        int purchaseCount = 3;
        PublishLotteries publishLotteries = new PublishLotteries(purchaseCount);

        for (Lotto lotto : publishLotteries.get()) {
            assertThat(lotto.get()).hasSize(6);
            assertThat(lotto.get()).doesNotHaveDuplicates();
        }
    }

    @Test
    @DisplayName("각 로또 번호는 1~45 범위 내의 숫자이다.")
    void lottoNumbersShouldBeWithinValidRange() {
        int purchaseCount = 3;
        PublishLotteries publishLotteries = new PublishLotteries(purchaseCount);

        for (Lotto lotto : publishLotteries.get()) {
            assertThat(lotto.get()).allMatch(number -> number >= 1 && number <= 45);
        }
    }
}
