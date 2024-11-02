package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import lotto.domain.RandomLottoResult;
import lotto.dto.Lotto;
import org.junit.jupiter.api.Test;

public class RandomLottoResultTest {
    @Test
    void 결과_출력_테스트() {
        // given
        Lotto lotto1 = new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44));

        RandomLottoResult randomLottoResult = new RandomLottoResult();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // when
        randomLottoResult.printResult(Arrays.asList(lotto1, lotto2, lotto3));

        // then
        String expectedOutput = "[8, 21, 23, 41, 42, 43]\r\n" +
                "[3, 5, 11, 16, 32, 38]\r\n" +
                "[7, 11, 16, 35, 36, 44]\r\n";
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }
}
