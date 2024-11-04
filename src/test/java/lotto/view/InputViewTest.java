package lotto.view;

import lotto.model.Lotto;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


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

    @DisplayName("잘못된 당첨 번호를 입력하면 예외가 발생한다.")
    @Test
    void 잘못된_당첨_번호를_입력하면_예외가_발생한다() {
        String input = "1,2,3,4,5,a\n1,2,3,4,5,6";
        setInput(input);
        Lotto expect = new Lotto(List.of(1,2,3,4,5,6));

        Lotto winningNumbers = InputView.readWinningNumbers();

        assertEquals(winningNumbers.getNumbers(), expect.getNumbers());
    }

    @DisplayName("숫자가 아니면 예외가 발생한다")
    @Test
    void 숫자가_아니라면_예외가_발생한다() {
        String input = "a\naaa\n10\n";
        setInput(input);
        Lotto winningNumbers = new Lotto(List.of(1,2,3,4,5,6));
        int number = InputView.readBonusNumber(winningNumbers);
        assertEquals(number, 10);
    }

    private void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}