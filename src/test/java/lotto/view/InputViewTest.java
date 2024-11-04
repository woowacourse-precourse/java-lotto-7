package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class InputViewTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private static final String BLANK = " ";
    private final InputView inputView = new InputView();

    @Test
    void getMoney() {
        run(BLANK);

        assertThatThrownBy(inputView::getMoney)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void getWinningNumbers() {
        run(BLANK);

        assertThatThrownBy(inputView::getWinningNumbers)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void getBonusNumber() {
        run(BLANK);

        assertThatThrownBy(inputView::getBonusNumber)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @Override
    protected void runMain() {
    }
}