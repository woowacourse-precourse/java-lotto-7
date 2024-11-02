package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.dto.WinningNumbersDto;
import camp.nextstep.edu.missionutils.Randoms;

public class Winning {
    private final Map<Integer, WinningNumbersDto> winningTickets = new HashMap<>();

    public Winning(int userPurchaseCount) {
        makeWinningTickets(userPurchaseCount);
    }

    public Map<Integer, WinningNumbersDto> getWinningTickets() {
        return winningTickets;
    }

    private WinningNumbersDto makeWinningNumbers(){
        List<Integer> winningNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        int winning =getWinningBonusNumber(winningNumbers);
        return new WinningNumbersDto(winningNumbers, winning);
    }

    private void makeWinningTickets(Integer userPurchaseCount){
        for(int i = 0; i < userPurchaseCount; i++){
            WinningNumbersDto winningNumbersDto = makeWinningNumbers();
            winningTickets.put(i+1 , winningNumbersDto);
        }
    }

    private Integer getWinningBonusNumber(List<Integer> winningNumbers){
        int winningBonusNumber = 0;
        do {
            winningBonusNumber = Randoms.pickNumberInRange(1, 45);
        } while (winningNumbers.contains(winningBonusNumber));

        return winningBonusNumber;
    }
}
