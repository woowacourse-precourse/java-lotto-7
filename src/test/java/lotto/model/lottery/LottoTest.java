package lotto.model.lottery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.common.Constants.ERROR_HEADER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {

    @DisplayName("1장의 로또는 6개의 번호를 가진다.")
    @Test
    void 한장의_로또는_여섯개의_번호를_가진다() {
        assertDoesNotThrow(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또 번호가 6개 미만의 개수일 경우 예외가 발생한다.")
    void 로또_번호가_여섯개_미만의_개수일_경우_예외가_발생한다() {
        assertLottoThrows(List.of(1, 2, 3, 4, 5));
    }

    @DisplayName("로또 번호가 6개 초과의 개수일 경우 예외가 발생한다.")
    void 로또_번호가_여섯개_초과의_개수일_경우_예외가_발생한다() {
        assertLottoThrows(List.of(1, 2, 3, 4, 5, 6, 7));
    }

    @DisplayName("로또 번호의 범위는 1~45이다.")
    @Test
    void 로또_번호의_범위는_일에서_사십오_사이이다() {
        assertDoesNotThrow(() -> new Lotto(List.of(1, 5, 15, 25, 35, 45)));
    }

    @DisplayName("로또 번호가 1 미만일 경우 예외가 발생한다.")
    @Test
    void 로또_번호가_일_미만일_경우_예외가_발생한다() {
        assertLottoThrows(List.of(0, 2, 3, 4, 5, 7));
        assertLottoThrows(List.of(-1, 2, 3, 4, 5, 7));
    }

    @DisplayName("로또 번호가 45를 초과할 경우 예외가 발생한다.")
    @Test
    void 로또_번호가_사십오를_초과할_경우_예외가_발생한다() {
        assertLottoThrows(List.of(1, 2, 3, 4, 5, 46));
    }

    @DisplayName("로또 번호에 중복된 숫자가 있는 경우 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있는_경우_예외가_발생한다() {
        assertLottoThrows(List.of(1, 2, 3, 4, 5, 5));
    }

    @DisplayName("로또 번호가 null일 경우 예외가 발생한다.")
    @Test
    void 로또_번호가_null일_경우_예외가_발생한다() {
        assertLottoThrows(null);
    }

    void assertLottoThrows(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_HEADER);
    }
}
