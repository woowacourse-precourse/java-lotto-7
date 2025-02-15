package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ExceptionMessage;
import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

class InputTest {
    private ByteArrayOutputStream output;

    @BeforeEach
    void setUp() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void clearInputBuffer() {
        Console.close();
    }
    @Test
    @DisplayName("구매 금액 정상 입력")
    void readPurchasePrice_정상() {
        // given
        System.setIn(new ByteArrayInputStream("8000\n".getBytes()));

        // when
        int price = InputView.readPurchasePrice();

        // then
        Assertions.assertThat(price).isEqualTo(8000);
    }

    @Test
    @DisplayName("구매 금액이 1000원 단위가 아닐 경우")
    void readPurchasePrice_1000원단위_아님() {
        // given
        System.setIn(new ByteArrayInputStream("8500\n".getBytes()));

        // when, then
        Assertions.assertThatThrownBy(() -> InputView.readPurchasePrice())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_PURCHASE_AMOUNT_ERROR);
    }

    @Test
    @DisplayName("구매 금액에 숫자가 아닌 값 입력")
    void readPurchasePrice_숫자_아님() {
        // given
        System.setIn(new ByteArrayInputStream("abc\n".getBytes()));

        // when, then
        Assertions.assertThatThrownBy(() -> InputView.readPurchasePrice())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.MAX_AMOUNT_ERROR);
    }

    @Test
    @DisplayName("당첨 번호 정상 입력")
    void readWinningNumbers_정상() {
        // given
        System.setIn(new ByteArrayInputStream("1,2,3,4,5,6\n".getBytes()));

        // when
        List<Integer> numbers = InputView.readWinningNumbers();

        // then
        Assertions.assertThat(numbers)
                .hasSize(6)
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("당첨 번호 형식이 잘못된 경우")
    void readWinningNumbers_형식_오류() {
        // given
        System.setIn(new ByteArrayInputStream("1,2,3,4,5\n".getBytes()));

        // when, then
        Assertions.assertThatThrownBy(() -> InputView.readWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_LOTTO_NUMBERS_FORMAT_ERROR);
    }

    @Test
    @DisplayName("당첨 번호에 숫자가 아닌 값 입력")
    void readWinningNumbers_숫자_아님() {
        // given
        System.setIn(new ByteArrayInputStream("1,2,3,4,5,a\n".getBytes()));

        // when, then
        Assertions.assertThatThrownBy(() -> InputView.readWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_LOTTO_NUMBERS_FORMAT_ERROR);
    }

    @Test
    @DisplayName("보너스 번호 정상 입력")
    void readBonusNumber_정상() {
        // given
        System.setIn(new ByteArrayInputStream("7\n".getBytes()));

        // when
        int bonusNumber = InputView.readBonusNumber();

        // then
        Assertions.assertThat(bonusNumber).isEqualTo(7);
    }

    @Test
    @DisplayName("보너스 번호에 숫자가 아닌 값 입력")
    void readBonusNumber_숫자_아님() {
        // given
        System.setIn(new ByteArrayInputStream("a\n".getBytes()));

        // when, then
        Assertions.assertThatThrownBy(() -> InputView.readBonusNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }




}