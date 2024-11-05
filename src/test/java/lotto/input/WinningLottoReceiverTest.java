package lotto.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.parser.Parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;

class WinningLottoReceiverTest {

    @Test
    @DisplayName("성공 - 유효한 당첨 번호 입력")
    void success_receiveWinningLotto() {
        // given
        InputProvider mockInputProvider = () -> "1,2,3,4,5,6";
        Parser mockParser = input -> input.split(",");
        Receiver<WinningLotto> winningLottoReceiver = new WinningLottoReceiver(mockInputProvider, mockParser);

        // when
        WinningLotto winningLotto = winningLottoReceiver.receiveWithMessage();

        // then
        Lotto expectedLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.getWinningNumber().getNumbers()).isEqualTo(expectedLotto.getNumbers());
    }

    @Test
    @DisplayName("실패 - 빈 입력")
    void fail_receiveWinningLotto_emptyInput() {
        // given
        InputProvider mockInputProvider = () -> "";
        Parser mockParser = input -> input.split(",");
        Receiver<WinningLotto> winningLottoReceiver = new WinningLottoReceiver(mockInputProvider, mockParser);

        // when & then
        assertThatThrownBy(() -> winningLottoReceiver.receiveWithMessage())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 빈 입력은 불가능합니다.");
    }

    @Test
    @DisplayName("실패 - 번호가 6개 미만")
    void fail_receiveWinningLotto_lessThanSixNumbers() {
        // given
        InputProvider mockInputProvider = () -> "1,2,3,4,5";
        Parser mockParser = input -> input.split(",");
        Receiver<WinningLotto> winningLottoReceiver = new WinningLottoReceiver(mockInputProvider, mockParser);

        // when & then
        assertThatThrownBy(() -> winningLottoReceiver.receiveWithMessage())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 번호는 정확히 6개여야 합니다.");
    }

    @Test
    @DisplayName("실패 - 중복된 번호 포함")
    void fail_receiveWinningLotto_withDuplicateNumbers() {
        // given
        InputProvider mockInputProvider = () -> "1,2,3,3,5,6";
        Parser mockParser = input -> input.split(",");
        Receiver<WinningLotto> winningLottoReceiver = new WinningLottoReceiver(mockInputProvider, mockParser);

        // when & then
        assertThatThrownBy(() -> winningLottoReceiver.receiveWithMessage())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 번호에 중복된 숫자가 포함되어 있습니다.");
    }

    @Test
    @DisplayName("실패 - 범위를 벗어난 번호 포함")
    void fail_receiveWinningLotto_withOutOfRangeNumbers() {
        // given
        InputProvider mockInputProvider = () -> "1,2,3,4,5,46";
        Parser mockParser = input -> input.split(",");
        Receiver<WinningLotto> winningLottoReceiver = new WinningLottoReceiver(mockInputProvider, mockParser);

        // when & then
        assertThatThrownBy(() -> winningLottoReceiver.receiveWithMessage())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 번호는 1 이상 45 이하의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("실패 - 숫자가 아닌 입력 포함")
    void fail_receiveWinningLotto_withNonNumericInput() {
        // given
        InputProvider mockInputProvider = () -> "1,2,3,4,5,abc";
        Parser mockParser = input -> input.split(",");
        Receiver<WinningLotto> winningLottoReceiver = new WinningLottoReceiver(mockInputProvider, mockParser);

        // when & then
        assertThatThrownBy(() -> winningLottoReceiver.receiveWithMessage())
            .isInstanceOf(IllegalArgumentException.class);
    }
}
