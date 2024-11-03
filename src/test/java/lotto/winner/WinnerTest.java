package lotto.winner;

import java.io.ByteArrayInputStream;
import java.util.List;
import lotto.io.input.Input;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerTest {

    @Test
    @DisplayName("당첨번호 발행")
    void issueWinningNumbers() {
        // given
        ByteArrayInputStream in = new ByteArrayInputStream("1,4,5,2,6,3".getBytes());
        System.setIn(in);

        List<Integer> winningNumbersInput = Input.getWinningNumbersInput();

        // when
        Winner winner = new Winner(winningNumbersInput, 1);

        // then
        Assertions.assertEquals(winner.getWinningNumbers(), List.of(1, 2, 3, 4, 5, 6));
    }
}