package lotto;

import lotto.error.ErrorStatus;
import lotto.service.Lotto;
import lotto.service.LottoTickets;
import lotto.utils.StringParser;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private static Stream<String> invalidInput() {
        return Stream.of(null, "");
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 null이거나 빈 문자열일 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("invalidInput")
    void 입력값이_NULL이거나_빈_문자열이면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> InputView.getValidMoney(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorStatus.NULL_OR_EMPTY_INPUT.getMessage());
    }

    @DisplayName("로또 번호가 음수이면 예외가 발생한다.")
    @Test
    void 로또번호가_음수이면_예외가_발생한다() {
        String winningNumbers = "1,2,3,4,5,-6";
        assertThatThrownBy(() -> StringParser.parseStringToIntegerList(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorStatus.INVALID_NEGATIVE_NUMBER.getMessage());
    }

    @DisplayName("로또 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 로또_금액이_1000원_단위가_아니면_예외가_발생한다() {
        LottoTickets lottoTickets = new LottoTickets();
        int money = 1500;
        assertThatThrownBy(() -> lottoTickets.buyTicket(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorStatus.INVALID_MONEY_AMOUNT.getMessage());
    }

    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorStatus.INVALID_NUMBER_SIZE.getMessage());
    }
}
