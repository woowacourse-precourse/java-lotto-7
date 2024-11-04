package lotto.application.service;

import static org.assertj.core.api.Assertions.*;

import java.util.UUID;
import lotto.application.dto.request.PurchaseLottoRequest;
import lotto.application.dto.response.PurchaseLottoResponse;
import lotto.application.port.input.PurchaseLottoUsecase;
import lotto.domain.amount.PurchaseAmount;
import lotto.domain.lotto.repository.FakeLottoRepository;
import lotto.domain.lotto.repository.LottoRepository;
import lotto.domain.lotto.service.LottoMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PurchaseLottoCommand 클래스 테스트")
class PurchaseLottoCommandTest {

    private PurchaseLottoUsecase purchaseLottoUsecase;

    @BeforeEach
    void setup() {
        purchaseLottoUsecase = new PurchaseLottoCommand(new FakeLottoRepository(), new LottoMachine());
    }

    @Test
    void 구매_금액_만큼의_로또를_구매한다() {
        // given
        PurchaseLottoRequest purchaseLottoRequest = new PurchaseLottoRequest(PurchaseAmount.from(5000));

        // when
        PurchaseLottoResponse response = purchaseLottoUsecase.execute(purchaseLottoRequest);

        // then
        assertThat(response.lottos().size()).isEqualTo(5);
    }
}