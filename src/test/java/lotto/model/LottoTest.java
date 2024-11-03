package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    @DisplayName("로또 번호를 가지고 Lotto 객체를 생성할 수 있다.")
    void should_CreateLotto_When_GiverNumbers() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        // when
        Lotto lotto = new Lotto(numbers);
        // then
        Assertions.assertThat(lotto).isNotNull();
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닌 경우 예외가 발생한다.")
    void should_ThrowException_When_NotSixNumbers() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // when, then
        Assertions.assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개여야 합니다.");
    }

}