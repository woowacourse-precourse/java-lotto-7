package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    private LottoGame lottoGame;
    private WinningNumbers winningNumbers;
    private List<Lotto> tickets = new ArrayList<>();


    @BeforeEach
    public void setUp() {
        tickets.add(new Lotto(List.of(1, 2, 3, 8, 9, 10))); // 3개 일치
        tickets.add(new Lotto(List.of(10, 11, 12, 13, 14, 15))); // 0개 일치

        System.out.println(tickets);

        winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        lottoGame = new LottoGame(tickets, winningNumbers);
    }

    @Test
    public void testCalculateResults_WithThreeMatches() {

        lottoGame.calculateResults();

        // 3개 일치의 당첨 횟수 확인
        assertEquals(1, lottoGame.getMatchResults().get(MatchResult.THREE_MATCH)); // MatchResult.THREE_MATCH는 enum 값으로 정의되어야 함
    }

    @Test
    public void testCalculateYield() {
        // 구매 금액 예시 (14,000원)으로 수익률 계산
        lottoGame.calculateResults(); // 3개 일치

        double yield = lottoGame.calculateYield(8_000);
        assertEquals(62.5, yield, 0.001); // 예시 값으로, 이 값은 실제 테스트에 따라 조정 필요
    }
}