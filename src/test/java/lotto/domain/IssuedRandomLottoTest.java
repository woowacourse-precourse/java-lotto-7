package lotto.domain;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IssuedRandomLottoTest {
    @DisplayName("로또 구입 금액이 1000으로 나누어떨어지지 않으면 예외가 발생한다.")
    @Test
    void 구입금액이_1000으로_나누어떨어지지_않으면_예외() {
        assertThatThrownBy(() -> new IssuedRandomLotto(9800))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 10000을 초과하면 예외가 발생한다.")
    @Test
    void 구입금액이_10000원을_초과하면_예외() {
        assertThatThrownBy(() -> new IssuedRandomLotto(11000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("발행 로또는 랜덤한 6개 번호를 생성하고 중복되면 중복된 것만 다시 뽑는다.")
    @Test
    void 발행로또_랜덤생성_확인() {
        Assertions.assertRandomNumberInRangeTest(() -> {
            // given
            IssuedRandomLotto issuedLotto = new IssuedRandomLotto(1000);

            // when
            issuedLotto.generateRandomLotto();

            // then
            assertThat(issuedLotto.getLottos.get(0).s는ize()).isEqual(6);
        }, 1, 2, 3, 4, 5, 5, 6);
    }

    // todo: 발행된 모든 로또 반환 확인 테스트
    /*@DisplayName("발행된 모든 로또를 반환한다.")
    @Test
    void 발행로또_목록_반환() {
        IssuedRandomLotto issuedLotto = new IssuedRandomLotto(1000);
        issuedLotto.
    }*/
}
