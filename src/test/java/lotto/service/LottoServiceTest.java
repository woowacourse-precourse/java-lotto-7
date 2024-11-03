package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.dto.Lottos;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService(new Lottos());

    @Nested
    class 로또_구매는 {

        @Test
        void 금액이_1000으로_나누어지지_않으면_예외처리() {
            int amount = 1001;

            assertThatThrownBy(() -> lottoService.buyLotto(amount))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 금액이_음수면_예외처리() {
            int amount = -1000;

            assertThatThrownBy(() -> lottoService.buyLotto(amount))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 금액이_1000으로_나누어지고_음수가_아니면_로또_생성() {
            int amount = 1000;
            lottoService.buyLotto(amount);
            assertThat(lottoService.getLottosNum()).isNotNull();
            assertThat(lottoService.getLottosNum().size()).isEqualTo(1);
        }
    }

}