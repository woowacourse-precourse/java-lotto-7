package lotto;

import lotto.domain.LottoTickets;
import lotto.domain.PurchaseAmount;
import lotto.service.LottoMachine;
import lotto.service.LottoMachineImpl;
import lotto.service.LottoShopImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoShopImplTest {
    private LottoMachine lottoMachine;
    @BeforeEach
    void setUp() {
        this.lottoMachine = new LottoMachineImpl();
    }
    @DisplayName("로또 구매 금액만큼 알맞은 수량으로 로또가 반환된다")
    @Test
    void 로또_구매() {
        //given
        int amount = 7000;
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        //when
        LottoShopImpl lottoShopImpl = new LottoShopImpl(lottoMachine);
        LottoTickets lottoTickets = lottoShopImpl.publishTickets(purchaseAmount);
        //then
        Assertions.assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(7);
    }
}