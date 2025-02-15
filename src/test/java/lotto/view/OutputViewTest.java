package lotto.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Prize;
import lotto.domain.PublishLotto;
import lotto.validator.DefaultDuplicateValidator;
import lotto.validator.DefaultRangeValidator;
import lotto.validator.LottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("OutputView 클래스 테스트")
public class OutputViewTest {

    private OutputView outputView = new OutputView();
    private LottoValidator lottoValidator = new LottoValidator(new DefaultRangeValidator(),
        new DefaultDuplicateValidator());

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
    void 발행_로또_번호_출력_테스트() {
        //given
        List<PublishLotto> publishLottoList = new ArrayList<>();
        publishLottoList.add(new PublishLotto(List.of(8, 9, 10, 1, 2, 3), lottoValidator));
        publishLottoList.add(new PublishLotto(List.of(4, 5, 6, 11, 12, 13), lottoValidator));
        publishLottoList.add(new PublishLotto(List.of(1, 2, 3, 4, 5, 6), lottoValidator));

        //when
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        outputView.printPublishLottos(publishLottoList);

        //then
        String output = outputStream.toString();
        assertTrue(output.contains("[1, 2, 3, 8, 9, 10]"));
        assertTrue(output.contains("[4, 5, 6, 11, 12, 13]"));
        assertTrue(output.contains("[1, 2, 3, 4, 5, 6]"));
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

    @Test
    void 수익률_출력_테스트() {
        // given
        BigDecimal profit = new BigDecimal(1000000.0);

        // when
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        outputView.printProfit(profit);

        //then
        String output = outputStream.toString();
        assertTrue(output.contains("총 수익률은 1,000,000.0%입니다."));
    }
}
