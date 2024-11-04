package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultReportTest {

    @Test
    @DisplayName("리포트클래스를 등수 배열과 함께 생성하면 등수배열을 멤버변수로 저장한다.")
    void createResultReportTest(){
        Integer[] arr = new Integer[]{0,2,5};
        ResultReport resultReport = new ResultReport(arr);

        Assertions.assertThat(resultReport.prizeArray[0]).isEqualTo(0);
        Assertions.assertThat(resultReport.prizeArray[1]).isEqualTo(2);
        Assertions.assertThat(resultReport.prizeArray[2]).isEqualTo(5);
    }

    @Test
    @DisplayName("등수 배열로 등수 맵을 만든다-각 등수에 해당하는 로또가 몇 개인지 저장하는 맵")
    void mappingLottoTest(){
        Integer[] arr = new Integer[]{0,2,5};
        ResultReport resultReport = new ResultReport(arr);

        resultReport.mappingLotto();

        Assertions.assertThat(resultReport.hashMap.get("5")).isEqualTo(1);
        Assertions.assertThat(resultReport.hashMap.get("4")).isEqualTo(0);

    }

    @Test
    @DisplayName("등수에 따른 수익률 계산하기")
    void computeEarningRateTest(){
        Integer[] arr = new Integer[]{0,2,5};
        ResultReport resultReport = new ResultReport(arr);

        resultReport.mappingLotto();
        resultReport.computeEarningRate();

        Assertions.assertThat(resultReport.earningRate).isEqualTo("1000166.7");
    }


}
