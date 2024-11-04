package lotto;

import lotto.domain.InputMoney;
import lotto.domain.LottoList;
import lotto.service.LottoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("정상적인 로또 구입")
    void test1() {
        InputMoney inputMoney = new InputMoney(50000);
        LottoList lottoList = lottoService.buyLottos(inputMoney);
        Assertions.assertThat(lottoList).isNotNull();
        Assertions.assertThat(lottoList.getSize()).isEqualTo(50);
    }
}
