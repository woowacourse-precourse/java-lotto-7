package lotto;

import lotto.number.LottoNumber;
import lotto.winner.WinnerLottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void 로또_번호_저장_성공_테스트() {
        Lotto lotto = Lotto.createOfLotto(List.of(3,4,1,2,8,5));
        assertThat(lotto.getNumbers()).isEqualTo(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(8)));
    }


    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.createOfLotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.createOfLotto((List.of(1, 2, 3, 4, 5, 5))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_일등_당첨_테스트() {
        Lotto lotto = Lotto.createOfLotto(List.of(1, 2, 3, 4, 5, 6));
        WinnerLottoNumber winnerLottoNumber = WinnerLottoNumber.createOfWinnerLottoNumber("1,2,3,4,5,6");
        LottoNumber bonusNumber = new LottoNumber("7");
        assertThat(lotto.hitLottoNumber(winnerLottoNumber, bonusNumber)).isEqualTo(Prize.ONE);
    }

    @Test
    void 로또_번호_이등_보너스_당첨_테스트() {
        Lotto lotto = Lotto.createOfLotto(List.of(1, 2, 3, 4, 5, 7));
        WinnerLottoNumber winnerLottoNumber = WinnerLottoNumber.createOfWinnerLottoNumber("1,2,3,4,5,6");
        LottoNumber bonusNumber = new LottoNumber("7");
        assertThat(lotto.hitLottoNumber(winnerLottoNumber, bonusNumber)).isEqualTo(Prize.TWO);
    }

    @Test
    void 로또_미_당첨_테스트() {
        Lotto lotto = Lotto.createOfLotto(List.of(1, 2, 3, 4, 5, 6));
        WinnerLottoNumber winnerLottoNumber = WinnerLottoNumber.createOfWinnerLottoNumber("5,6,7,8,9,10");
        LottoNumber bonusNumber = new LottoNumber("11");
        assertThat(lotto.hitLottoNumber(winnerLottoNumber, bonusNumber)).isEqualTo(Prize.NOTHING);
    }

}
