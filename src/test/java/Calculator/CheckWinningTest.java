package Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 번호와 로또 번호 비교 테스트")
public class CheckWinningTest {

    @Test
    @DisplayName("로또 당첨 확인 테스트")
    public void checkTest() {
        //given
        List<Lotto> testLottos = new ArrayList<>();
        HashSet<Integer> testWinningNumbers = new HashSet<>();
        int bonusNumber = 7;

        List<Integer> testLottoOne = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> testLottoTwo = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        List<Integer> testLottoThree = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8));

        testLottos.add(new Lotto(testLottoOne));
        testLottos.add(new Lotto(testLottoTwo));
        testLottos.add(new Lotto(testLottoThree));

        testWinningNumbers.add(1);
        testWinningNumbers.add(2);
        testWinningNumbers.add(3);
        testWinningNumbers.add(4);
        testWinningNumbers.add(5);
        testWinningNumbers.add(6);

        //when
        CheckWinning checkWinning = new CheckWinning();
        var result = checkWinning.check(testLottos, testWinningNumbers, bonusNumber);

        //then
        HashMap<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 1);
        expected.put(2, 1);
        expected.put(3, 1);
        expected.put(4, 0);
        expected.put(5, 0);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("등수 확인 테스트")
    public void checkDetailTest() {
        //given
        List<Integer> testMyLotto = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        HashSet<Integer> testWinningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int testBonusNumber = 7;
        List<Integer> testMyLotto2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7));

        //when
        CheckWinning checkWinning = new CheckWinning();
        int result = checkWinning.checkDetail(testMyLotto, testWinningNumbers, testBonusNumber);
        int result2 = checkWinning.checkDetail(testMyLotto2, testWinningNumbers, testBonusNumber);

        //then
        assertEquals(1, result);
        assertEquals(2, result2);
    }


    @Test
    @DisplayName("동일한 숫자 몇 개인지 확인하는 테스트")
    public void compareTest() {
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
