package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class LottoServiceTest {

    @DisplayName("결과 집계 중 예외가 발생하지 않는다.")
    @Test
    void 로또_당첨_결과를_수행한다() {
        LottoService lottoService = new LottoService(new InputView(), new OutputView());
        List<Lotto> purchasedLottos = lottoService.setLottos(1000);

        assertThatCode(() -> lottoService.calculateResult(
                purchasedLottos,
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                7
                )).doesNotThrowAnyException();
    }
}
