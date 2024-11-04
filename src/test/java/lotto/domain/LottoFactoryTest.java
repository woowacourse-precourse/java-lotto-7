package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {
    LottoFactory lottoFactory = new LottoFactory();
    @Test
    @DisplayName("로또 생성 검증")
    void createLotto() {
        // given
        int count=3;
        Lottos lottos = lottoFactory.getLottosCountOf(3);

        // when & then
        assertThat(lottos).isNotNull();
        assertThat(lottos.getCount()).isEqualTo(count);
    }

    @Test
    @DisplayName("로또는 양수만 가능")
    void positiveNumberOfCountOnlyAvailable() {
        assertThatThrownBy(()->lottoFactory.getLottosCountOf(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 갯수는 양의 정수만 가능합니다.");
    }
}
