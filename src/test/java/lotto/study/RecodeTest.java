package lotto.study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.vo.Wallet;
import lotto.domain.vo.PurchaseAmount;

public class RecodeTest {
    private static final int DEFALUT_UNIT = 1000;

    @Test
    @DisplayName("Record는 getter 메서드를 자동으로 생성한다")
    void recordAutomaticallyCreatesGetter() {
        PurchaseAmount amount = new PurchaseAmount(DEFALUT_UNIT);
        Wallet wallet = new Wallet(amount);

        assertThat(amount.amount()).isEqualTo(DEFALUT_UNIT);
        assertThat(wallet.lottos().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Record는 equals와 hashCode를 자동으로 구현한다")
    void recordImplementsEqualsAndHashCode() {
        PurchaseAmount amount1 = new PurchaseAmount(DEFALUT_UNIT);
        PurchaseAmount amount2 = new PurchaseAmount(DEFALUT_UNIT);

        assertThat(amount1).isEqualTo(amount2);
        assertThat(amount1.hashCode()).isEqualTo(amount2.hashCode());
    }
}
