package lotto;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    void 로또_생성_개수_확인() {
        List<Lotto> lottos = lottoMachine.generateLottos(5);
        assertThat(lottos).hasSize(5);
    }

    @Test
    void 당첨_번호_설정_정상작동_확인() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        lottoMachine.setWinningLotto(winningNumbers);

        List<Rank> results = lottoMachine.checkResults();
        assertThat(results).isNotNull();
    }

    @Test
    void 보너스번호_설정_정상범위_확인() {
        lottoMachine.setWinningLotto(List.of(1, 2, 3, 4, 5, 6));
        lottoMachine.setBonusNumbers(7);
    }

    @Test
    void 보너스번호가_1에서_45_범위를_벗어날_경우_예외() {
        lottoMachine.setWinningLotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> lottoMachine.setBonusNumbers(50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 보너스번호가_당첨번호와_중복될_경우_예외() {
        lottoMachine.setWinningLotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> lottoMachine.setBonusNumbers(6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] : 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}
