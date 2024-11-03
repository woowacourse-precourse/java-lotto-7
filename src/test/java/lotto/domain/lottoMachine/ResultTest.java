package lotto.domain.lottoMachine;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.mock.FakeNumberGenerator;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    void 로또_당첨_상금을_확인할_수_있다() {
        // given
        Lotto lotto = Lotto.from("1,2,3,4,5,6");
        BonusNumber bonusNumber = BonusNumber.from("7");
        WinningLotto winningLotto = WinningLotto.of(lotto, bonusNumber);

        Lottos lottos = Lottos.of(3, FakeNumberGenerator.from(List.of(1, 2, 3, 4, 5, 7)));
        Result result = Result.of(lottos, winningLotto);

        // when - then
        assertThat(result.getReward()).isEqualTo(90_000_000);

    }
}
