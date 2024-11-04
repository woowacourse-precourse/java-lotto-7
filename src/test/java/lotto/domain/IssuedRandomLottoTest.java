package lotto.domain;

import lotto.common.ExceptionMessage;
import lotto.common.LottoConfig;
import lotto.common.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IssuedRandomLottoTest {
    @DisplayName("로또 구입 금액이 1000으로 나누어떨어지지 않으면 예외가 발생한다.")
    @Test
    void 구입금액이_1000으로_나누어떨어지지_않으면_예외() {
        assertThatThrownBy(() -> {
            RandomNumberGenerator generator = new RandomNumberGenerator();
            new IssuedRandomLotto(generator, 9800);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
    }

    @DisplayName("로또 구입 금액이 100000을 초과하면 예외가 발생한다.")
    @Test
    void 구입금액이_10000원을_초과하면_예외() {
        assertThatThrownBy(() -> {
            RandomNumberGenerator generator = new RandomNumberGenerator();
            new IssuedRandomLotto(generator, 110000);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_MAXIMUM_PURCHASE_AMOUNT.getMessage());
    }

    @DisplayName("구입 금액만큼 로또를 발행한다.")
    @Test
    void 구입금액만큼_로또_생성_확인() {
        // given
        RandomNumberGenerator generator = new RandomNumberGenerator();
        IssuedRandomLotto issuedLotto = new IssuedRandomLotto(generator, 2000);

        // when
        issuedLotto.generateIssuedLottos();

        // then
        assertThat(issuedLotto.getIssuedLottos().size()).isEqualTo(2);
        assertThat(issuedLotto.getIssuedLottos().get(0).getNumbers().size())
                .isEqualTo(LottoConfig.LOTTO_PICK_COUNT.getValue());
    }
}
