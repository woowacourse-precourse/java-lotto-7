package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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
    void 로또_번호_3개_일치_테스트(){
        Qualifier qualifier = new Qualifier(List.of(1,2,3,10,8,9),7);
        List<Integer> history = qualifier.analysis(List.of(List.of(1,2,3,4,5,6)));

        assertThat(history.get(Rank.FIFTH.getIdx())).isEqualTo(1);
        assertThat(history.get(Rank.FOUR.getIdx())).isEqualTo(0);
        assertThat(history.get(Rank.THIRD.getIdx())).isEqualTo(0);
        assertThat(history.get(Rank.SECOND.getIdx())).isEqualTo(0);
        assertThat(history.get(Rank.FIRST.getIdx())).isEqualTo(0);
    }

    @Test
    void 로또_번호_4개_일치_테스트(){
        Qualifier qualifier = new Qualifier(List.of(1,2,3,4,8,9),7);
        List<Integer> history = qualifier.analysis(List.of(List.of(1,2,3,4,5,6)));

        assertThat(history.get(Rank.FIFTH.getIdx())).isEqualTo(0);
        assertThat(history.get(Rank.FOUR.getIdx())).isEqualTo(1);
        assertThat(history.get(Rank.THIRD.getIdx())).isEqualTo(0);
        assertThat(history.get(Rank.SECOND.getIdx())).isEqualTo(0);
        assertThat(history.get(Rank.FIRST.getIdx())).isEqualTo(0);
    }

    @Test
    void 로또_번호_5개_일치_테스트(){
        Qualifier qualifier = new Qualifier(List.of(1,2,3,4,5,9),7);
        List<Integer> history = qualifier.analysis(List.of(List.of(1,2,3,4,5,6)));

        assertThat(history.get(Rank.FIFTH.getIdx())).isEqualTo(0);
        assertThat(history.get(Rank.FOUR.getIdx())).isEqualTo(0);
        assertThat(history.get(Rank.THIRD.getIdx())).isEqualTo(1);
        assertThat(history.get(Rank.SECOND.getIdx())).isEqualTo(0);
        assertThat(history.get(Rank.FIRST.getIdx())).isEqualTo(0);
    }

    @Test
    void 로또_번호_5개_일치_보너스번호_일치_테스트(){
        Qualifier qualifier = new Qualifier(List.of(1,2,3,4,5,9),7);
        List<Integer> history = qualifier.analysis(List.of(List.of(1,2,3,4,5,7)));

        assertThat(history.get(Rank.FIFTH.getIdx())).isEqualTo(0);
        assertThat(history.get(Rank.FOUR.getIdx())).isEqualTo(0);
        assertThat(history.get(Rank.THIRD.getIdx())).isEqualTo(0);
        assertThat(history.get(Rank.SECOND.getIdx())).isEqualTo(1);
        assertThat(history.get(Rank.FIRST.getIdx())).isEqualTo(0);
    }


    @Test
    void 로또_번호_6개_일치_테스트(){
        Qualifier qualifier = new Qualifier(List.of(1,2,3,4,5,6),7);
        List<Integer> history = qualifier.analysis(List.of(List.of(1,2,3,4,5,6)));

        assertThat(history.get(Rank.FIFTH.getIdx())).isEqualTo(0);
        assertThat(history.get(Rank.FOUR.getIdx())).isEqualTo(0);
        assertThat(history.get(Rank.THIRD.getIdx())).isEqualTo(0);
        assertThat(history.get(Rank.SECOND.getIdx())).isEqualTo(0);
        assertThat(history.get(Rank.FIRST.getIdx())).isEqualTo(1);
    }


    @Test
    void 수익률_계산_테스트(){
        Qualifier qualifier = new Qualifier(List.of(1,2,3,4,5,6), 7);
        List<Integer> history = new ArrayList<>(List.of(1,0,0,0,0,0));

        String profitRate = qualifier.calcProfit(10000, history);
        assertThat(profitRate).isEqualTo("50.0");
    }



}
