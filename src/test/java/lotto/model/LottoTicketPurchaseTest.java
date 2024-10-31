package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoTicketPurchaseTest {

    @DisplayName("로또 리스트에 널값이 들어오면 예외를 리턴해야한다.")
    @Test
    void 로또_리스트_널값이면_예외_발생() {
        assertThatThrownBy(() -> new LottoTicketPurchase(null, 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 티켓이 발급되지 않았습니다!");
    }

}