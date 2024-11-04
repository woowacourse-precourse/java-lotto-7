package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.domain.lotto.LottoStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {

    private final LottoStore lottoStore = new LottoStore();

    @Test
    @DisplayName("금액을 입력했을 때 구매 가능한 로또 개수 계산")
    void getLottoCount_validInput() {
        // given
        String money = "5000";

        // when
        int result = lottoStore.getLottoCount(money);

        // then
        assertEquals(5, result, "5000원을 입력했을 때 로또 개수는 5여야 합니다.");
    }
}
