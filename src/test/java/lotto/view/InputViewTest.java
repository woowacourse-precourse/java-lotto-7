package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.entity.WinningNumbers;
import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
        Console.close();
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    @DisplayName("유효한 로또 구매 금액 입력 시 정상적으로 처리")
    void createWinningNumbersWithValidPurchaseAmount() {
        setInput("5000\n");
        int purchaseAmount = InputView.getPurchaseAmount();
        assertEquals(5000, purchaseAmount);
    }

    @Test
    @DisplayName("잘못된 로또 구매 금액 입력 시 예외 메시지 출력")
    void displayErrorMessageWhenPurchaseAmountIsInvalid() {
        setInput("300\n1000\n");
        InputView.getPurchaseAmount();
        String output = outputStreamCaptor.toString().trim();

        String[] messages = output.split("\n");
        String lastMessage = messages[messages.length - 2];
        assertEquals(ErrorMessage.INVALID_AMOUNT.getMessage(), lastMessage);
    }

    @Test
    @DisplayName("유효한 당첨 번호 입력 시 WinningNumbers 생성")
    void createWinningNumbersWithValidMainAndBonusNumbers() {
        setInput("1,2,3,4,5,6\n7\n");

        WinningNumbers winningNumbers = InputView.getWinningNumbers();
        List<Integer> expectedMainNumbers = List.of(1, 2, 3, 4, 5, 6);
        int expectedBonusNumber = 7;

        assertEquals(expectedMainNumbers, winningNumbers.getMainNumbers());
        assertEquals(expectedBonusNumber, winningNumbers.getBonusNumber());
    }

    @Test
    @DisplayName("메인 숫자가 6개가 아닐 때 예외 메시지 출력")
    void displayErrorMessageWhenMainNumbersCountIsInvalid() {
        setInput("1,2,3,4,5\n1,2,3,4,5,6\n7\n");

        InputView.getWinningNumbers();
        String output = outputStreamCaptor.toString().trim();

        String[] messages = output.split("\n");
        String lastMessage = messages[messages.length - 4];
        assertEquals(ErrorMessage.INVALID_WINNING_NUMBERS_COUNT.getMessage(), lastMessage);
    }

    @Test
    @DisplayName("메인 숫자에 중복된 값이 있을 때 예외 메시지 출력")
    void displayErrorMessageWhenMainNumbersHaveDuplicates() {
        List<Integer> mainNumbers = List.of(1, 2, 3, 3, 4, 5);
        int bonusNumber = 7;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new WinningNumbers(mainNumbers, bonusNumber));
        assertEquals(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("메인 숫자가 범위를 벗어날 때 예외 메시지 출력")
    void displayErrorMessageWhenMainNumbersOutOfRange() {
        List<Integer> mainNumbers = List.of(1, 2, 3, 4, 5, 50);
        int bonusNumber = 7;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new WinningNumbers(mainNumbers, bonusNumber));
        assertEquals(ErrorMessage.INVALID_WINNING_NUMBERS_RANGE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 메인 숫자에 포함될 때 예외 메시지 출력")
    void displayErrorMessageWhenBonusNumberIsInMainNumbers() {
        List<Integer> mainNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 3;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new WinningNumbers(mainNumbers, bonusNumber));
        assertEquals(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage(), exception.getMessage());
    }
}
