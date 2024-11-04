package Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 번호와 로또 번호 비교 테스트")
public class CheckWinningTest {  // 클래스가 public이어야 함

    @Test
    public void compareTest() {  // 메서드가 public이어야 함
        // given
        HashSet<Integer> winningNumbers = new HashSet<>();
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);

        List<Integer> singleLotto = new ArrayList<>();
        singleLotto.add(5);
        singleLotto.add(6);
        singleLotto.add(7);
        singleLotto.add(8);
        singleLotto.add(9);
        singleLotto.add(10);

        // when
        CheckWinning checkWinning = new CheckWinning();
        int result = checkWinning.compare(winningNumbers, singleLotto);

        // then
        assertEquals(2, result);
    }
}
