package lotto.model;

import static lotto.common.ConstantsForTest.START_INCLUSIVE;
import static lotto.common.ConstantsForTest.VALID_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.common.NumberGenerator;
import lotto.model.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(NumberGenerator.generateNumbersWithSizeAndRange(
                START_INCLUSIVE, VALID_SIZE + 1
        )))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        // given
        List<Integer> numbers = NumberGenerator.generateNumbersWithSizeAndRange(START_INCLUSIVE, VALID_SIZE - 1);
        numbers.add(numbers.get(0));

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
