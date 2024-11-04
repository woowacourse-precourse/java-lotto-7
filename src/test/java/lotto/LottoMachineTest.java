package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    @DisplayName("로또 번호를 정상적으로 생성한다.")
    @Test
    void generateLotto() {
        Lotto lotto = LottoMachine.generateLotto();
        List<Integer> numbers = lotto.getNumbers();

        assertThat(numbers).hasSize(6);
        assertThat(numbers.get(0)).isBetween(1, 45);
        assertThat(numbers).doesNotHaveDuplicates();
        assertThat(numbers).isSorted();
    }
}