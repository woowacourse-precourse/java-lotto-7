package lotto.io.input;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest {

    @Test
    @DisplayName("당첨 번호를 입력 할 시 ,를 기준으로 구분")
    void getWinningNumbersInput() {
        // given
        ByteArrayInputStream in = new ByteArrayInputStream("1,2,3,4,5,6".getBytes());
        System.setIn(in);

        // when
        List<Integer> winningNumbers = Input.getWinningNumbersInput();

        // then
        Assertions.assertEquals(winningNumbers, List.of(1, 2, 3, 4, 5, 6));
    }
}