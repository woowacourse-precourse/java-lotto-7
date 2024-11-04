package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoStoreTest {

    @DisplayName("로또 구입 개수 계산 테스트")
    @Test
    void calculateLottoCountTest() {
        // given
        int money = 3000;
        LottoStore lottoStore = new LottoStore();

        // when
        int lottoCount = lottoStore.calculateLottoCount(money);

        // then
        assertThat(lottoCount).isEqualTo(3);
    }

    @DisplayName("로또 구입 금액이 로또 가격보다 작을 때 예외 발생")
    @Test
    void validateMoneyTest() {
        // given
        int money = 500;
        LottoStore lottoStore = new LottoStore();

        // when, then
        assertThatThrownBy(() -> lottoStore.calculateLottoCount(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 로또 가격의 배수가 아닐 때 예외 발생")
    @Test
    void validateMoneyMultipleTest() {
        // given
        int money = 1500;
        LottoStore lottoStore = new LottoStore();

        // when, then
        assertThatThrownBy(() -> lottoStore.calculateLottoCount(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 테스트")
    @Test
    void sellTest() {
        // given
        int lottoCount = 3;
        LottoStore lottoStore = new LottoStore();

        // when
        List<Lotto> lottos = lottoStore.sell(lottoCount);

        // then
        assertThat(lottos.size()).isEqualTo(3);
        assertThat(lottos.stream().allMatch(lotto -> lotto.getNumbers().size() == 6)).isTrue();
    }

}
