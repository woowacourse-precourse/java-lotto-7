package lotto.application.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.repository.InMemoryLottoRepository;
import lotto.domain.repository.LottoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseLottoServiceTest {

    private LottoFactory lottoFactory = new LottoFactory();
    private LottoRepository lottoRepository = InMemoryLottoRepository.getInstance();
    private PurchaseLottoService purchaseLottoService = new PurchaseLottoService(lottoFactory, lottoRepository);

    @BeforeEach
    void setUp() {
        lottoRepository.clear();
    }

    @DisplayName("입력한 돈의 1000원 단위 개수만큼 로또를 구매한다.")
    @Test
    void purchase() {
      // given
      int unit = 1000;
      int money = 5000;
      // when
        purchaseLottoService.purchase(money);
      // then
        List<Lotto> purchasedLottos = lottoRepository.getAll();
        assertThat(purchasedLottos).hasSize(money/unit);
    }
}
