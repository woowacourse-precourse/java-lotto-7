package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.Exception.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {
    private WinningLotto winningLotto;

    @DisplayName("당첨번호와 보너스번호 정상 입력")
    @Test
    void 당첨번호와_보너스번호_정상입력() {
        // given
        Lotto validWinningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int validBonusNumber = 10;

        // when, then
        winningLotto = new WinningLotto(validWinningNumber, validBonusNumber);
    }

    @DisplayName("당첨번호의 구분자가 쉼표가 아니면 예외발생")
    @Test
    void 당첨번호의_구분자가_쉼표가_아니면_예외발생() {
        // given
        String invalidDelimiterWinningNumbers = "1.2.3.4.5.6";

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(invalidDelimiterWinningNumbers))
                .withMessage(WINNING_NUMBER_NOT_NUMERIC.getMessage());
    }

    @DisplayName("당첨번호가 1~45 사이의 숫자가 아니면 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,66"})
    void 당첨번호가_1_45_사이의_숫자가_아니면_예외발생(String overRangeWinningNumbers) {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(overRangeWinningNumbers))
                .withMessage(INVALID_RANGE_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("당첨번호가 중복되면 예외발생")
    @Test
    void 당첨번호가_중복되면_예외발생() {
        // given
        String dupleWinningNumbers = "1,2,3,4,5,5";

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(dupleWinningNumbers))
                .withMessage(DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("당첨번호가 숫자가 아니면 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"one,two,three,four,five,six", "many", "numbers"})
    void 당첨번호가_숫자가_아니면_예외발생(String notNumberWinningNumbers) {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(notNumberWinningNumbers))
                .withMessage(WINNING_NUMBER_NOT_NUMERIC.getMessage());
    }

    @DisplayName("당첨번호가 6개가 아니면 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "12,3,4,5,6,7,8"})
    void 당첨번호가_6개가_아니면_예외발생(String invalidLengthWinningNumber) {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(invalidLengthWinningNumber))
                .withMessage(INVALID_LOTTO_NUMBER_SIZE.getMessage());
    }

    @DisplayName("당첨번호에 공백이 포함되면 예외발생")
    @Test
    void 당첨번호에_공백이_포함되면_예외발생() {
        // given
        String invalidNumberWinningLottoInfo = "1,2,3,4,5, 6";

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(invalidNumberWinningLottoInfo))
                .withMessage(WINNING_NUMBER_NOT_NUMERIC.getMessage());
    }

    @DisplayName("보너스 번호가 1 ~ 45 외의 숫자인 경우 예외발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 보너스번호가_1_45_외의_숫자인_경우_예외발생(int invalidBonusNumber) {
        // given
        Lotto validWinningLotto = new Lotto(List.of(1,2,3,4,5,6));

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(validWinningLotto, invalidBonusNumber))
                .withMessage(INVALID_RANGE_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("보너스번호가 당첨번호와 중복되면 예외발생")
    @Test
    void 보너스번호가_당첨번호와_중복되면_예외발생() {
        // given
        Lotto validWinningLotto = new Lotto(List.of(1,2,3,4,5,6));
        int dupleBonusNumber = 3;

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(validWinningLotto, dupleBonusNumber))
                .withMessage(DUPLICATE_WINNING_NUMBER.getMessage());
    }
}