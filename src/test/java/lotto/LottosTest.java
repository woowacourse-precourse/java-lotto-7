package lotto;

import lotto.domain.ticket.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    @DisplayName("로또를 구매 금액에 맞게 발행한다")
    @Test
    void createLottos() {
        Lottos lottos = Lottos.create(5);
        assertThat(lottos.getCount()).isEqualTo(5);
    }

    @DisplayName("null로 로또 목록을 생성할 수 없다")
    @Test
    void createLottosWithNull() {
        assertThatThrownBy(() -> new Lottos(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 목록이 null일 수 없습니다.");
    }

    @DisplayName("발행된 로또는 모두 올바른 번호를 가진다")
    @Test
    void validateLottoNumbers() {
        Lottos lottos = Lottos.create(5);

        lottos.getLottos().forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers).hasSize(6);
            assertThat(numbers.stream().distinct().count()).isEqualTo(6);
            assertThat(numbers.stream().allMatch(n -> n >= 1 && n <= 45)).isTrue();
        });
    }
}