package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {
    @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {1500, 2001, 999})
    void validatePurchaseAmount(int amount) {
        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.purchase(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
    }

    @DisplayName("구입 금액이 0 이하이면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, -1000})
    void validatePositiveAmount(int amount) {
        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.purchase(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 0원보다 커야 합니다.");
    }

    @DisplayName("구입 금액에 맞게 로또를 발급한다")
    @Test
    void purchaseLottos() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.purchase(5000);

        assertThat(lottos).hasSize(5);
    }

    @DisplayName("발급된 로또는 오름차순으로 정렬되어 있어야 한다")
    @Test
    void lottoNumbersShouldBeSorted() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.purchase(1000);
        List<Integer> numbers = lottos.get(0).getNumbers();

        assertThat(numbers).isSorted();
    }
}