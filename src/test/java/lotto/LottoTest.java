package lotto;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.service.LottoCalculator;
import lotto.service.LottoGenerator;
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

    @Test
    void 당첨번호와_보너스번호에_따라_등수를_계산한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 5개 일치 + 보너스 번호
        int bonusNumber = 7;

        assertThat(LottoCalculator.calculateRank(userLotto, winningNumbers, bonusNumber))
                .isEqualTo(LottoRank.SECOND);
    }

    @Test
    void 티켓_개수만큼_로또를_생성한다() {
        List<Lotto> tickets = LottoGenerator.generateLottoTickets(5);
        assertThat(tickets).hasSize(5);
    }

    @Test
    void 로또_번호를_정렬하여_저장한다() {
        Lotto lotto = new Lotto(List.of(5, 3, 2, 7, 1, 4));
        assertThat(lotto.getNumbers()).isSorted();
    }

    @Test
    void 수익률을_계산하여_소수점_둘째자리에서_반올림한다() {
        double returnRate = LottoCalculator.calculateReturn(5000, 199000);
        assertThat(returnRate).isEqualTo(2.51);
    }


}
