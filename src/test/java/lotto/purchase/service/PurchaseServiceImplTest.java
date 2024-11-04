package lotto.purchase.service;

import lotto.lotto.controller.port.LottoService;
import lotto.lotto.infrastructure.FakeLottoRepository;
import lotto.lotto.service.MockLottoService;
import lotto.lotto.service.port.LottoRepository;
import lotto.purchase.controller.port.PurchaseService;
import lotto.purchase.domain.Money;
import lotto.purchase.domain.Purchase;
import lotto.purchase.infrastructure.FakePurchaseRepository;
import lotto.purchase.service.port.PurchaseRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseServiceImplTest {

    private PurchaseRepository purchaseRepository;
    private LottoRepository lottoRepository;
    private LottoService lottoService;
    private PurchaseService purchaseService;

    @BeforeEach
    void setUp() {
        purchaseRepository = new FakePurchaseRepository();
        lottoRepository = new FakeLottoRepository();
        lottoService = new MockLottoService();
        purchaseService = new PurchaseServiceImpl(lottoService, purchaseRepository, lottoRepository);
    }

    @Test
    @DisplayName("money value가 주어지면 purchase를 제작하여 purchase를 반환한다.")
    void createPurchaseTest() {
        // given
        long money = 10000;

        // when
        Purchase purchase = purchaseService.createPurchase(money);
        Purchase findPurchase = purchaseRepository.findById(purchase.getId());

        // then
        Assertions.assertThat(purchase).isNotNull();
        Assertions.assertThat(purchase).isEqualTo(findPurchase);
        Assertions.assertThat(purchase.getMoney().getQuantitiesCanBuy())
                .isEqualTo(Money.of(money).getQuantitiesCanBuy());
    }
}