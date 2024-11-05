package lotto.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberReceiverTest {

    @Test
    @DisplayName("BonusNumberReceiver 성공 - 유효한 보너스 번호 입력")
    void success_receiveBonusNumber() {
        // given
        InputProvider mockInputProvider = () -> "7";
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Receiver<BonusNumber> bonusNumberReceiver = new BonusNumberReceiver(mockInputProvider, winningNumbers);

        // when
        BonusNumber bonusNumber = bonusNumberReceiver.receiveWithMessage();

        // then
        assertThat(bonusNumber.number()).isEqualTo(7);
    }

    @Test
    @DisplayName("BonusNumberReceiver 실패 - 보너스 번호가 당첨 번호와 중복")
    void fail_receiveBonusNumber_duplicateWithWinningNumbers() {
        // given
        InputProvider mockInputProvider = () -> "3";
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Receiver<BonusNumber> bonusNumberReceiver = new BonusNumberReceiver(mockInputProvider, winningNumbers);

        // when & then
        assertThatThrownBy(() -> bonusNumberReceiver.receiveWithMessage())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("BonusNumberReceiver 실패 - 보너스 번호가 범위를 벗어남")
    void fail_receiveBonusNumber_outOfRange() {
        // given
        InputProvider mockInputProvider = () -> "46";
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Receiver<BonusNumber> bonusNumberReceiver = new BonusNumberReceiver(mockInputProvider, winningNumbers);

        // when & then
        assertThatThrownBy(() -> bonusNumberReceiver.receiveWithMessage())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 보너스 번호는 1 이상 45 이하의 양의 정수만 입력 가능합니다.");
    }

    @Test
    @DisplayName("BonusNumberReceiver 실패 - 보너스 번호가 숫자가 아님")
    void fail_receiveBonusNumber_nonNumeric() {
        // given
        InputProvider mockInputProvider = () -> "abc";
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Receiver<BonusNumber> bonusNumberReceiver = new BonusNumberReceiver(mockInputProvider, winningNumbers);

        // when & then
        assertThatThrownBy(() -> bonusNumberReceiver.receiveWithMessage())
            .isInstanceOf(IllegalArgumentException.class);
    }
}
