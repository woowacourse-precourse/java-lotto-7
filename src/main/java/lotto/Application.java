package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        int money = input.getMoney();
        System.out.println();

        int count = money / 1000;
        System.out.println(count + "개를 구매했습니다.");
        List<Lotto> lottos = LottoManager.createLottos(count);
        System.out.println();

        List<Integer> winningNumbers = input.getWinningNumbers();
        System.out.println();

        int bonus = input.getBonus();

        ResultManager resultManager = new ResultManager(winningNumbers, bonus);
        double profit = resultManager.analyzeResult(lottos);

        Stats.printStats(money, profit);
    }
}
