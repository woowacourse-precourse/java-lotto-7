package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatusTest {
    @DisplayName("기능 테스트: 로또 번호 일치 개수 생성 확인")
    @Test
    void check_hits_status() {
        Tickets tickets = new Tickets(10000);
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        Lotto lottoNumbers = new Lotto(winningNumbers);
        Jackpot jackpot = new Jackpot(lottoNumbers, 7);

        Status status = new Status();
        status.checkNumbersHit(tickets, jackpot);
        status.checkBonusHit(tickets, jackpot);

        List<Integer> numbersHit = status.getNumbersHit();
        List<Boolean> bonusHit = status.getBonusHit();

        assertEquals(numbersHit.size(), bonusHit.size());
    }
}