package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void 정상적으로_당첨_로또_번호_클래스_생성() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int number = 7;

        Lotto winningLotto = new Lotto(numbers);
        LottoNumber bonusNumber = new LottoNumber(number);

        // when
        WinningLotto winningLottoResult = new WinningLotto(winningLotto, bonusNumber);

        // then
        assertThat(winningLottoResult.getWinningLotto().getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningLottoResult.getBonusNumber()).isEqualTo(7);
    }

    @Test
    void 예외_당첨_로또_번호와_보너스_번호가_중복되는_경우() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int number = 6;

        Lotto winningLotto = new Lotto(numbers);
        LottoNumber bonusNumber = new LottoNumber(number);

        // when & then
        assertThatThrownBy(() -> new WinningLotto(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호에 중복된 번호가 존재합니다.");
    }
}