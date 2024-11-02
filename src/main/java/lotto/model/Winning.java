package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.dto.WinningNumbersDto;
import camp.nextstep.edu.missionutils.Randoms;

public class Winning {
    private Map<Integer, List<WinningNumbersDto>> winningTickets = new HashMap<>();

    public Winning(Map<Integer, List<WinningNumbersDto>> winningTickets) {
        this.winningTickets = winningTickets;
    }

    public Map<Integer, List<WinningNumbersDto>> getWinningTickets() {
        return winningTickets;
    }

    private void makeWinningNumbers(){
        List<Integer> winningNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        int winning = Randoms.pickNumberInRange(1, 45);
        WinningNumbersDto winningNumbersDto = new WinningNumbersDto(winningNumbers, winning);
    }
}
