package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BonusNumberTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR";

    @Test
    @DisplayName("보너스 번호는 1부터 45까지의 숫자만 허용한다.")
    void 보너스_번호는_1부터_45까지의_숫자() {
        assertSimpleTest(() -> {
            run("3000", "1,2,3,4,5,6", "46");
            runException();
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("")
    void 보너스_번호와_당첨_번호는_중복될_수_없다() {
        assertSimpleTest(() -> {
            run("3000", "1,2,3,4,5,6", "6");
            runException();
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
