package lotto.service;

import lotto.enumValue.CommonMessage;
import lotto.enumValue.Number;
import lotto.enumValue.ResultMessage;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.WinningNumber;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProcessServiceTest {
    private final int ONE = 1;
    private final int TICKETS = 3;
    private final int BONUS_NUMBER = 7;
    private final String ANSWER = "1050166.7";

    private final ProcessService processService = new ProcessService();

    @Test
    void 수익률_계산_테스트() {
        Result result = new Result();
        result.setResult(Number.FIFTH.getValue());
        result.setResult(Number.THIRD.getValue());
        result.setResult(Number.SECOND.getValue());

        String announce = processService.calculateRate(TICKETS, result);

        assertTrue(announce.contains(ANSWER), CommonMessage.FAIL.getMessange());
    }

    @Test
    void 티켓별_당첨_결과_저장_테스트() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), BONUS_NUMBER);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        Result result = processService.matchNumber(lottos, winningNumber);

        List<String> answer = Arrays.asList(ResultMessage.FIFTH.getDescription()+Number.ZERO.getValue(),
                ResultMessage.THIRD.getDescription()+Number.ZERO.getValue(),
                ResultMessage.FIRST.getDescription()+Number.ZERO.getValue(),
                ResultMessage.FOURTH.getDescription()+ONE,
                ResultMessage.SECOND.getDescription()+ONE);

        assertThat(result.toString()).contains(answer);
    }

}
