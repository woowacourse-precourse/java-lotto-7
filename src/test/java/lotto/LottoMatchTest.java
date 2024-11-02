package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoMatchTest {

    @Test
    void 로또_번호_일치_개수_구하기() {
        Lotto lotto = new Lotto(
                List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3), LottoNumber.from(4),
                        LottoNumber.from(5), LottoNumber.from(6)));
        WinningLotto winningLotto = new WinningLotto("1,2,3,7,8,9", "10");
        assertThat(LottoMatch.calculateWinnings(lotto, winningLotto)).isEqualTo(3L);
    }

    @Test
    void 보너스_번호_일치_여부_확인() {
        Lotto lotto = new Lotto(
                List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3), LottoNumber.from(4),
                        LottoNumber.from(5), LottoNumber.from(6)));
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,7", "6");
        assertThat(LottoMatch.hasBonusMatch(lotto, winningLotto)).isTrue();
    }
}
