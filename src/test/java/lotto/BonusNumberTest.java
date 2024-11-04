package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest extends NsTest {

    @Test
    void 보너스_번호가_비어있는_경우_예외_발생() {
        assertThatThrownBy(() -> runException("8000", "1,2,3,4,5,6", " "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호를 입력해주세요.");
    }

    @Test
    void 보너스_번호가_1과_45사이_밖의_값인_경우_예외_발생() {
        assertThatThrownBy(() -> runException("8000", "1,2,3,4,5,6", "0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 0: 1과 45사이의 숫자가 아닙니다.");

        assertThatThrownBy(() -> runException("8000", "1,2,3,4,5,6", "60"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 60: 1과 45사이의 숫자가 아닙니다.");
    }

    @Test
    void 보너스_번호가_정수가_아닌_경우_예외_발생() {
        assertThatThrownBy(() -> runException("8000", "1,2,3,4,5,6", "2@@$!"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 값이 포함되어 있습니다.");
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복되는_경우_예외_발생() {
        assertThatThrownBy(() -> runException("8000", "1,2,3,4,5,6", "3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 3: 당첨 번호와 중복되지 않는 숫자를 입력해주세요.");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}