package lotto.model;

import lotto.model.Lotto;
import lotto.model.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
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

    @DisplayName("로또 번호가 1에서 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호가_1에서_45_사이의_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호는_항상_오름차순이여야_한다(){
        Lotto lotto = new Lotto(List.of(6,5,4,3,2,1));

        List<Integer> expected = Arrays.asList(1,2,3,4,5,6);

        assertThat(lotto.getNumbers()).isEqualTo(expected);
    }
    @Test
    void 로또_당첨번호_비교(){

        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)),7); //당첨 로또가 1,2,3,4,5,6 보너스 7

        Lotto losingLotto = new Lotto(List.of(8,9,10,11,12,13)); //미당첨 로또
        Lotto FirstLotto = new Lotto(List.of(1,2,3,4,5,6)); //1등 당첨 로또
        Lotto fifthLotto = new Lotto(List.of(1,2,3,10,11,12)); //5등 당첨 로또
        Lotto secondLotto = new Lotto(List.of(1,2,3,4,5,7)); //2등 당첨로또

        assertThat(FirstLotto.compareTo(winningLotto.getWinningLotto())).isEqualTo(6); //매칭되는 개수가 6개
        assertThat(losingLotto.compareTo(winningLotto.getWinningLotto())).isEqualTo(0);
        assertThat(fifthLotto.compareTo(winningLotto.getWinningLotto())).isEqualTo(3);
        assertThat(secondLotto.compareTo(winningLotto.getWinningLotto())).isEqualTo(5);
    }
}
