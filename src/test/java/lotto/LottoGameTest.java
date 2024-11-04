package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {
    private final LottoGameValidator validator = new LottoGameValidator();
    private static final int LOTTO_PRICE = 1000;

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validateAmount(2500, LOTTO_PRICE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void 당첨_번호의_개수가_6개가_아니면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> validator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1보다 작거나 45보다 크면 예외가 발생한다.")
    @Test
    void 당첨_번호가_1보다_작거나_45보다_크면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(-1, 0, 1, 2, 3, 46);
        assertThatThrownBy(() -> validator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 당첨 번호가 있으면 예외가 발생한다.")
    @Test
    void 중복된_당첨_번호가_있으면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> validator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 콤마로 구분되지 않은 숫자 문자열이 들어오면 예외가 발생한다.")
    @Test
    void 당첨_번호가_콤마로_구분되지_않은_숫자_문자열이_들어오면_예외가_발생한다() {
        String input = "1,2,3,4,5;6";
        assertThatThrownBy(() -> validator.parseWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1보다 작거나 45보다 크면 예외가 발생한다.")
    @Test
    void 보너스_번호가_1보다_작거나_45보다_크면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> validator.validateBonusNumber(0, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 겹치면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_겹치면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> validator.validateBonusNumber(1, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}