package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {

    private Calculator calculator;
    private List<Lotto> lottos;

    @BeforeEach
    void setUp(){
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = Arrays.asList(7, 8, 9, 10 ,11, 12);
        List<Integer> numbers3 = Arrays.asList(13, 14, 15, 16, 17, 18);
        Lotto lotto1 = new Lotto(numbers1);
        Lotto lotto2 = new Lotto(numbers2);
        Lotto lotto3 = new Lotto(numbers3);

        lottos = new ArrayList<>(Arrays.asList(lotto1, lotto2, lotto3));
    }

    @ParameterizedTest
    @CsvSource({"3, 1", "4, 0", "5, 0", "6, 0", "7, 0"})
    void 번호_3개_일치하는_로또가_1개면_당첨내역에도_1개로_저장한다(int rank, int count) {
        //given
        List<Integer> winningNumbers = Arrays.asList(1,2,3,19,20,21);
        int bonusNumber = 22;
        calculator = new Calculator(lottos, winningNumbers, bonusNumber);
        Rank[] ranks = Rank.values();
        //when
        Result result = calculator.calculateResult();
        Map<Rank, Integer> winningDetails = result.getWinningDetails();
        //then
        Assertions.assertThat(winningDetails.get(ranks[rank]))
                .isEqualTo(count);

    }

    @ParameterizedTest
    @CsvSource({"3, 2", "4, 0", "5, 0", "6, 0", "7, 0"})
    void 번호_3개_일치하는_로또가_2개면_당첨내역에도_2개로_저장한다(int rank, int count) {
        //given
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = Arrays.asList(1,2,3,19,20,21);
        int bonusNumber = 22;
        calculator = new Calculator(lottos, winningNumbers, bonusNumber);
        Rank[] ranks = Rank.values();
        //when
        Result result = calculator.calculateResult();
        Map<Rank, Integer> winningDetails = result.getWinningDetails();
        //then
        Assertions.assertThat(winningDetails.get(ranks[rank]))
                .isEqualTo(count);

    }

    @ParameterizedTest
    @CsvSource({"3, 0", "4, 1", "5, 0", "6, 0", "7, 0"})
    void 번호_4개_일치하는_로또가_1개면_당첨내역에도_1개로_저장한다(int rank, int count) {
        //given
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,20,21);
        int bonusNumber = 22;
        calculator = new Calculator(lottos, winningNumbers, bonusNumber);
        Rank[] ranks = Rank.values();
        //when
        Result result = calculator.calculateResult();
        Map<Rank, Integer> winningDetails = result.getWinningDetails();
        //then
        Assertions.assertThat(winningDetails.get(ranks[rank]))
                .isEqualTo(count);

    }

    @ParameterizedTest
    @CsvSource({"3, 0", "4, 0", "5, 0", "6, 0", "7, 1"})
    void 번호_6개_일치하는_로또가_1개면_당첨내역에도_1개로_저장한다(int rank, int count) {
        //given
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        int bonusNumber = 7;
        calculator = new Calculator(lottos, winningNumbers, bonusNumber);
        Rank[] ranks = Rank.values();
        //when
        Result result = calculator.calculateResult();
        Map<Rank, Integer> winningDetails = result.getWinningDetails();
        //then
        Assertions.assertThat(winningDetails.get(ranks[rank]))
                .isEqualTo(count);

    }


}