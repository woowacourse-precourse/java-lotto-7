package lotto.view;

import lotto.domain.CorrectDTO;
import lotto.domain.Lotto;
import lotto.domain.LottoDTO;
import lotto.domain.MoneyDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LottoViewTest {

    private final LottoView lottoView = new LottoView();
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor)); // System.out 출력을 캡처
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
        outputStreamCaptor.reset();
    }


    @Test
    public void testParseAndValidateInputWithEmptyString() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            lottoView.validateInput("");
        });
        assertEquals("[ERROR] 잘못된 입력입니다. 빈 문자인지 확인해주세요.", exception.getMessage());
    }

    @Test
    public void testParseAndValidateInputWithNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            lottoView.validateInput(null);
        });
        assertEquals("[ERROR] 잘못된 입력입니다. 빈 문자인지 확인해주세요.", exception.getMessage());
    }

    @Test
    public void testParseAndValidateInputWithNonNumericString() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            lottoView.parseInput("abc");
        });
        assertEquals("[ERROR] 숫자를 입력해 주세요.", exception.getMessage());
    }

    @Test
    public void testParseAndValidateInputWithValidNumber() {
        int result = lottoView.parseInput("1000");
        assertEquals(1000, result);
    }

    @Test
    public void testGetMoneyInputWithValidInput() {
        // readLine이 "1000"을 읽도록 설정
        String simulatedInput = "1000\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        MoneyDTO moneyDTO = lottoView.getMoneyInput();
        assertEquals(1000, moneyDTO.getMoney());
    }

    @Test
    public void testPrintLotto() {

        Lotto lotto1 = new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38));


        LottoDTO lottoDTO = new LottoDTO(Arrays.asList(lotto1, lotto2));

        lottoView.printLottos(lottoDTO);

        // 예상 출력값
        String expectedOutput = "[8, 21, 23, 41, 42, 43]\n[3, 5, 11, 16, 32, 38]\n";

        // 출력값 검증
        assertEquals(expectedOutput,  outputStreamCaptor.toString());
    }

    @Test
    public void 제대로된_값_입력() {
        String validInput = "8, 21, 23, 41, 42, 43\n";

        CorrectDTO correctDTO = lottoView.validateAndParseLottoInput(validInput);

        Lotto expectedLotto = new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43));
        CorrectDTO expectedCorrectDTO = new CorrectDTO(expectedLotto);

        //안에 들어 있는 값이 같은지 판단
        assertEquals(expectedCorrectDTO.getCorrects().getLotto().toString(), correctDTO.getCorrects().getLotto().toString());
    }

    @Test
    public void 음수_입력된_경우(){
        String invalidInput = "8, 21, -2, 41, 42, 43\n";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
                lottoView.validateAndParseLottoInput(invalidInput);
        });
        assertEquals("[ERROR] 로또 번호에는 음수 값이 포함되어서는 안됩니다.", exception.getMessage());
    }

    @Test
    public void 잘못된_값이_입력된_경우() {
        String invalidInput = "8, 21, absdf, 41, 42, 43";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            lottoView.validateAndParseLottoInput(invalidInput);
        });
        assertEquals("[ERROR] 숫자를 입력해 주세요.", exception.getMessage());
    }



}

