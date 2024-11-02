package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoJackpotTest {

    @Test
    void 당첨_로또_번호와_보너스_번호가_같으면_예외가_발생한다() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoBonusNumber bonusNumber = new LottoBonusNumber(1);

        //when
        assertThatThrownBy(() -> new LottoJackpot(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_로또_생성_성공() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoBonusNumber bonusNumber = new LottoBonusNumber(7);

        //when
        LottoJackpot lottoJackpot = new LottoJackpot(lotto, bonusNumber);

        //then
        assertThat(lottoJackpot.getLotto()).isEqualTo(lotto);
        assertThat(lottoJackpot.getBonusNumber()).isEqualTo(bonusNumber);
    }
}
