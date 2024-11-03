package lotto;

import lotto.Model.MyResults;
import lotto.Model.WinningDetails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningDetailsTest {
    @Test
    @DisplayName("sumUpGrade 정상 작동 테스트")
    void sumUpGradeTest() {
        List<MyResults> actualResults = new ArrayList<>();
        WinningDetails actualWinningDetails = new WinningDetails();
        actualResults.add(new MyResults(3, true));
        actualResults.add(new MyResults(3, false));
        actualResults.add(new MyResults(5, false));
        actualWinningDetails.sumUpGrades(actualResults);
        assertThat(actualWinningDetails.getThird()).isEqualTo(2);
        assertThat(actualWinningDetails.getFifth()).isEqualTo(1);
    }

    @Test
    @DisplayName("saveMyGrades 정상 작동 테스트")
    void saveMyGradesTest() {
        int lottoCount = 6;
        int bonus = 7;
        MyResults expectedResult1 = new MyResults(1, false);
        MyResults expectedResult2 = new MyResults(1, false);
        MyResults expectedResult3 = new MyResults(2, true);
        AtomicReference<List<Lotto>> myLottos = new AtomicReference<>(new ArrayList<>());
        Lotto answer = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    myLottos.set(Lotto.sortLottoList(lottoCount));
                    List<MyResults> actualMyResults = WinningDetails.saveMyGrades(myLottos.get(), answer, bonus);
                    assertThat(actualMyResults.get(0).getMatches()).isEqualTo(expectedResult1.getMatches());
                    assertThat(actualMyResults.get(1).getMatches()).isEqualTo(expectedResult2.getMatches());
                    assertThat(actualMyResults.get(2).getMatches()).isEqualTo(expectedResult3.getMatches());
                },
                List.of(5, 8, 10, 12, 26, 40),
                List.of(3, 17, 25, 34, 38, 44),
                List.of(1, 4, 7, 16, 24, 26)
        );
    }

}
