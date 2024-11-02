package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Controller.Application;
import lotto.Messages.ErrorMessage;
import lotto.Model.Lotto;
import lotto.View.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest extends NsTest {
    @Test
    @DisplayName("readPurchaseAmount 정상 작동 Test")
    void testReadPurchaseAmount() {
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("10000".getBytes()));
        int actual = inputView.readPurchaseAmount();
        assertThat(actual).isEqualTo(10000);
    }

    @Test
    @DisplayName("readPurchaseAmount 숫자가 아닌 경우")
    void testReadPurchaseAmount1000() {
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("1000a".getBytes()));
        assertThatThrownBy(() -> InputView.readPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ONLY_NUMBER.getError());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
