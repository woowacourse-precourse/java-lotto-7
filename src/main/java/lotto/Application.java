package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        String inputPrice;
        while (true){
            System.out.println("구입금액을 입력해 주세요.");
            inputPrice = Console.readLine();
            try{
                Validation.validatePrice(inputPrice);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        int quantity = Integer.parseInt(inputPrice) / 1000;

        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.createLotto(quantity);

        String inputWinningNumbers;
        String[] splitWinningNumbers;
        while (true){
            System.out.println("\n당첨 번호를 입력해 주세요.");
            inputWinningNumbers = Console.readLine();
            try{
                splitWinningNumbers = inputWinningNumbers.split(",");
                Validation.validateWinningNumbers(splitWinningNumbers);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

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

        List<Integer> winningNumbers = new ArrayList<>();
        for (String splitWinningNumber : splitWinningNumbers)
            winningNumbers.add(Integer.parseInt(splitWinningNumber));
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        Map<LottoRank, Integer> rankCounts = lottoMachine.getRankCounts(lottos, winningNumbers, bonusNumber);
        List<String> winningStatistics = lottoMachine.getWinningStatistics(rankCounts);
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (String statistic : winningStatistics)
            System.out.println(statistic);
    }
}
