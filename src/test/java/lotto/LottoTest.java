package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.enums.ErrorMessage;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    void 로또_번호가_정확히_6개일_경우_Lotto_객체를_생성할_수_있다() {
        // given
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = new Lotto(validNumbers);

        // then
        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @Test
    void 로또_번호가_6개가_아니면_Lotto_객체_생성에_실패한다() {
        // given
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5);

        // when & then
        AssertionsForClassTypes.assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void 로또_번호가_1에서_45_사이가_아니면_Lotto_객체_생성에_실패한다() {
        // given
        List<Integer> outOfRangeNumbers = List.of(1, 2, 3, 4, 5, 46);

        // when & then
        AssertionsForClassTypes.assertThatThrownBy(() -> new Lotto(outOfRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }

    @Test
    void 로또_번호가_음수일_경우_Lotto_객체_생성에_실패한다() {
        List<Integer> negativeNumbers = List.of(-1, 2, 3, 4, 5, 6);
        AssertionsForClassTypes.assertThatThrownBy(() -> new Lotto(negativeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NEGATIVE_LOTTO_NUMBER_NOT_ALLOWED.getMessage());
    }
}
