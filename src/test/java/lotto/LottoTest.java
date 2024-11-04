package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.validator.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest extends NsTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가는_경우_예외_발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void 로또_번호의_개수가_6개보다_적은_경우_예외_발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있는_경우_예외_발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복되지 않는 6개의 당첨 번호를 입력해 주세요.");
    }

    @Test
    void 로또_번호기_비어있는_경우_예외_발생() {
        assertThatThrownBy(() -> runException("8000", " ", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호를 입력해주세요.");
    }

    @Test
    void 로또_번호에_공백이_포함된_경우_예외_발생() {
        assertThatThrownBy(() -> runException("8000", "1, 2, 3, 4, 5, ", "7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_정수가_이닌_값이_있는_경우_예외_발생() {
        assertThatThrownBy(() -> runException("8000", "1, 2, 3%%, 4, 5!!@, 6", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호에 유효하지 않은 값이 포함되어 있습니다.");
    }

    @Test
    void 로또_번호에_1과_45사이_밖의_값이_있는_경우_예외_발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 80, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 80: 1과 45사이의 숫자가 아닙니다.");

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 0, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 0: 1과 45사이의 숫자가 아닙니다.");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
