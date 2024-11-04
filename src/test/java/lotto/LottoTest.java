package lotto;

import lotto.model.Lotto;
import lotto.model.LottoPrizeMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    @Test
    @DisplayName("로또 번호를 오름차순으로 출력한다")
    void 로또_번호_출력() {
        Lotto lotto = new Lotto(List.of(5, 3, 1, 4, 6, 2));
        lotto.printLottoNumbers(lotto.getNumbers());  // [1, 2, 3, 4, 5, 6] 형식으로 출력됨
    }

    @Test
    @DisplayName("로또 당첨을 판정한다")
    void 로또_당첨_판정() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.judgeWinning(lotto.getNumbers(), List.of(1, 2, 3, 4, 5, 6), 7))
                .isEqualTo(LottoPrizeMoney.FIRST);

        assertThat(lotto.judgeWinning(lotto.getNumbers(), List.of(1, 2, 3, 4, 5, 7), 6))
                .isEqualTo(LottoPrizeMoney.SECOND);
    }

    @Test
    @DisplayName("구매 금액 대비 수익률을 계산한다")
    void 수익률_계산() {
        Lotto lotto = new Lotto();
        float rate = lotto.calculateEarningRate(10, 1, 0, 0, 0, 0);
        assertThat(rate).isEqualTo(2.E7f);
    }
}
