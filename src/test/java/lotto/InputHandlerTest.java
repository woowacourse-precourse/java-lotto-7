package lotto;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static lotto.IO.InputHandler.getWinningLottoNumber;
import static org.assertj.core.api.Assertions.assertThat;

class InputHandlerTest {

    @Test
    void 로또_당첨번호를_입력받는_테스트() {
        String input = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<Integer> winningNumbers = getWinningLottoNumber(); // 메서드 호출

        assertThat(winningNumbers).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}