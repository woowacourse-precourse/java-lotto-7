package lotto.domain;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.List;
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
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 10000을 초과하면 예외가 발생한다.")
    @Test
    void 구입금액이_10000원을_초과하면_예외() {
        assertThatThrownBy(() -> {
            RandomNumberGenerator generator = new RandomNumberGenerator();
            new IssuedRandomLotto(generator, 11000);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("발행 로또는 중복되지 않은 랜덤한 6개 번호를 생성한다.")
    @Test
    void 발행로또_랜덤생성_확인() {
        Assertions.assertRandomUniqueNumbersInRangeTest(() -> {
            // given
            RandomNumberGenerator generator = new RandomNumberGenerator();
            IssuedRandomLotto issuedLotto = new IssuedRandomLotto(generator, 2000);

            // when
            issuedLotto.generateIssuedLottos();

            // then
            assertThat(issuedLotto.getIssuedLottos().size()).isEqualTo(2);
            assertThat(issuedLotto.getIssuedLottos().get(0).getNumbers().size())
                    .isEqualTo(6);
        }, List.of(1, 2, 3, 4, 5, 6), List.of(2, 4, 7, 11, 30, 45));
    }

    // todo: 발행된 모든 로또 반환 확인 테스트
//    @DisplayName("발행된 모든 로또를 반환한다.")
//    @Test
//    void 발행로또_목록_반환() {
//        IssuedRandomLotto issuedLotto = new IssuedRandomLotto(1000);
//        issuedLotto.
//    }
}
