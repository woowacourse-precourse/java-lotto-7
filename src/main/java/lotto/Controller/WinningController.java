package lotto.Controller;

import lotto.Lotto;
import lotto.LottoResult;
import lotto.Pair;
import lotto.Service.WinningService;
import lotto.View.BonusView;
import lotto.View.StatisticsView;
import lotto.View.WinningView;

import java.util.ArrayList;
import java.util.List;

public class WinningController {
    WinningView winningView;
    BonusView bonusView;
    StatisticsView statisticsView;
    WinningService winningService;
    List<Lotto> lottos;

    public WinningController() {
        winningView = new WinningView();
        bonusView = new BonusView();
        statisticsView = new StatisticsView();
        winningService = new WinningService();
    }

    public void getWinning(List<Lotto> lottos) {
        this.lottos = lottos;

        List<Integer> winningNumbers = getWinningInput();
        int bonusNumber = getBonusInput(winningNumbers);
        int[] result = winningService.getResult(lottos, winningNumbers, bonusNumber);
        double returnRate = winningService.getReturnRate(result, lottos.size());
        statisticsView.print(result, returnRate);
    }

    private List<Integer> getWinningInput() {
        boolean validated = false;
        List<Integer> winningNumbers = new ArrayList<>();
        while(!validated) {
            try {
                String input = winningView.getInput();
                Pair validatedResult = validateWinningInput(input);
                validated = validatedResult.getBoolean();
                winningNumbers = (List<Integer>)validatedResult.getValue();
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumbers;
    }

    private int getBonusInput(List<Integer> winningNumbers) {
        boolean validated = false;
        int bonusNumber = 0;
        while(!validated) {
            try {
                String input = bonusView.getInput();
                Pair validatedResult = validateBonusInput(input, winningNumbers);
                validated = validatedResult.getBoolean();
                bonusNumber = (int)validatedResult.getValue();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    public Pair validateWinningInput(String input) {
        String[] split = input.split(",");
        List<Integer> winningNumbers = new ArrayList<Integer>();
        if(split.length != 6)
            throw new IllegalArgumentException("당첨 번호는 6개를 입력해야 합니다.");
        for(int i = 0; i < split.length; i++) {
            if(!Validate.isInteger(split[i])) throw new IllegalArgumentException("정수를 입력해 주세요.");
            if(Integer.parseInt(split[i]) < 0 || Integer.parseInt(split[i]) > 45) throw new IllegalArgumentException("당첨 번호는 1이상 45이하의 범위에서만 가능합니다.");
            if(winningNumbers.contains(Integer.parseInt(split[i]))) throw new IllegalArgumentException("당첨 번호는 겹칠 수 없습니다.");

            winningNumbers.add(Integer.parseInt(split[i]));
        }
        return new Pair(true, winningNumbers);
    }

    public Pair validateBonusInput(String input, List<Integer> winningNumbers) {
        if(!Validate.isInteger(input)) throw new IllegalArgumentException("정수를 입력해 주세요");
        if(Integer.parseInt(input) < 0) throw new IllegalArgumentException("보너스 번호는 0보다 작을 수 없습니다.");
        if(Integer.parseInt(input) > 45) throw new IllegalArgumentException("보너스 번호는 45보다 클 수 없습니다.");
        if(winningNumbers.contains(Integer.parseInt(input))) throw new IllegalArgumentException("보너스 번호는 당첨번호와 겹칠 수 없습니다.");

        return new Pair(true, Integer.parseInt(input));
    }
}