package lotto.controller;

import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.service.WinService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class WinController {
    private final WinService winService;

    public WinController(WinService winService) {
        this.winService = winService;
    }

    public void win(Money money){
        List<Integer> winNumbers = getWinNumbers();
        System.out.println();
        int bonus = getBonusNumbers(winNumbers);
        System.out.println();

        Map<Rank, Integer> result = winService.win(winNumbers, bonus);
        double profit = winService.getProfit(money);

        OutputView.printResult(result, profit);
    }
    public List<Integer> getWinNumbers(){
        while(true){
            try{
                List<Integer> winNumbers = InputView.getLotto();
                validateDuplicate(winNumbers);
                return winNumbers;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public int getBonusNumbers(List<Integer> winNumbers){
        while(true){
            try{
                int bonus = InputView.getBonusNumber();
                validateDuplicateBonus(winNumbers, bonus);
                return bonus;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateDuplicateBonus(List<Integer> numbers, int bonus){
        if (numbers.contains(bonus)){
            throw new IllegalArgumentException("[ERROR]: 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        if (numbers.stream().distinct().count() != 6){
            throw new IllegalArgumentException("[ERROR] 중복된 번호는 입력할 수 없습니다.");
        }
    }
}
