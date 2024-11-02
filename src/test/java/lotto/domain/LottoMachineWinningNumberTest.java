package lotto.domain;

import static lotto.config.ErrorMessageConstant.DUPLICATED_WINNING_NUMBER_MESSAGE;
import static lotto.config.ErrorMessageConstant.INSUFFICIENT_WINNING_NUMBERS_MESSAGE;
import static lotto.config.ErrorMessageConstant.INVALID_RANGE_NUMBER_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoMachineWinningNumberTest {
    LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    void 당첨번호_설정() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);

        assertDoesNotThrow(() ->
                lottoMachine.assignWinningNumbers(winningNumber)
        );
    }

    @Test
    void 부족한_당첨번호_입력() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> lottoMachine.assignWinningNumbers(winningNumber))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(INSUFFICIENT_WINNING_NUMBERS_MESSAGE);
    }

    @Test
    void 중복된_당첨숫자_입력() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> lottoMachine.assignWinningNumbers(winningNumber))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_WINNING_NUMBER_MESSAGE);
    }

    @Test
    void 허용범위_외_숫자_입력() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 46);
        assertThatThrownBy(() -> lottoMachine.assignWinningNumbers(winningNumber))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANGE_NUMBER_MESSAGE);
    }
}