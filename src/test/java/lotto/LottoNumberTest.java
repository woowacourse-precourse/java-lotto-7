package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest extends NsTest {
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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
