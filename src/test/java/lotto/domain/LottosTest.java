package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import lotto.service.LottoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {
    private LottoService lottoService = new LottoService();

    @Test
    @DisplayName("입력 금액에 맞게 로또를 구매")
    void buyLottos() {
        Money money = new Money("3000");

        Lottos lottos = lottoService.buyLottos(money);
        int expectedLottoCount = money.getValue() / 1000;

        assertThat(lottos.getLottos().size()).isEqualTo(expectedLottoCount);
    }

    @Test
    @DisplayName("")
    void a() {

    }
}
