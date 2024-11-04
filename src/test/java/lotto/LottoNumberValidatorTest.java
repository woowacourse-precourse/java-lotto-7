package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberValidatorTest {
    @Test
    void 로또_번호에_다른구분자가_포함돼있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoNumberValidator("1,2#3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_구분자가_맨앞에_위치해있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoNumberValidator(",1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_구분자가_맨뒤에_위치해있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoNumberValidator("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_구분자가_겹치면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoNumberValidator("1,,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_빈값이_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoNumberValidator(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_스페이스값이_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoNumberValidator(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
