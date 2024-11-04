package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoCheckerTest {

    private final Lotto lottoWithBonus = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private final Lotto lottoWithoutBonus = new Lotto(List.of(1, 2, 3, 4, 5, 7));

    private List<Integer> inputNumber;
    private int bonusNumber;

    @Test
    void 몇_개의_로또_번호가_일치했는가() {
        inputNumber = List.of(1, 2, 3, 4, 5, 6);
        bonusNumber = 7;

        LottoChecker lottoChecker = new LottoChecker(inputNumber, bonusNumber);
        int matchCount = lottoChecker.checkLotto(lottoWithoutBonus);
        assertThat(matchCount).isEqualTo(5);
    }

    @Test
    void 로또_일치_정보_받아오기_테스트() {
        inputNumber = List.of(1, 2, 3, 4, 5, 6);
        bonusNumber = 7;

        List<Lotto> lottos = List.of(lottoWithBonus, lottoWithoutBonus);
        LottoChecker lottoChecker = new LottoChecker(inputNumber, bonusNumber);
        List<Integer> matchNumberCount = lottoChecker.checkLottos(lottos);

        assertThat(matchNumberCount).containsExactly(0, 0, 0, 0, 0, 0, 1, 1);
    }

}