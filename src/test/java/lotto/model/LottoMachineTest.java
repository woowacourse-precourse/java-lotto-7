package lotto.model;

import lotto.Lotto;
import lotto.model.generator.LottoNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoMachineTest {
    private LottoNumberGenerator lottoNumberGenerator;
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoNumberGenerator = new LottoNumberGenerator();
        lottoMachine = new LottoMachine(lottoNumberGenerator);
    }

    @Test
    @DisplayName("입력한 금액에 맞게 로또 개수가 생성되는지 테스트")
    void buyLottos_quantityTest() {
        int amount = 5000;
        int quantity = amount / 1000;

        List<Lotto> lottos = lottoMachine.buyLottos(amount);

        assertEquals(quantity, lottos.size());
    }

    @Test
    @DisplayName("생성된 로또 각 번호가 6개의 숫자로 구성되는지 테스트")
    void buyLottos_lottoNumbersTest() {
        int amount = 3000;

        List<Lotto> lottos = lottoMachine.buyLottos(amount);

        for (Lotto lotto : lottos) {
            assertEquals(6, lotto.getNumbers().size());
        }
    }

    @Test
    @DisplayName("생성된 로또 번호가 중복되지 않고 1-45 사이의 범위인지 테스트")
    void buyLottos_numberRangeTest() {
        int amount = 2000;

        List<Lotto> lottos = lottoMachine.buyLottos(amount);

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            assertEquals(6, numbers.size());
            assertEquals(6, numbers.stream().distinct().count());
            assertTrue(numbers.stream().allMatch(num -> num >= 1 && num <= 45));
        }
    }
}
