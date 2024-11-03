package domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import domain.consumer.Consumer;
import domain.error.ErrorMessage;
import domain.error.InputErrorMessage;
import domain.error.LottoErrorMessage;
import io.InputMessage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachinTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream output;
    private Consumer consumer;
    private LottoMachin machine;

    @BeforeEach
    void setUp() {
        consumer = new Consumer();
        machine = new LottoMachin();
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
        output.reset();
        Console.close();
    }

    @DisplayName("로또 머신이 판매한 로또의 갯수와 실제 구매자가 받은 로또의 개수 비교 테스트")
    @Test
    void sellToTest() {
        String input = "5000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        machine.sellTo(consumer);
        assertEquals(5, consumer.getPurchasedLottoCount());
    }

    @DisplayName("로또 머신이 제공한 구매자의 로또 번호 검증 테스트.")
    @Test
    void printLottosTest() {
        consumer.receiveLottoTicket(
                List.of(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
                )
        );
        String expectedOutput = "[1, 2, 3, 4, 5, 6]\r\n[7, 8, 9, 10, 11, 12]\r\n";

        consumer.printPurchasedLottos();
        assertEquals(expectedOutput, output.toString());
    }

    @DisplayName("로또 머신이 구매자의 로또 번호의 정보를 출력하는 메서드 테스트")
    @Test
    void printLottoInfoTest() {
        consumer.receiveLottoTicket(
                List.of(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
                )
        );
        String expectedOutput = "\r\n2개를 구매했습니다.\r\n[1, 2, 3, 4, 5, 6]\r\n[7, 8, 9, 10, 11, 12]\r\n";

        machine.printLottoInfo(consumer);

        assertEquals(expectedOutput, output.toString());
    }

    @DisplayName("로또 머신이 구매자에게 당첨 번호를 입력받는 메서드 성공 테스트")
    @Test
    void inputWinningNumbersToConsumerSuccessTest() {
        String input = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<Integer> inputNumbers = new ArrayList<>();
        for (String number : input.split(InputMessage.DELIMITER.getInputMessage())) {
            inputNumbers.add(Integer.parseInt(number));
        }
        Lotto expected = new Lotto(inputNumbers);

        machine.inputWinningNumbersTo(consumer);
        boolean result = consumer.selectedWinnerNumberIsEqualsTo(expected);
        assertTrue(result);
    }

    @DisplayName("로또 머신이 구매자에게 당첨 번호를 입력받는 메서드 공백 실패 테스트")
    @Test
    void inputWinningNumbersToConsumerFailBlankTest() {
        String input = " ";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(() -> machine.inputWinningNumbersTo(consumer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_MESSAGE.getErrorMessage());
    }

    @DisplayName("로또 머신이 구매자에게 당첨 번호를 입력받는 메서드 숫자 개수 부족 실패 테스트")
    @Test
    void inputWinningNumbersToConsumerFailCountTest() {
        String input = "1,2,3,4,5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(() -> machine.inputWinningNumbersTo(consumer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.LOTTO_NUMBER_COUNT.getErrorMessage());
    }

    @DisplayName("로또 머신이 구매자에게 보너스 번호를 입력받는 숫자 성공 테스트")
    @Test
    void inputBonusNumberToConsumerSuccessTest() {
        String input = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        machine.inputWinningNumbersTo(consumer);

        Console.close();

        input = "7";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        machine.inputBonusNumbersTo(consumer);

        assertTrue(consumer.selectedBonusNumberIsEqualsTo(Integer.parseInt(input)));
    }

    @DisplayName("로또 머신이 구매자에게 보너스 번호를 입력받는 숫자 공백 테스트")
    @Test
    void inputBonusNumberToConsumerFailBlankTest() {
        String input = " ";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(() -> machine.inputBonusNumbersTo(consumer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_MESSAGE.getErrorMessage());
    }

    @DisplayName("로또 머신이 구매자에게 보너스 번호를 입력받는 숫자 음수 테스트")
    @Test
    void inputBonusNumberToConsumerFailNegativeTest() {
        String input = "-1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(() -> machine.inputBonusNumbersTo(consumer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputErrorMessage.WINNING_NUMBER_VALIDATION.getErrorMessage());
    }

    @DisplayName("로또 머신이 구매자에게 보너스 번호를 입력받는 숫자와 당첨번호 중복 테스트")
    @Test
    void inputBonusNumberToConsumerFailDuplicateWithinWinningNumberTest() {
        String input = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        machine.inputWinningNumbersTo(consumer);

        Console.close();

        input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(() -> machine.inputBonusNumbersTo(consumer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputErrorMessage.BONUS_NUMBER_NOT_IN_WINNING_NUMBERS.getErrorMessage());
    }
}