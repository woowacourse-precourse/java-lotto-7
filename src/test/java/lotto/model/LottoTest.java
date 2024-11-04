package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;

import static lotto.constants.ErrorMessage.LOTTO_NUMBER_MUST_BE_ONE_TO_FORTY_FIVE;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1부터 45 사이의 값이 아니면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfLottoRangeNOTOneToFortyFive() {
        // given
        List<Integer> numbers = new ArrayList<>(Arrays.asList(0, 3, 4, 18, 34, 40));

        // when
        Throwable thrown = catchThrowable(() -> {
            Lotto lotto = new Lotto(numbers);
        });

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_MUST_BE_ONE_TO_FORTY_FIVE.get());
    }
}
