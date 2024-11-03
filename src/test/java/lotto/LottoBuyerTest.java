package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.dto.LottoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoBuyerTest {
    private LottoBuyer lottoBuyer;
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    @BeforeEach
    void beforeEach(){
        lottoBuyer = new LottoBuyer();
    }
    @Test
    void 로또_당첨_번호_입력_테스트() {
        // given
        String input = "1,2,3,4,5,6\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        LottoDto winningNumbers = lottoBuyer.drawWinningNumbers();

        // then
        assertEquals(List.of(1, 2, 3, 4, 5, 6), winningNumbers.getNumbers());
    }
}
