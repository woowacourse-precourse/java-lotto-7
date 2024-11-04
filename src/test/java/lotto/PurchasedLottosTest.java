package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PurchasedLottosTest {
    private PurchasedLottos purchasedLottos;

    @BeforeEach
    void setUp() {
        purchasedLottos = new PurchasedLottos();
    }

    @Test
    void 로또_추가하면_크기_증가() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        purchasedLottos.addLotto(lotto);
        assertThat(purchasedLottos.getSize()).isEqualTo(1);
        assertThat(purchasedLottos.getPurchasedLottos()).contains(lotto);
    }

    @Test
    void 로또_여러개_추가() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(11, 22, 33, 44, 3, 7));
        purchasedLottos.addLotto(lotto1);
        purchasedLottos.addLotto(lotto2);
        assertThat(purchasedLottos.getSize()).isEqualTo(2);
        assertThat(purchasedLottos.getPurchasedLottos()).containsExactly(lotto1, lotto2);
    }
}
