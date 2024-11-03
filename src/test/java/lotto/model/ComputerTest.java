package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class ComputerTest {
    @Test
    void 당첨_로또_발행() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        Computer computer = new Computer(winningNumbers);
        Lotto winningLotto = computer.getWinningLotto();

        assertEquals(winningNumbers, winningLotto.getNumbers());
    }

    @Test
    void 보너스_번호_설정() {
        int bonusNumber = 7;

        Computer computer = new Computer(List.of(1, 2, 3, 4, 5, 6));
        computer.setBonusNumber(bonusNumber);

        assertEquals(bonusNumber, computer.getBonusNumber());
    }
}