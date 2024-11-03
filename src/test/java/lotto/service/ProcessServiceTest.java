package lotto.service;

import lotto.enumValue.CommonMessage;
import lotto.enumValue.Number;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoWinningNumber;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProcessServiceTest {
    private final int TICKETS = 3;
    private final int BONUS_NUMBER = 7;
    private final String ANSWER = "1050166.7";

    private final ProcessService processService = new ProcessService();

    @Test
    void 수익률_계산_테스트() {
        LottoResult result = new LottoResult();
        result.setResult(Number.FIFTH.getValue());
        result.setResult(Number.THIRD.getValue());
        result.setResult(Number.SECOND.getValue());

        String announce = processService.calculateRate(TICKETS, result);

        assertTrue(announce.contains(ANSWER), CommonMessage.FAIL.getMessange());
    }

    @Test
    void 티켓별_당첨_결과_저장_테스트() {
        LottoWinningNumber winningNumber = new LottoWinningNumber(List.of(1, 2, 3, 4, 5, 6), BONUS_NUMBER);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        LottoResult result = processService.matchNumber(lottos, winningNumber);

        assertTrue(result.toString().contains("3개 일치 (5,000원) - 0개" + CommonMessage.NEW_LINE.getMessange() +
                "4개 일치 (50,000원) - 1개" + CommonMessage.NEW_LINE.getMessange() +
                "5개 일치 (1,500,000원) - 0개" + CommonMessage.NEW_LINE.getMessange() +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개" + CommonMessage.NEW_LINE.getMessange() +
                "6개 일치 (2,000,000,000원) - 0개"), CommonMessage.FAIL.getMessange());
    }

}
