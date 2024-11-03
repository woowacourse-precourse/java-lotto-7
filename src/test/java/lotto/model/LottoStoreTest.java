package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoStoreTest {

    @Test
    @DisplayName("유효한 금액 입력 시 LottoTicket 생성 테스트")
    void makeLottoTicket_validPurchaseMoney() {
        String purchaseMoney = "5000";

        LottoTicket lottoTicket = LottoStore.makeLottoTicket(purchaseMoney);

        assertThat(lottoTicket).isNotNull();
        assertThat(lottoTicket.getLottosCount()).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource( strings = {"abc" , "a1w2", "qwer1234"})
    @DisplayName("금액이 숫자가 아닐 경우 예외 발생")
    void makeLottoTicket_invalidPurchaseMoneyNotNumber(String purchaseMoney) {
        assertThatThrownBy(() -> LottoStore.makeLottoTicket(purchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
