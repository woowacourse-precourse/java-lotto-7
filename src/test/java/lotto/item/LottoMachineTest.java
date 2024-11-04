package lotto.item;

import lotto.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.common.LottoInfo.LOTTO_END_NUMBER;
import static lotto.common.LottoInfo.LOTTO_START_NUMBER;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {
    private LottoMachine lottoMachine = new LottoMachine();

    @Test
    public void 올바른_개수의_로또를_구매하는지_테스트() {
        // given
        int money = 3000;  // 사용자가 로또 구매에 사용하는 금액은 로또 금액에 나누어떨어지도록 필터링 되어 입력됨이 보장된다.

        // when
        List<Lotto> lottos = lottoMachine.buy(money);

        // then
        Assertions.assertEquals(3, lottos.size());
    }

    @Test
    public void 구매한_로또가_6개의_번호를_가지고_있는지_테스트() {
        // given
        int money = 3000;

        // when
        List<Lotto> lottos = lottoMachine.buy(money);

        // then
        Assertions.assertEquals(6, lottos.getFirst().getNumbers().size());
    }

    @Test
    public void 구매한_로또의_번호의_범위가_올바른지_테스트() {
        // given
        int money = 3000;

        // when
        List<Lotto> lottos = lottoMachine.buy(money);
        List<Integer> lottoNumbers = lottos.getFirst().getNumbers();

        // then
        Assertions.assertTrue(lottoNumbers.stream().allMatch(i -> i>=LOTTO_START_NUMBER && i<=LOTTO_END_NUMBER));
    }

    @Test
    public void 구매한_로또의_번호에_중복이_존재하는지_테스트() {
        // given
        int money = 3000;

        // when
        List<Lotto> lottos = lottoMachine.buy(money);
        List<Integer> lottoNumbers = lottos.getFirst().getNumbers();
        Set<Integer> duplicateRemovedNumbers = new HashSet<>(lottoNumbers);

        boolean isDuplicated = duplicateRemovedNumbers.size() != lottoNumbers.size();

        // then
        Assertions.assertFalse(isDuplicated);
    }
}