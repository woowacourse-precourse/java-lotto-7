package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    @DisplayName("로또 구매 금액에 따라 올바른 수의 로또가 생성되어야 한다")
    void purchaseLottosShouldGenerateCorrectNumberOfLottos() {
        int amount = 5000;
        List<Lotto> lottos = lottoMachine.purchaseLottos(amount);
        assertEquals(5, lottos.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 5000, 10000})
    @DisplayName("다양한 구매 금액에 대해 올바른 수의 로또가 생성되어야 한다")
    void purchaseLottosShouldGenerateCorrectNumberOfLottosForVariousAmounts(int amount) {
        List<Lotto> lottos = lottoMachine.purchaseLottos(amount);
        assertEquals(amount / 1000, lottos.size());
    }

    @Test
    @DisplayName("생성된 각 로또는 6개의 숫자를 포함해야 한다")
    void eachLottoShouldContainSixNumbers() {
        List<Lotto> lottos = lottoMachine.purchaseLottos(1000);
        for (Lotto lotto : lottos) {
            assertEquals(6, lotto.getNumbers().size());
        }
    }

    @Test
    @DisplayName("생성된 로또 번호는 1부터 45 사이여야 한다")
    void lottoNumbersShouldBeBetweenOneAndFortyFive() {
        List<Lotto> lottos = lottoMachine.purchaseLottos(1000);
        for (Lotto lotto : lottos) {
            for (int number : lotto.getNumbers()) {
                assertTrue(number >= 1 && number <= 45);
            }
        }
    }

    @Test
    @DisplayName("생성된 로또 번호는 중복되지 않아야 한다")
    void lottoNumbersShouldBeUnique() {
        List<Lotto> lottos = lottoMachine.purchaseLottos(1000);
        for (Lotto lotto : lottos) {
            Set<Integer> uniqueNumbers = lotto.getNumbers().stream().collect(Collectors.toSet());
            assertEquals(6, uniqueNumbers.size());
        }
    }

    @Test
    @DisplayName("생성된 로또 번호는 정렬되어야 한다")
    void lottoNumbersShouldBeSorted() {
        List<Lotto> lottos = lottoMachine.purchaseLottos(1000);
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            for (int i = 0; i < numbers.size() - 1; i++) {
                assertTrue(numbers.get(i) < numbers.get(i + 1));
            }
        }
    }
}