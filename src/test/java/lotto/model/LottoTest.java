package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_쉼표로만_구분되지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto("1,2,3;4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_공백을_입력_받으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호는_1에서_45사이의_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호는_오름차순으로_정렬_되어야_한다() {
        Lotto lotto = new Lotto("1,5,3,2,6,4");

        List<Number> numbers = lotto.getLottoNumbers();

        assertThat(numbers).extracting(Number::getValue).isSorted();
    }
}
