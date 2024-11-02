package lotto.custom.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinningCheckerTest {
    private LottoWinningChecker lottoWinningChecker = new LottoWinningChecker();

    @DisplayName("모델_로또결과분석기_5개일치_보너스번호불일치_테스트")
    @Test
    void 모델_로또결과분석기_5개일치_보너스번호불일치_테스트() {
        Lottos myLottoTickets = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)),
                new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11))
        ));

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        List<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

        lottoWinningChecker.run(myLottoTickets, winningNumbers, bonusNumber, result);

        assertEquals(0, result.get(0));
        assertEquals(0, result.get(1));
        assertEquals(1, result.get(2));
        assertEquals(0, result.get(3));
        assertEquals(0, result.get(4));
    }

    @DisplayName("모델_로또결과분석기_5개일치_보너스번호일치_테스트")
    @Test
    void 모델_로또결과분석기_5개일치_보너스번호일치_테스트() {
        Lottos myLottoTickets = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))
        ));

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        List<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

        lottoWinningChecker.run(myLottoTickets, winningNumbers, bonusNumber, result);

        assertEquals(0, result.get(0));
        assertEquals(0, result.get(1));
        assertEquals(0, result.get(2));
        assertEquals(1, result.get(3));
        assertEquals(0, result.get(4));
    }

    @DisplayName("모델_로또결과분석기_당첨한로또가없을때_테스트")
    @Test
    void 모델_로또결과분석기_당첨한로또가없을때_테스트() {
        Lottos myLottoTickets = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15)) // 당첨 번호와 완전히 다른 티켓
        ));

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        List<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

        lottoWinningChecker.run(myLottoTickets, winningNumbers, bonusNumber, result);

        assertEquals(0, result.get(0)); // 3등
        assertEquals(0, result.get(1)); // 4등
        assertEquals(0, result.get(2)); // 5등
        assertEquals(0, result.get(3)); // 6등
        assertEquals(0, result.get(4)); // 1등
    }
}