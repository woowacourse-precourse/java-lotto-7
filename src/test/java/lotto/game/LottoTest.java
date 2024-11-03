package lotto.game;

import lotto.dto.LottoPrize;
import lotto.dto.Buyer;
import lotto.dto.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @DisplayName("로또 당첨 개수에 따라 등수를 반환한다.")
    @Test
    void getLottoPrize() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        String numbers = "1,2,3,4,5,6";
        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        int bonusNumber = 13;
        Buyer buyer = new Buyer(winningNumbers, bonusNumber);

        // when
        LottoPrize lottoPrize = lotto.decideLottoPrize(buyer);

        // then
        assertThat(lottoPrize).isEqualTo(LottoPrize.SIX);
    }

    @DisplayName("보너수 번호 포함 여부와 로또 당첨 개수에 따라 등수를 반환한다.")
    @Test
    void getLottoPrize_bunus() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 13));

        String numbers = "1,2,3,4,5,6";
        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        int bonusNumber = 13;
        Buyer buyer = new Buyer(winningNumbers, bonusNumber);

        // when
        LottoPrize lottoPrize = lotto.decideLottoPrize(buyer);

        // then
        assertThat(lottoPrize).isEqualTo(LottoPrize.BONUS);
    }
}
