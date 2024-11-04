package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int buyingAmount = InputHandler.getBuyingAmount();
        List<Lotto> lottos = LottoGenerator.getLotto(buyingAmount);
        System.out.println(buyingAmount + "개를 구매했습니다.");
        lottos.forEach(System.out::println);

        System.out.println("당첨 번호를 입력해주세요.");
        List<Integer> winningNumber = InputHandler.getWinningNumber();

        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNumber = InputHandler.getBonusNumber();
    }
}
