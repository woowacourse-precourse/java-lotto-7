package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.Winning;
import lotto.repository.LottoRepository;
import lotto.util.Utils;

public class OutputView {
    private static OutputView outputView;

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void printGuide() {
        System.out.println(Utils.Purchase_AMOUNT);
    }

    public void printCount(Integer count) {
        System.out.println();
        System.out.println(count + Utils.Purchase_LOTTO_COUNT);
    }

    public void printLottoNumber() {
        LottoRepository.lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printWinningNumber() {
        System.out.println();
        System.out.println(Utils.WINNING_NUMBER);
    }

    public void printBonus() {
        System.out.println();
        System.out.println(Utils.PRINT_BONUS);
    }

    public void printWinning(List<Winning> winnings) {
        System.out.println();
        System.out.println(Utils.PRINT_WINNING);
        Arrays.stream(Winning.values())
                .filter(winning -> winning != Winning.NOT) // NOT 제외
                .forEach(winning -> {
                    System.out.print(winning.getMessage());
                    long count = winnings.stream().filter(e -> e == winning).count();
                    System.out.println(count);
                    LottoRepository.revenue += winning.getPrizeMoney() * count;
                });
    }

    public void printRevenue(Double revenue) {
        System.out.println("총 수익률은 " + String.format("%.1f", revenue) + "%입니다.");
    }
}
