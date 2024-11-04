package lotto.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import lotto.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("OutputView 클래스 테스트")
public class OutputViewTest {

    private OutputView outputView = new OutputView();

    @Test
    void 발행_로또_수량_출력_테스트() {
        //given & when
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        int publishCount = 7;
        outputView.printPublishCountMessage(publishCount);

        //then
        String expected = "7개를 구매했습니다.";
        assertThat(outputStream.toString()).isEqualTo(expected);
    }

    @Test
    void 당첨_통계_출력_테스트() {
        //given
        Map<Prize, Integer> winningCounts = new HashMap<>();
        winningCounts.put(Prize.FIRST, 0);
        winningCounts.put(Prize.SECOND, 0);
        winningCounts.put(Prize.THIRD, 0);
        winningCounts.put(Prize.FOURTH, 0);
        winningCounts.put(Prize.FIFTH, 1);

        // when
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        outputView.printWinningStatMessage(winningCounts);

        // then
        String expected = "당첨 통계\n---\n" +
            "3개 일치 (5,000원) - 1개\n" +
            "4개 일치 (50,000원) - 0개\n" +
            "5개 일치 (1,500,000원) - 0개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
            "6개 일치 (2,000,000,000원) - 0개\n";
        assertThat(outputStream.toString()).isEqualTo(expected);

    }

}
