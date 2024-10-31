package lotto.validator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest extends NsTest {

    @Test
    void 보너스_번호가_아무런_값을_갖지_않는_경우() throws Exception {
        assertThatThrownBy(() -> {
            BonusNumberValidator.validate("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호에_공백을_입력한_경우() throws Exception {
        assertThatThrownBy(() -> {
            BonusNumberValidator.validate(" ");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호에_문자를_입력한_경우() throws Exception {
        assertThatThrownBy(() -> {
            BonusNumberValidator.validate("a");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호에_올바르지_않은_범위의_숫자를_입력한_경우() throws Exception {
        assertThatThrownBy(() -> {
            BonusNumberValidator.validate("46");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {

    }
}
