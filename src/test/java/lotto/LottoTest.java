package lotto;

import static org.assertj.core.api.Assertions.assertThat;
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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @DisplayName("메서드_테스트")
    @Test
    void methodTest(){
        final List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6))); //matchCnt: 6
        lottos.add(new Lotto(List.of(1, 6, 8, 4, 3, 2))); //matchCnt: 5
        lottos.add(new Lotto(List.of(1, 4, 5, 11, 2, 7)));//matchCnt: 4

        final List<Integer> winningNums = List.of(1,2,3,4,5,6,7);

        assertThat(Lotto.compareBasicNum(lottos.getLast(), winningNums)).isEqualTo(4);
        assertThat(Lotto.isBonusMatched(lottos.getLast(), winningNums)).isEqualTo(true);
        //assertThat(Lotto.cntWinningLottos(lottos, winningNums)).containsExactly(6,5,4);
    }

    @DisplayName("예외_테스트")
    @Test
    void exceptionTest(){

    }
}
