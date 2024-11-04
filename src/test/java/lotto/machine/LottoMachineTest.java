package lotto.machine;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @DisplayName("구입 금액에 맞는 개수의 로또를 생성한다.")
    @Test
    void 구입_금액에_맞는_개수의_로또를_생성한다() {
        int purchaseAmount = 5000;
        List<Lotto> lottos = LottoMachine.generateLottos(purchaseAmount);

        assertThat(lottos).hasSize(5);
        assertThat(lottos).hasSize(5);
        assertThat(lottos).allSatisfy(lotto -> {
            assertThat(lotto.getNumbers()).hasSize(6);
            assertThat(lotto.getNumbers()).doesNotHaveDuplicates();
            assertThat(lotto.getNumbers()).allMatch(num -> num >= 1 && num <= 45);
        });
    }

    @DisplayName("생성된 각 로또는 중복 없는 6개의 번호로 구성된다.")
    @Test
    void 생성된_각_로또는_중복_없는_6개의_번호로_구성된다() {
        List<Integer> numbers = LottoMachine.generateLottoNumbers();

        assertThat(numbers).hasSize(6);
        assertThat(numbers).doesNotHaveDuplicates();
        assertThat(numbers).allMatch(num -> num >= 1 && num <= 45);
    }
}
