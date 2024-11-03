package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoTicketPurchaseTest {

    @DisplayName("로또 리스트에 널값이 들어오면 예외를 리턴해야한다.")
    @Test
    void 로또_리스트_널값이면_예외_발생() {
        assertThatThrownBy(() -> new LottoTicketPurchase(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매 개수가 0개입니다.");
    }

    @DisplayName("구매 개수가 0개이면 발급 불가 멘트가 나와야한다.")
    @Test
    void 구매개수_0개면_발급_불가_예외_발생() {
        assertThatThrownBy(() -> new LottoTicketPurchase(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매 개수가 0개입니다.");
    }

}