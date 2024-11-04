package lotto.application.service;

import static org.assertj.core.api.Assertions.*;

import lotto.application.dto.response.PurchaseLottoResponse;
import lotto.application.port.input.PurchaseLottoUsecase;
import lotto.domain.lotto.repository.FakeLottoRepository;
import lotto.domain.lotto.repository.LottoRepository;
import lotto.domain.lotto.service.LottoMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PurchaseLottoCommand 클래스 테스트")
class PurchaseLottoCommandTest {

    private PurchaseLottoUsecase purchaseLottoUsecase;
    private LottoRepository lottoRepository;

    @BeforeEach
    void setup() {
        lottoRepository = new FakeLottoRepository();
        purchaseLottoUsecase = new PurchaseLottoCommand(lottoRepository, new LottoMachine());
    }

    @Test
    void 구매_금액_만큼의_로또를_구매한다() {
        // given
        int purchaseAmount = 5000;

        // when
        PurchaseLottoResponse response = purchaseLottoUsecase.execute(purchaseAmount);

        // then
        assertThat(response.lottos().size()).isEqualTo(5);
        assertThat(lottoRepository.findAll()).hasSize(5);
    }
}