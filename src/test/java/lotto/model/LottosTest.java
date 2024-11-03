package lotto.model;


import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
class LottosTest {

    @DisplayName("당첨번호에 중복이 있으면 예외가 발생한다.")
    @Test
    void 당첨번호에_중복이_있으면_예외가_발생한다(){
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 5);
        Integer bonusNumber = 6;
        assertThatThrownBy(() -> new Lottos(lottos, winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호가 당첨번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스번호가_당첨번호와_중복되면_예외가_발생한다(){
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 6;
        assertThatThrownBy(() -> new Lottos(lottos, winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호의 개수는 6개여야 한다.")
    @Test
    void 당첨번호의_개수는_6개여야_한다(){
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5);
        Integer bonusNumber = 6;
        assertThatThrownBy(() -> new Lottos(lottos, winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
