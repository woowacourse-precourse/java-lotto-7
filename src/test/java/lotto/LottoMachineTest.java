package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoMachineTest {

    @DisplayName("발행한 로또 수량은 로또 구입 금액을 천 원으로 나눈 몫이다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 5000, 10000})
    void numberOfLottoShouldBeBudgetDividedBy1000Won(int budget) {
        List<Lotto> results = LottoMachine.drawResults(budget);

        assertThat(results.size()).isEqualTo(budget / 1000);
    }
}
