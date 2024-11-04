package lotto.model.draw;

import static org.assertj.core.api.Assertions.*;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoGenerator;
import lotto.model.strategy.CustomStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningLottoTicketTest {

    private LottoGenerator lottoGenerator;
    private WinningLottoTicket winningLottoTicket;

    @BeforeEach
    void beforeEach() {
        lottoGenerator = new LottoGenerator();
        Lotto winningLotto = lottoGenerator.generateSingleLotto(CustomStrategy.of("1,2,3,4,5,6"));
        BonusNumber bonusNumber = BonusNumber.from("7");
        winningLottoTicket = WinningLottoTicket.of(winningLotto, bonusNumber);
    }

    @Test
    void 구입한_로또에_보너스_번호가_포함되어_있으면_TRUE() {
        Lotto lotto = lottoGenerator.generateSingleLotto(CustomStrategy.of("1,5,7,9,14,23"));
        assertThat(winningLottoTicket.isContainBonusNumber(lotto)).isTrue();
    }

    @Test
    void 구입한_로또에_보너스_번호가_포함되어_있지_않으면_FALSE() {
        Lotto lotto = lottoGenerator.generateSingleLotto(CustomStrategy.of("1,5,6,9,14,23"));
        assertThat(winningLottoTicket.isContainBonusNumber(lotto)).isFalse();
    }

    @Test
    void 구입한_로또와_당첨_번호_사이의_일치하는_번호_개수를_확인합니다() {
        Lotto lotto = lottoGenerator.generateSingleLotto(CustomStrategy.of("1,2,3,9,14,23"));
        assertThat(winningLottoTicket.countSameNumber(lotto)).isEqualTo(3);
    }

}