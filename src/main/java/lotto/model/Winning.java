package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.dto.WinningNumbersDto;
import camp.nextstep.edu.missionutils.Randoms;

public class Winning {
    private Map<Integer, WinningNumbersDto> winningTickets = new HashMap<>();

    public Winning(Map<Integer, WinningNumbersDto> winningTickets) {
        this.winningTickets = winningTickets;
    }

    public Map<Integer, WinningNumbersDto> getWinningTickets() {
        return winningTickets;
    }

    private WinningNumbersDto makeWinningNumbers(){
        List<Integer> winningNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        int winning = Randoms.pickNumberInRange(1, 45);
        return new WinningNumbersDto(winningNumbers, winning);
    }

    private void makeWinningTickets(Integer userPurchaseCount){
        for(int i = 0; i < userPurchaseCount; i++){
            WinningNumbersDto winningNumbersDto = makeWinningNumbers();
            winningTickets.put(i+1 , winningNumbersDto);
        }
    }
}
