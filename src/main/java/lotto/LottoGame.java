package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    //로또 생성, 당첨 번호와 비교 후 결과 계산
    private final List<Lotto> tickets = new ArrayList<>();

    public void purchaseTickets(int amount){
        int ticketCount = amount / 1000;
        for (int i =0; i< ticketCount; i++){
            tickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)));
        }
    }

    public List<Lotto> getTickets(){
        return tickets;
    }

    public int calculateProfit(WinningNumbers winningNumbers){
        return tickets.stream()
                .mapToInt(ticket ->Rank.valueOf(
                        winningNumbers.countMatchingNumbers(ticket.getNumbers()),
                        ticket.getNumbers().contains(winningNumbers.getBonusNumber()))
                        .getPrize()).sum();
    }
}
