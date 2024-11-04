package lotto;

import lotto.dto.Rank;
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
    void 당첨을_확인한다_1등(){
        Lotto  lotto=new Lotto(List.of(1,2,3,4,5,6));

        List<Integer> winingLotto=List.of(1,2,3,4,5,6);
        int bonus=7;
        Rank rank=lotto.checkWining(winingLotto,7);


        assertThat(rank).isEqualTo(Rank.FIRST);
    }
    @Test
    void 당첨을_확인한다_2등(){
        Lotto  lotto=new Lotto(List.of(7,2,3,4,5,6));

        List<Integer> winingLotto=List.of(1,2,3,4,5,6);
        int bonus=7;
        Rank rank=lotto.checkWining(winingLotto,7);


        assertThat(rank).isEqualTo(Rank.SECOND);
    }
    @Test
    void 당첨을_확인한다_3등(){
        Lotto  lotto=new Lotto(List.of(11,2,3,4,5,6));

        List<Integer> winingLotto=List.of(1,2,3,4,5,6);
        int bonus=7;
        Rank rank=lotto.checkWining(winingLotto,7);


        assertThat(rank).isEqualTo(Rank.THIRD);
    }
    @Test
    void 당첨을_확인한다_4등(){
        Lotto  lotto=new Lotto(List.of(8,7,3,4,5,6));

        List<Integer> winingLotto=List.of(1,2,3,4,5,6);
        int bonus=7;
        Rank rank=lotto.checkWining(winingLotto,7);


        assertThat(rank).isEqualTo(Rank.FOURTH);
    }
    @Test
    void 당첨을_확인한다_5등(){
        Lotto  lotto=new Lotto(List.of(9,8,7,4,5,6));

        List<Integer> winingLotto=List.of(1,2,3,4,5,6);
        int bonus=7;
        Rank rank=lotto.checkWining(winingLotto,7);


        assertThat(rank).isEqualTo(Rank.FIFTH);
    }
    @Test
    void 당첨을_확인한다_등수없음(){
        Lotto  lotto=new Lotto(List.of(7,8,9,10,11,12));

        List<Integer> winingLotto=List.of(1,2,3,4,5,6);
        int bonus=7;
        Rank rank=lotto.checkWining(winingLotto,7);


        assertThat(rank).isEqualTo(Rank.NONE);
    }

}
