package lotto.service;

import lotto.domain.LottoTickets;
import lotto.domain.PurchaseAmount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoShopImplTest {
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        this.lottoMachine = new LottoMachineImpl();
    }

    @Test
    void 로또_구매_수량_테스트() {
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