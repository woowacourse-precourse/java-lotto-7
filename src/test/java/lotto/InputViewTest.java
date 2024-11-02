package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Controller.Application;
import lotto.Messages.ErrorMessage;
import lotto.Model.Lotto;
import lotto.View.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest extends NsTest {
    @Test
    @DisplayName("parseInt 정상 작동 테스트")
    void parseIntTest(){
        InputView inputView = new InputView();
        int actual = inputView.parseInt("123");
        assertThat(actual).isEqualTo(123);
    }

    @Test
    @DisplayName("parseInt 숫자가 아닌 것 테스트")
    void parseIntErrorTest(){
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.parseInt("123a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ONLY_NUMBER.getError());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
