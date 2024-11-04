package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoMachineController {
    private final LottoMachine lottoMachine = new LottoMachine();

    public int handleInputPrice(){
        String inputPrice;
        while (true){
            System.out.println("구입금액을 입력해 주세요.");
            inputPrice = Console.readLine();
            try{
                Validation.validatePrice(inputPrice);
                break;
            }catch (IllegalArgumentException e){System.out.println(e.getMessage());}
        }
        return Integer.parseInt(inputPrice);
    }

    public List<Lotto> getLotto(int price) {
        int quantity = price / 1000;
        return lottoMachine.createLotto(quantity);
    }

    public List<Integer> handleInputWinningNumbers() {
        String[] splitWinningNumbers;
        while (true){
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String inputWinningNumbers = Console.readLine();
            try{
                splitWinningNumbers = inputWinningNumbers.split(",");
                Validation.validateWinningNumbers(splitWinningNumbers);
                break;
            }catch (IllegalArgumentException e){System.out.println(e.getMessage());}
        }
        List<Integer> winningNumbers = new ArrayList<>();
        for (String splitWinningNumber : splitWinningNumbers)
            winningNumbers.add(Integer.parseInt(splitWinningNumber));
        return winningNumbers;
    }

    public int handleInputBonusNumber() {
        String inputBonusNumber;
        while (true){
            System.out.println("\n보너스 번호를 입력해 주세요.");
            inputBonusNumber = Console.readLine();
            try{
                Validation.validateBonusNumbers(inputBonusNumber);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(inputBonusNumber);
    }

    public void printWinningStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber, int price){
        Map<LottoRank, Integer> rankCounts = lottoMachine.getRankCounts(lottos, winningNumbers, bonusNumber);

        List<String> winningStatistics = lottoMachine.getWinningStatistics(rankCounts);
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (String statistic : winningStatistics)
            System.out.println(statistic);

        double returnRate = lottoMachine.calculateReturnRate(rankCounts, price);
        System.out.printf("총 수익률은 %,.1f%%입니다.", returnRate);
    }
}
