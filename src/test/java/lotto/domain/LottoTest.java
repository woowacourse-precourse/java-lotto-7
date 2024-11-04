package lotto.domain;

import lotto.utils.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void 로또_유효한_번호_생성() {
        Lotto lotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        assertEquals(6, lotto.getNumbers().size());
    }

    @Test
    void 로또_번호_개수_유효하지_않음_예외발생() {
        assertThrows(IllegalArgumentException.class, () ->
                new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)), ErrorMessage.INVALID_LOTTO_SIZE);
    }

    @Test
    void 로또_번호_중복_예외발생() {
        assertThrows(IllegalArgumentException.class, () ->
                new Lotto(List.of(1, 2, 3, 4, 5, 5)), ErrorMessage.DUPLICATE_LOTTO_NUMBER);
    }

}
