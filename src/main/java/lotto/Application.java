package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final int cost = Input.getCost();
        LottoPaper lottoPaper = LottoPaperGenerator.createLottoPaper(cost);
        Output.printLottoPaper(lottoPaper.getValues());

        final List<Integer> winNumbers = Input.getWinNumbers();
        final int bonus = Input.getBonusNumber(winNumbers);

        lottoPaper.searchAll(winNumbers, bonus);

        Output.printWinningList(cost);
    }
}
