package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    private final InputView inputView = new InputView();

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닐 경우 예외발생")
    void 구입_금액이_1000원_단위가_아닐_경우() {
        setInput("1500");
        assertThrows(IllegalArgumentException.class, inputView::purchaseLotto);
    }

    @Test
    @DisplayName("구입 금액이 1000원 미만인 경우 예외발생")
    void 구입_금액이_1000원_미만인_경우() {
        setInput("777");
        assertThrows(IllegalArgumentException.class, inputView::purchaseLotto);
    }

    @Test
    @DisplayName("구입 금액이 정상적인 경우")
    void 구입_금액이_정상적인_경우() {
        setInput("4000");
        assertEquals(4000, inputView.purchaseLotto());
    }

}