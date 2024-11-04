package lotto.view;


import static org.assertj.core.api.Assertions.assertThatThrownBy;


import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LottoViewTest {
    @DisplayName("보너스 번호가 1부터 45 사이가 아니면 예외가 발생한다.")
    @Test
    void 보너스_번호가_1부터_45_사이가_아니면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> LottoView.validateBonusNumber(46, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }


    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> LottoView.validateBonusNumber(5, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
