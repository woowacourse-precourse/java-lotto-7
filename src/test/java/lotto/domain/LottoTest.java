package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개가_아니면_예외가_발생한다() {
        // given
        List<Integer> tooManyNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> tooFewNumbers = List.of(1, 2, 3, 4, 5);

        // when & then
        assertThatThrownBy(() -> new Lotto(tooManyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());

        assertThatThrownBy(() -> new Lotto(tooFewNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        // given
        List<Integer> duplicateNumbers = List.of(1, 2, 3, 4, 5, 5);

        // when & then
        assertThatThrownBy(() -> new Lotto(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("로또 번호가 1부터 45 사이의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 로또_번호가_범위를_벗어나면_예외가_발생한다() {
        // given
        List<Integer> belowRangeNumbers = List.of(0, 2, 3, 4, 5, 6);
        List<Integer> aboveRangeNumbers = List.of(1, 2, 3, 4, 5, 46);

        // when & then
        assertThatThrownBy(() -> new Lotto(belowRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());

        assertThatThrownBy(() -> new Lotto(aboveRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }

    @DisplayName("유효한 로또 번호로 객체를 생성할 수 있다.")
    @Test
    void 유효한_로또_번호로_객체를_생성할_수_있다() {
        // given
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatCode(() -> new Lotto(validNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호가_로또_번호와_중복되면_예외가_발생한다() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int duplicateBonusNumber = 6;

        // when & then
        assertThatThrownBy(() -> lotto.validateBonusNumber(duplicateBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_BONUS_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호가 1부터 45 사이의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 보너스_번호가_범위를_벗어나면_예외가_발생한다() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int belowRangeBonusNumber = 0;
        int aboveRangeBonusNumber = 46;

        // when & then
        assertThatThrownBy(() -> lotto.validateBonusNumber(belowRangeBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());

        assertThatThrownBy(() -> lotto.validateBonusNumber(aboveRangeBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }
}
