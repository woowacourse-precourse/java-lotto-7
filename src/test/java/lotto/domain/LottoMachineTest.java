package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    private final LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("구입 금액을 입력하면 금액에 해당하는 개수의 로또가 생성된다")
    @Test
    void 구입_금액에_해당하는_개수의_로또가_생성된다() {
        // given
        int amount = 5000;

        // when
        List<Lotto> lottos = lottoMachine.purchaseLottos(amount);

        // then
        assertThat(lottos).hasSize(5);
    }

    @DisplayName("로또 번호는 1부터 45 사이의 6개의 중복되지 않는 숫자로 구성된다")
    @Test
    void 로또_번호는_1부터_45_사이의_중복되지_않는_6개의_숫자로_구성된다() {
        // given
        int count = 1;

        // when
        Lotto lotto = lottoMachine.generateLottos(count).getFirst();
        List<Integer> numbers = lotto.getNumbers();

        // then
        assertThat(numbers).hasSize(6);
        assertThat(numbers).allMatch(num -> num >= LottoConstants.LOTTO_MIN_NUMBER.getValue()
                && num <= LottoConstants.LOTTO_MAX_NUMBER.getValue());
        assertThat(numbers).doesNotHaveDuplicates();
    }
}
