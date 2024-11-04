package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.service.UserInputService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserInputServiceTest {

    UserInputService userInputService;

    @BeforeEach
    public void setUp() {
        this.userInputService = new UserInputService();
    }

    @Test
    void 입력이_빈칸이면_예외가_발생한다() {
        assertThatThrownBy(() -> userInputService.getPurchaseAmount(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력이_NULL이면_예외가_발생한다() {
        assertThatThrownBy(() -> userInputService.getPurchaseAmount(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력이_1000보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> userInputService.getPurchaseAmount("234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력이_음수이면_예외가_발생한다() {
        assertThatThrownBy(() -> userInputService.getPurchaseAmount("-2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자에_다른_문자가_있으면_오류() {
        assertThatThrownBy(() -> userInputService.getPurchaseAmount("1233j"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}