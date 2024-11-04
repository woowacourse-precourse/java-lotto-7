package lotto.domain.model;

import lotto.domain.model.lotto.Lotto;
import lotto.exception.lotto.LottoErrorMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {
    private List<Integer> validNumbers;

    @BeforeEach
    void setUp() {
        validNumbers = List.of(8, 21, 15, 33, 40, 42);
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    void 로또_번호의_개수가_6개가_아니면_예외가_발생한다() {
        // given
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5);

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(invalidNumbers))
                .withMessage(LottoErrorMessages.INVALID_SIZE.getMessage());
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        // given
        List<Integer> duplicateNumbers = List.of(1, 2, 3, 4, 5, 5);

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(duplicateNumbers))
                .withMessage(LottoErrorMessages.DUPLICATE_NUMBER.getMessage());
    }

    @Test
    @DisplayName("로또 번호가 범위를 벗어나는 경우 예외가 발생한다.")
    void 로또_번호가_범위를_벗어나는_경우_예외가_발생한다() {
        // given
        List<Integer> outOfRangeNumbers = List.of(0, 2, 3, 4, 5, 6);

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(outOfRangeNumbers))
                .withMessage(LottoErrorMessages.OUT_OF_RANGE_NUMBER.getMessage());
    }

    @Test
    @DisplayName("로또 번호가 정상적으로 생성되는 경우이다.")
    void 로또_번호가_정상적으로_생성되는_경우이다() {
        // given
        Lotto lotto = new Lotto(validNumbers);

        // when, then
        assertThat(lotto.getNumbers()).containsExactlyInAnyOrderElementsOf(validNumbers);
    }
}