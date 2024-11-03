package lotto.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineServiceTest {
    private final LottoMachineService lottoMachineService = new LottoMachineService();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream captor;

    @BeforeEach
    void setUp() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void setAfter() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void 삼천원_구매_테스트() {
        String simulatedInput = "3000\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        lottoMachineService.purchaseLotto();
        String output = captor.toString().trim();

        assertThat(output).contains("3개를 구매했습니다.");

        Pattern lottoPattern = Pattern.compile("\\[(1|[1-9]|[1-3][0-9]|4[0-5]), (1|[1-9]|[1-3][0-9]|4[0-5]), (1|[1-9]|[1-3][0-9]|4[0-5]), (1|[1-9]|[1-3][0-9]|4[0-5]), (1|[1-9]|[1-3][0-9]|4[0-5]), (1|[1-9]|[1-3][0-9]|4[0-5])]");

        long matchCount = output.lines()
                .filter(line -> lottoPattern.matcher(line).matches())
                .count();

        assertThat(matchCount).isEqualTo(3);
    }
}
