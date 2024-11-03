package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
    void 로또_번호의_숫자가_1_이상_45_이하가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 로또_번호에_존재하는_당첨_번호의_개수를_반환한다() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        int count = lotto.countCollect(winningNumbers);
        assertThat(count).isEqualTo(6);
    }
    @Test
    void 로또_번호에_보너스_번호가_존재하는지_판단한다() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Integer bonus = 1;
        boolean flag = lotto.checkBonus(lotto.getNumbers(), bonus);
        assertThat(flag).isTrue();

        bonus = 7;
        flag = lotto.checkBonus(lotto.getNumbers(), bonus);
        assertThat(flag).isFalse();
    }
    @Test
    void 일치하는_번호의_개수에_따라_알맞는_객체를_반환하는지_판단한다() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,7,8,9));
        int bonus = 45;
        ResultManager rm = new ResultManager(winningNumbers, bonus);

        Result result = rm.getResult(3, lotto);
        assertThat(result).isEqualTo(Result.Three);
    }

    @Test
    void 로또_당첨_수익을_계산한다() {
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,8,9));
        int bonus = 45;
        ResultManager rm = new ResultManager(winningNumbers, bonus);
        lottos.add(lotto);

        double profit = rm.analyzeResult(lottos);
        assertThat(profit).isEqualTo(50000);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
