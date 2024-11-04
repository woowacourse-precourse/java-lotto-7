package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoMachineTest {

    private final ByteArrayOutputStream outPutStreamCaptor = new ByteArrayOutputStream();
    LottoMachine lottoMachine;

    @BeforeEach
    public void setUP() {
        System.setOut(new PrintStream(outPutStreamCaptor));
        lottoMachine = new LottoMachine();
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void 당첨번호가_숫자6개라면_당첨번호를_저장한다(String candidate) {
        InputStream in = new ByteArrayInputStream(candidate.getBytes());
        System.setIn(in);
        lottoMachine.inputWinningNumbers();
        assertThat(lottoMachine.getWinningNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

}
