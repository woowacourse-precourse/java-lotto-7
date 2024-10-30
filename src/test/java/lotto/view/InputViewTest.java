package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    private final InputView inputView = new InputView();
    private static final String INT_ERROR = "숫자가";
    private static final String EMPTY_ERROR = "비어있습니다";

    // Console.readLine()의 Scanner는 static이어서 close 해줘야 각 테스트 정상 작동
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void 구입_금액_숫자입력_성공() {
        setInput("1000");
        int actual = inputView.readPurchasePrice();
        int expect = 1000;
        assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", " 1000 "})
    void 구입_금액_int로_변환_실패_문자(String input) {
        setInput(input);
        assertThatThrownBy(inputView::readPurchasePrice)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INT_ERROR);
    }

    @ParameterizedTest
    @ValueSource(bytes = {' ', '\n'})
    void 구입_금액_blank_실패(byte input) {
        setByte(input);
        assertThatThrownBy(inputView::readPurchasePrice)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY_ERROR);
    }

    @Test
    void 구입_금액_소수점_실패() {
        setInput("1000.4");
        assertThatThrownBy(inputView::readPurchasePrice)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INT_ERROR);
    }

    @ParameterizedTest
    @ValueSource(bytes = {' ', '\n'})
    void 당첨_번호_빈값_실패(byte input) {
        setByte(input);
        assertThatThrownBy(inputView::readWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY_ERROR);
    }

    @ParameterizedTest
    @ValueSource(bytes = {' ', '\n'})
    void 보너스_숫자_빈값_실패_(byte input) {
        setByte(input);
        assertThatThrownBy(inputView::readBonusNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY_ERROR);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", " 1000 "})
    void 보너스_숫자_int로_변환_실패_문자(String input) {
        setInput(input);
        assertThatThrownBy(inputView::readBonusNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INT_ERROR);
    }

    private void setInput(final String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    private void setByte(final byte input) {
        System.setIn(new ByteArrayInputStream(new byte[]{input}));
    }

}
