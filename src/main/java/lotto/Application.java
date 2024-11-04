package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = null;
        while (true){
            try{
                System.out.println("구입금액을 입력해 주세요.");
                String moneyText = Console.readLine();
                long purchaseAmount = Money.buy(moneyText); // String 변수 moneyText를 long형으로 변환 및 유효성 검사

                lottoGame =new LottoGame(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }

        List<Integer> winningNumbers = null;
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String lottoText = Console.readLine();
                winningNumbers = LottoText.ParseIntegerList(lottoText);
                lottoGame.setWinningLotto(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }

        while (true){
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String bonusText = Console.readLine();
                Bonus bonus = new Bonus(bonusText);
                lottoGame.setBonusNumber(bonus.getBonus());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }


        lottoGame.calculateResults();
    }
}
