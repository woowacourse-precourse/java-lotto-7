package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.LottoApplicationException;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class WinningLottoTest {

    @Test
    void 당첨_번호와_구매한_로또를_비교할_수_있다() {
        // given
        WinningLotto winningLotto = new WinningLotto(Lotto.of(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(7));
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 7));

        // when
        MatchResult matchResult = winningLotto.match(lotto);

        // then
        assertThat(matchResult.sameNumberCount()).isEqualTo(5);
        assertThat(matchResult.bonusMatched()).isTrue();
    }

    @Test
    void 당첨_번호와_보너스_번호는_중복될_수_없다() {
        // given
        Lotto winningNumbers = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(1);

        // when & then
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(LottoApplicationException.class)
                .hasMessage("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
    }

}
