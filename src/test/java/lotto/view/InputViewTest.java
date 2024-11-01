package lotto.view;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


class InputViewTest {

    @DisplayName("올바른 숫자를 입력할 시 정상 동작한다.")
    @Test
    void 올바른_숫자를_입력할_시_정상_동작한다() {
        String input = "1000\n";
        setInput(input);

        int money = InputView.readMoney();
        assertEquals(money, 1000);
    }

    @DisplayName("숫자가 아니거나 0보다 작다면 예외가 발생한다.")
    @Test
    void 숫자가_아니거나_0보다_작다면_예외가_발생한다() {
        String input = "-500\naaa\n1000\n";
        setInput(input);

        int money = InputView.readMoney();
        assertEquals(money, 1000);
    }
    private void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}