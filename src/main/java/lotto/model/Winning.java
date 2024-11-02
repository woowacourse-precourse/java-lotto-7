package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.dto.WinningNumbersDto;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.WinningResultDto;
import lotto.dto.WinningResultsDto;

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
        Collections.sort(winningNumbers);
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
        int winningBonusNumber;
        do {
            winningBonusNumber = Randoms.pickNumberInRange(1, 45);
        } while (winningNumbers.contains(winningBonusNumber));

        return winningBonusNumber;
    }

    private WinningResultsDto compareNumbers(List<Integer> userNumbers, Integer userBonusNumber){
        List<WinningResultDto> winningResultDtos = new ArrayList<>();

        for(WinningNumbersDto winningNumbers : winningTickets.values()){
            List<Integer> winningNumber = winningNumbers.getWinningNumber();

            Integer correctCount = compareEachNumbers(winningNumber, userNumbers);
            boolean isCorrectBonus = compareBonusNumber(winningNumbers.getWinningBonusNumber(), userBonusNumber);

            WinningResultDto winningResult = new WinningResultDto(correctCount, isCorrectBonus);
            winningResultDtos.add(winningResult);
        }

        return new WinningResultsDto(winningResultDtos);
    }

    private Integer compareEachNumbers(List<Integer> winningTicketNumbers, List<Integer> userNumbers){
        Integer correctValue = 0;
        for(Integer userNumber : userNumbers){
            boolean contains = winningTicketNumbers.contains(userNumber);
            if(contains){
                ++correctValue;
            }
        }
        return correctValue;
    }

    private boolean compareBonusNumber(Integer winningBonusNumber, Integer userBonusNumber){
        return winningBonusNumber.equals(userBonusNumber);
    }
}
