package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.exception.InvalidInputException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("ConsoleInputView 테스트")
public class ConsoleInputViewTest {

    private static final String PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    private static final ConsoleInputView consoleInputView = new ConsoleInputView();

    private static final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void restoreSystemInputOutput() {
        System.setOut(System.out);
        System.setIn(System.in);
        Console.close();
    }

    @ParameterizedTest(name = "input : {0}")
    @ValueSource(strings = {"1000", "2000", "3000", "2947"})
    void 로또_구매_금액을_정수로_입력받는다(String input) {

        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        int actual = consoleInputView.inputPurchaseMoney();

        // then
        assertThat(outputStreamCaptor.toString()).contains(PURCHASE_MONEY_MESSAGE);
        assertThat(actual).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest(name = "input : {0}")
    @ValueSource(strings = {"1000l", "2000,", "3000^", "2n947"})
    void 로또_구매_입력_시_정수로_입력하지_않으면_예외가_발생한다(String intput) {

        // given
        System.setIn(new ByteArrayInputStream(intput.getBytes()));

        // when & then
        assertThatThrownBy(consoleInputView::inputPurchaseMoney)
                .isInstanceOf(InvalidInputException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "input : {0}")
    @ValueSource(strings = {"1,2,3,4,5,6", "3,5,7,9,11,13", "10,20,30,40,50,60"})
    void 당첨_로또_번호를_쉼표를_기준으로_입력받아_리스트로_반환한다(String input) {

        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<Integer> expected = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();

        // when
        List<Integer> actual = consoleInputView.inputWinningNumbers();

        // then
        assertThat(outputStreamCaptor.toString()).contains(WINNING_NUMBER_MESSAGE);
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @ParameterizedTest(name = "input : {0}")
    @ValueSource(strings = {"1000l", "2000,d", "3000^", "2n947"})
    void 당첨_로또_번호_입력_시_정수로_입력하지_않으면_예외가_발생한다(String intput) {

        // given
        System.setIn(new ByteArrayInputStream(intput.getBytes()));

        // when & then
        assertThatThrownBy(consoleInputView::inputWinningNumbers)
                .isInstanceOf(InvalidInputException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "input : {0}")
    @ValueSource(strings = {"1", "3", "5", "23", "57", "888"})
    void 보너스_번호를_정수로_입력받는다(String input) {

        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        int actual = consoleInputView.inputBonusNumber();

        // then
        assertThat(outputStreamCaptor.toString()).contains(BONUS_NUMBER_MESSAGE);
        assertThat(actual).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest(name = "input : {0}")
    @ValueSource(strings = {"1000l", "2000,", "3000^", "2n947"})
    void 보너스_번호_입력_시_정수로_입력하지_않으면_예외가_발생한다(String intput) {

        // given
        System.setIn(new ByteArrayInputStream(intput.getBytes()));

        // when & then
        assertThatThrownBy(consoleInputView::inputBonusNumber)
                .isInstanceOf(InvalidInputException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
