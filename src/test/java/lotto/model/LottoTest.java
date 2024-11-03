package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.model.exception.DomainExceptionMessage;
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
                .hasMessageContaining(DomainExceptionMessage.INVALID_LOTTO_SIZE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainExceptionMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
    }
}