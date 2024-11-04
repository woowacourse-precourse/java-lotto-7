package lotto.lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoDomainTest {

    @Test
    @DisplayName("Lotto 생성 테스트")
    void createLottoTest() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        Assertions.assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    // 6자리 숫자가 아니면 Lotto 생성이 되지 않고 IllegalArgumentException을 던진다.
    @Test
    @DisplayName("Lotto 번호가 1과 45사이의 정수가 아니면 IllegalArgumentException을 던진다.")
    void createNumberOutboundExceptionTest() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 100);

        Assertions.assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto 번호가 중복이라면 IllegalArgumentException을 던진다.")
    void createDuplicateNumberExceptionTest() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 1);

        Assertions.assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalArgumentException.class);
    }
}