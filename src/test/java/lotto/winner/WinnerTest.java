package lotto.winner;

import java.io.ByteArrayInputStream;
import java.util.List;
import lotto.io.input.Input;
import lotto.lotto.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerTest {

    @AfterEach
    void close() {
        Input.close();
    }

    @Test
    @DisplayName("당첨번호 발행")
    void issueWinningNumbers() {
        // given
        ByteArrayInputStream in = new ByteArrayInputStream("1,4,5,2,6,3".getBytes());
        System.setIn(in);

        List<Integer> winningNumbersInput = Input.getWinningNumbersInput();

        // when
        Winner winner = new Winner(new Lotto(winningNumbersInput), 1);

        // then
        Assertions.assertEquals(winner.getWinningNumbers(), List.of(1, 2, 3, 4, 5, 6));
    }
}