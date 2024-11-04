package lotto.model;

import lotto.message.LottoErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoTest {

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
    public void 로또번호_생성_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertEquals(6, lotto.getNumbers().size());
        assertEquals(List.of(1, 2, 3, 4, 5, 6), lotto.getNumbers());
    }

    @Test
    @DisplayName("로또 번호가 유효하지 않다면 예외가 발생한다.")
    public void 유효하지_않은_로또번호_테스트() {
        assertThrows(IllegalArgumentException.class,
                () -> new Lotto(List.of(1, 2, 3, 4, 5)),
                LottoErrorMessage.INVALID_NUMBER_COUNT.getMessage());

        assertThrows(IllegalArgumentException.class,
                () -> new Lotto(List.of(0, 1, 2, 3, 4, 5)),
                LottoErrorMessage.INVALID_NUMBER_RANGE.getMessage());

        assertThrows(IllegalArgumentException.class,
                () -> new Lotto(List.of(1, 2, 2, 4, 5, 6)),
                LottoErrorMessage.DUPLICATE_NUMBER.getMessage());
    }
}
