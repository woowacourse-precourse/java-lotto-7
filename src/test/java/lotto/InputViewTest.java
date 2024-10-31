package lotto.inputview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.List;
import lotto.model.Lotto;
import lotto.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @Test
    void 구입_금액을_입력받아야_한다() {
        String input = "5000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertEquals(5000, inputView.inputPurchaseAmount());
    }

    @Test
    void 당첨_번호를_입력받아야_한다() {
        String input = "1,2,3,4,5,6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Lotto winningLotto = inputView.inputWinningLotto();
        assertEquals(List.of(1, 2, 3, 4, 5, 6), winningLotto.getNumbers());
    }

    @Test
    void 보너스_번호를_입력받아야_한다() {
        String input = "7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertEquals(7, inputView.inputBonusNumber());
    }
}
