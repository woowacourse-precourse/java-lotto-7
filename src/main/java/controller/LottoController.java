package controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import module.*;
import java.util.List;

public class LottoController {

    public void executeLottoDraw() {

        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());

        PurchaseLotto purchaseLotto = new PurchaseLotto();
        List<Lotto> lottos = purchaseLotto.purchase(money);

        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for(Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        LottoDraw lottoDraw = new LottoDraw();

        List<Integer> winningNumbers = lottoDraw.DrawNumbers(Console.readLine());

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = lottoDraw.DrawBonusNumber(Console.readLine(), winningNumbers);

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        Rank.printResults(lottos, winningNumbers, bonusNumber);
    }
}
