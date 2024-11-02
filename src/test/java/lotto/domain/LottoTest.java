package lotto.domain;

import static lotto.message.ErrorMessage.ERROR_DUPLICATE_WINNING_NUMBERS;
import static lotto.message.ErrorMessage.ERROR_WINNING_NUMBERS_RANGE;
import static lotto.message.ErrorMessage.ERROR_WINNING_NUMBERS_SIZE_LESS;
import static lotto.message.ErrorMessage.ERROR_WINNING_NUMBERS_SIZE_MORE;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("당첨 번호 입력에 성공합니다.")
    @Test
    void 당첨_번호_입력_성공() {
        assertThatCode(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호의 개수가 6개 초과하면 예외가 발생한다.")
    @Test
    void 로또_번호_개수_6개_초과_예외_발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_WINNING_NUMBERS_SIZE_MORE);
    }

    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void 로또_번호_개수_6개_미만_예외_발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_WINNING_NUMBERS_SIZE_LESS);
    }

    @DisplayName("6개의 로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호_6개_1_부터_45_사이_예외_발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_WINNING_NUMBERS_RANGE);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호_중복_숫자_예외_발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_DUPLICATE_WINNING_NUMBERS);
    }


}
