package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String lottoPurchaseAmount = Console.readLine();

        try {
            int purchasePrice = Integer.parseInt(lottoPurchaseAmount);
            List<List<Integer>> lottoTickets = Lotto.createLottoTickets(purchasePrice);
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String inputWinningNumbers = Console.readLine();
            List<Integer> winningNumbers = Lotto.convertWinningNumbers(inputWinningNumbers);

            System.out.println("\n보너스 번호를 입력해 주세요.");
            String intputBonusNumber = Console.readLine();
            int bonusNumber = Integer.parseInt(intputBonusNumber);


            // 당첨 통계 계산 및 출력
            Lotto lotto = new Lotto(winningNumbers);
            lotto.printWinningStatistics(lottoTickets, winningNumbers, bonusNumber);

            // 전체 상금 계산 및 수익률 출력
            int totalPrize = lotto.calculateTotalPrize(lottoTickets, winningNumbers, bonusNumber);
            double yield = Lotto.calculateYield(purchasePrice, totalPrize);
            System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);

        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자 형식이 잘못되었습니다.");
            return; // 프로그램을 종료하거나 다른 처리를 추가할 수 있습니다.
        }



    }

}
