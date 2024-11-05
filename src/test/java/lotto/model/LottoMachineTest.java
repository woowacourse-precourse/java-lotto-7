package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {
    private Lotto lotto;
    private LottoMachine lottoMachine;

    @BeforeEach
    void setLotto() {
        lottoMachine = new LottoMachine();
        lotto = this.lottoMachine.generate();
    }

    @DisplayName("로또 번호 생성시 6개의 번호가 생성되어야 한다.")
    @Test
    void generateSixNumbers() {

        assertEquals(6, lotto.getNumbers().size());
    }

    @DisplayName("생성되는 번호의 범위는 1부터 45 사이다")
    @Test
    void generateNumbersInRange() {
        for (int number : lotto.getNumbers()) {
            assertTrue(number >= 1 && number <= 45);
        }
    }

    @DisplayName("생성되는 6개의 번호는 중복되지 않는 번호들이다.")
    @Test
    void generateUniqueNumbers() {
        List<Integer> numbers = lotto.getNumbers();
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        assertEquals(numbers.size(), uniqueNumbers.size());
    }
}