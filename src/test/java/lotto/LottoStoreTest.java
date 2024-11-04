package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoStore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {
    private final LottoStore lottoStore = new LottoStore();
    private static final int PAYMENT_AMOUNT = 13000;
    private static final int EXPECTED_LOTTO_COUNT = 13;

    @DisplayName("13000원을 지불하면 13개의 로또 번호를 생성한다.")
    @Test
    void orderLottosTest() {
        int lottoCount = lottoStore.orderLottos(PAYMENT_AMOUNT).size();
        Assertions.assertEquals(lottoCount, EXPECTED_LOTTO_COUNT);
    }
}
