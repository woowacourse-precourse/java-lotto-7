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
import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("모든 번호가 일치하면 1등이다.")
    @Test
    void 모든_번호가_일치하면_1등이다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int rank = lotto.draw(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(rank).isEqualTo(1);
    }

    @DisplayName("5개의 번호가 일치하고 보너스 번호까지 일치하면 2등이다.")
    @Test
    void 다섯개의_번호가_일치하고_보너스_번호까지_일치하면_2등이다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int rank = lotto.draw(List.of(1, 2, 3, 4, 5, 11), 6);
        assertThat(rank).isEqualTo(2);
    }

    @DisplayName("5개의 번호가 일치하고, 보너스 번호가 다르면 3등이다.")
    @Test
    void 다섯개의_번호가_일치하고_보너스_번호가_다르면_3등이다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int rank = lotto.draw(List.of(1, 2, 3, 4, 5, 11), 12);
        assertThat(rank).isEqualTo(3);
    }

    @DisplayName("4개의 번호가 일치하면 4등이다.")
    @Test
    void 네개의_번호가_일치하면_4등이다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int rank = lotto.draw(List.of(1, 2, 3, 4, 10, 11), 12);
        assertThat(rank).isEqualTo(4);
    }

    @DisplayName("3개의 번호가 일치하면 5등이다.")
    @Test
    void 세개의_번호가_일치하면_5등이다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int rank = lotto.draw(List.of(1, 2, 3, 11, 12, 13), 14);
        assertThat(rank).isEqualTo(5);
    }
}
