package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constants.ErrorMessage.LOTTO_NUMBER_ONLY_CAN_LENGTH_6;
import static lotto.constants.ErrorMessage.LOTTO_NUMBER_ONLY_CAN_RANGE_1_TO_45;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_ONLY_CAN_LENGTH_6.getErrorMessage());
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개 미만 수 입력시 예외가 발생한다.")
    void 로또_번호의_개수가_6개_미만_수_입력시_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_ONLY_CAN_LENGTH_6.getErrorMessage());
    }

    @Test
    @DisplayName("로또 번호에 중복되지 않은 6개의 수 입력")
    void 로또_번호에_중복되지_않은_6개의_수_입력() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        //when
        Lotto lottoNumbers = new Lotto(numbers);

        //then
        assertThat(lottoNumbers.getNumbers()).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_ONLY_CAN_LENGTH_6.getErrorMessage());
    }

    @Test
    @DisplayName("로또 번호는 1~45 사이")
    void 로또_번호는_1_45_사이() {
        //given
        List<Integer> numbers = List.of(40, 41, 42, 43, 44, 45);

        //when
        Lotto lottoNumbers = new Lotto(numbers);

        //then
        assertThat(lottoNumbers.getNumbers()).containsExactlyInAnyOrder(40, 41, 42, 43, 44, 45);
    }

    @Test
    @DisplayName("로또 번호는 1~45 사이가 아니면 예외가 발생한다.")
    void 로또_번호는_1_45_사이가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(41, 42, 43, 44, 45, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_ONLY_CAN_RANGE_1_TO_45.getErrorMessage());
    }
}
