package lotto.ui;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest extends NsTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @Test
    void 숫자_입력_테스트() {
        run("1000");
        String result = inputView.userInput();
        assertEquals("1000", result);
    }

    @Test
    void 숫자_아닌_입력_예외_발생() {
        run("abc");
        assertThrows(IllegalArgumentException.class, () -> inputView.userInput());
    }

    @Override
    protected void runMain() {

    }
}