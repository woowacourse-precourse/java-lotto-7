package lotto.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {
    private ByteArrayOutputStream outputStream;
    private TestInputView inputView;
    private OutputView outputView;
    private LottoController controller;

    static class TestInputView extends InputView {
        private final List<String> inputs;
        private int index = 0;

        TestInputView(String... inputs) {
            this.inputs = Arrays.asList(inputs);
        }

        @Override
        public String readLine() {
            return inputs.get(index++);
        }
    }

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        outputView = new OutputView();
    }

    private String getOutput() {
        return outputStream.toString();
    }

    @Test
    @DisplayName("5000원으로 로또 구매 시 5개의 로또를 발급한다")
    void purchaseLottoWithValidAmount() {
        inputView = new TestInputView("5000", "1,2,3,4,5,6", "7");
        controller = new LottoController(inputView, outputView);

        controller.run();
        String output = getOutput();

        assertTrue(output.contains("5개를 구매했습니다."),
            "5개의 로또가 발급되어야 합니다");

        String[] lines = output.split(System.lineSeparator());
        int lottoCount = 1;
        for (String line : lines) {
            if (line.matches("\\[\\d+(,\\s\\d+){5}\\]")) {
                lottoCount++;
            }
        }
        assertEquals(5, lottoCount, "5개의 로또 번호가 출력되어야 합니다");
    }

    @Test
    @DisplayName("1000원으로 나누어떨어지지 않는 금액 입력 시 에러가 발생하고 재입력을 받는다")
    void purchaseLottoWithInvalidAmount() {
        inputView = new TestInputView("1500", "3000", "1,2,3,4,5,6", "7");
        controller = new LottoController(inputView, outputView);

        controller.run();
        String output = getOutput();

        assertTrue(output.contains("[ERROR] 1000원 단위로 구입 금액을 입력해주세요."),
            "1000원 단위 오류 메시지가 포함되어야 합니다");
        assertTrue(output.contains("3개를 구매했습니다."),
            "올바른 금액 입력 후 로또가 발급되어야 합니다");
    }

    @Test
    @DisplayName("숫자가 아닌 입력 시 에러가 발생하고 재입력을 받는다")
    void purchaseLottoWithNonNumericInput() {
        inputView = new TestInputView("abc", "3000", "1,2,3,4,5,6", "7");
        controller = new LottoController(inputView, outputView);

        controller.run();
        String output = getOutput();

        assertTrue(output.contains("[ERROR] 입력값은 정수만 가능합니다."),
            "숫자 형식 오류 메시지가 포함되어야 합니다");
        assertTrue(output.contains("3개를 구매했습니다."),
            "올바른 금액 입력 후 로또가 발급되어야 합니다");
    }

    @Test
    @DisplayName("0원 이하의 금액 입력 시 에러가 발생하고 재입력을 받는다")
    void purchaseLottoWithZeroOrNegativeAmount() {
        inputView = new TestInputView("0", "3000", "1,2,3,4,5,6", "7");
        controller = new LottoController(inputView, outputView);

        controller.run();
        String output = getOutput();

        assertTrue(output.contains("정수") || output.contains("양의"),
            "0원 이하 금액 오류 메시지가 포함되어야 합니다");
        assertTrue(output.contains("3개를 구매했습니다."),
            "올바른 금액 입력 후 로또가 발급되어야 합니다");
    }

    @Test
    @DisplayName("중복된 당첨 번호 입력시 에러가 발생하고 재입력을 받는다")
    void winningLottoNumberDuplicate() {
        inputView = new TestInputView("3000", "1,2,3,4,5,5", "1,2,3,4,5,6", "7");
        controller = new LottoController(inputView, outputView);

        controller.run();
        String output = getOutput();

        assertTrue(output.contains("3개를 구매했습니다."));
        assertTrue(output.contains("당첨 번호"));
        assertTrue(output.contains("보너스 번호"));
        assertTrue(output.contains("중복"),
            "중복된 당첨 번호는 입력될 수 없습니다.");
        assertTrue(output.contains("당첨 번호"));
    }

    @Test
    @DisplayName("당첨 번호와 중복된 보너스 번호 입력시 에러가 발생하고 재입력을 받는다")
    void winningLottoBonusNumberDuplicate() {
        inputView = new TestInputView("3000", "1,2,3,4,5,6", "6", "7");
        controller = new LottoController(inputView, outputView);

        controller.run();
        String output = getOutput();

        assertTrue(output.contains("3개를 구매했습니다."));
        assertTrue(output.contains("당첨 번호"));
        assertTrue(output.contains("보너스 번호"));
        assertTrue(output.contains("중복"),
            "중복된 당첨 번호는 입력될 수 없습니다.");
        assertTrue(output.contains("보너스 번호"));
    }
}