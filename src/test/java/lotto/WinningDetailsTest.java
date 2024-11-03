package lotto;

import lotto.Model.MyResults;
import lotto.Model.WinningDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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


}
