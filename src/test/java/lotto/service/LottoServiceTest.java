package lotto.service;

import lotto.domain.Amount;
import lotto.domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @DisplayName("로또_번호_컬렉션_생성_테스트")
    @Test
    void 로또_번호_컬렉션_생성_테스트() {
        Amount amount = Amount.of("10000");
        Amount amount2 = Amount.of("5000");
        Amount amount3 = Amount.of("15000");

        Lottos lottos = new LottoService().createLottos(amount);
        Lottos lottos2 = new LottoService().createLottos(amount2);
        Lottos lottos3 = new LottoService().createLottos(amount3);

        Assertions.assertThat(lottos.getLottos().size()).isEqualTo(10);
        Assertions.assertThat(lottos2.getLottos().size()).isEqualTo(5);
        Assertions.assertThat(lottos3.getLottos().size()).isEqualTo(15);
    }

}
