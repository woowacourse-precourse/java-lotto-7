package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoShopTest {
    private LottoShop lottoShop;

    @BeforeEach
    void setUp() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        lottoShop = new LottoShop(lottoGenerator);
    }

    @DisplayName("구매 금액을 입력해 로또를 생성한다.")
    @Test
    void 구매_금액을_입력해_로또를_생성한다() {
        List<Lotto> lottoTickets = lottoShop.buyLottoTickets(5000);

        assertEquals(5, lottoTickets.size());
    }

    @DisplayName("1,000원 미만 입력 시 예외가 발생한다.")
    @Test
    void 금액이_1000원_미만_입력_시_예외가_발생한다() {
        assertThatThrownBy(() -> lottoShop.buyLottoTickets(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액은 1,000원 단위로 입력하지 않으면 예외가 발생한다.")
    @Test
    void 구매_금액은_1000원_단위로_입력하지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> lottoShop.buyLottoTickets(5500))
                .isInstanceOf(IllegalArgumentException.class);
    }

}