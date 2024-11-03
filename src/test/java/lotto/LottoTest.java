package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @BeforeEach
    void resetCounts() throws NoSuchFieldException, IllegalAccessException {
        for (LottoWinner winner : LottoWinner.values()) {
            Field countField = LottoWinner.class.getDeclaredField("count");
            countField.setAccessible(true); // private 필드 접근 허용
            countField.setInt(winner, 0);   // count 값을 0으로 초기화
        }
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

    @Test
    void 번호가_6개_일치하면_1등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonus_number = 7;
        lotto.checkLottoWin(winningNumber, bonus_number);
        assertThat(LottoWinner.FIRST.getCount())
                .isEqualTo(1);
    }

    @Test
    void 번호가_5개와_보너스번호가_일치하면_2등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonus_number = 7;
        lotto.checkLottoWin(winningNumber, bonus_number);
        assertThat(LottoWinner.SECOND.getCount())
                .isEqualTo(1);
    }

    @Test
    void 번호가_5개_일치하면_3등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonus_number = 7;
        lotto.checkLottoWin(winningNumber, bonus_number);
        assertThat(LottoWinner.THIRD.getCount())
                .isEqualTo(1);
    }

    @Test
    void 번호가_4개_일치하면_4등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonus_number = 7;
        lotto.checkLottoWin(winningNumber, bonus_number);
        assertThat(LottoWinner.FOURTH.getCount())
                .isEqualTo(1);
    }

    @Test
    void 번호가_3개_일치하면_5등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonus_number = 7;
        lotto.checkLottoWin(winningNumber, bonus_number);
        assertThat(LottoWinner.FIFTH.getCount())
                .isEqualTo(1);
    }

    @Test
    void 구입금액이_5000원이면_5장을_발행한다() {
        int purchaseAmount = 5000;
        List<Lotto> lottos = Lotto.issueLottos(Lotto.getIssueAmount(purchaseAmount));
        assertThat(lottos.size()).isEqualTo(5);
    }
}
