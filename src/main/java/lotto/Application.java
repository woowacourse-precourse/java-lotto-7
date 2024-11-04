package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyText = Console.readLine();
        long purchaseAmount = Money.buy(moneyText); // String 변수 moneyText를 long형으로 변환 및 유효성 검사

        LottoGame lottoGame =new LottoGame(purchaseAmount);

        System.out.println("당첨 번호를 입력해 주세요.");
        String lottoText = Console.readLine();
        List<Integer> winningNumbers = LottoText.ParseIntegerList(lottoText);
        lottoGame.setWinningLotto(winningNumbers);


        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusText = Console.readLine();
        Bonus bonus = new Bonus(bonusText);
        lottoGame.setBonusNumber(bonus.getBonus());

        lottoGame.calculateResults();

    }
}
