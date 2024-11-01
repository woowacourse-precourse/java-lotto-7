package lotto.test.serviceTest;

import lotto.service.ValidChecker;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidCheckerTest {
    @Test
    public void testCheckUnderMaximum() {
        int check = 46;
        assertThatThrownBy(() -> new ValidChecker().checkUnderMaximum(check))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자는 1~45 중 골라야 합니다");
    }

    @Test
    public void testNotInt() {
        assertThatThrownBy(() -> new ValidChecker().notInt("j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자가 아닌 입력은 허용되지 않습니다");
    }

    @Test
    public void testNotContainComma() {
        assertThatThrownBy(() -> new ValidChecker().notContainComma("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 쉼표로 구분된 6개의 숫자를 넣어주세요");
    }

    @Test
    public void testNotSixNumbers() {
        assertThatThrownBy(() -> new ValidChecker().notSixNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 쉼표로 구분된 6개의 숫자를 넣어주세요");
    }

    @Test
    public void run() {
        testCheckUnderMaximum();
        testNotInt();
        testNotContainComma();
        testNotSixNumbers();
    }
}
