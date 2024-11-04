package Model;

import Constant.Constant;
import View.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoCheck {
    private static List<Lotto> buyLottos;
    private static List<Integer> winningNumbers;
    private static Integer bonusNumber;
    private static Integer bounsWinCount = 0;

    public LottoCheck(List<Lotto> givenbuyLottos, List<Integer> givenwinningNumbers, Integer givenbonusNumber) {
        buyLottos = givenbuyLottos;
        winningNumbers = givenwinningNumbers;
        bonusNumber = givenbonusNumber;
    }

    private static List<Integer> checkWinning() {
        List<Integer> counts = new ArrayList<>();
        for(Lotto buyNumber : buyLottos) {
            int count = 0;
            List<Integer> buyNumbers = buyNumber.getNumbers();

            for(Integer number : winningNumbers) {
                if(buyNumbers.contains(number)) {
                    count++;
                }
            }
            if(count == 5 && buyNumbers.contains(bonusNumber)) {
                bounsWinCount++;
            }
            counts.add(count);
        }
        return counts;
    }
    public static void checkWinningCounts() {
        List<Integer> counts = checkWinning();
        Integer winCount = 0;
        Integer winningAmount = 0;
        winCount = Integer.parseInt(String.valueOf(counts.stream().filter(x -> x == 3).count()));
        winningAmount = winCount * 5_000;
        System.out.println(String.format("3개 일치 (5,000원) - %d개", winCount));

        winCount = Integer.parseInt(String.valueOf(counts.stream().filter(x -> x == 4).count()));
        winningAmount = winCount * 50_000;
        System.out.println(String.format("4개 일치 (50,000원) - %d개", winCount));

        winCount = Integer.parseInt(String.valueOf(counts.stream().filter(x -> x == 5).count()));
        winningAmount = winCount * 1_500_000;
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", winCount));

        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", bounsWinCount));

        winCount = Integer.parseInt(String.valueOf(counts.stream().filter(x -> x == 6).count()));
        winningAmount += winCount * 2_000_000_000;
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", winCount));

        System.out.println(String.format("총 수익률은 %.1f%%입니다.", (double) winningAmount / InputView.purchaseAmount));
    }
}


