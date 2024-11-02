package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.message.Error;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호의 갯수가 맞지 않으면, 해당 문구를 출력한다")
    void throw_when_lotto_size_is_incorrect() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.NOT_FIX_SIZE.formatMessageOf(6));
    }

    @Test
    @DisplayName("발생하는 예외 문구에는 캡션이 포함되어 있다")
    void message_has_caption() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.CAPTION.getMessage());
    }
}
