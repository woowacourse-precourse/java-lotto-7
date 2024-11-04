package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int price;
        List<Integer> winningNumbers;
        int bonusNumber;
        LottoPublish lottoPublish;
        Lotto lotto;

        // 금액 입력받기
        while(true) {
            try {
                System.out.print("금액을 입력하세요: ");
                price = Integer.parseInt(Console.readLine());
                System.out.println("입력한 금액: " + price);

                // 입력한 금액 유효성검사 후 구매한 로또 개수반환
                lottoPublish = new LottoPublish(price);
                break;
            }catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // 당첨번호 6개, 보너스번호 입력받기
        while(true) {
            try{
                System.out.print("당첨번호 6개를 입력하세요(,키로 구분됩니다)");
                String inputNumbers = Console.readLine();
                winningNumbers = Arrays.stream(inputNumbers.split(","))
                        .map(Integer::parseInt)
                        .toList();
                System.out.printf("입력한 당첨번호: %s%n", winningNumbers);

                System.out.print("보너스 번호 1개를 입력하세요: ");
                bonusNumber = Integer.parseInt(Console.readLine());
                System.out.println("입력한 보너스 번호: " + bonusNumber);

                // 당첨번호, 보너스번호 입력후 당첨금 반환
                lotto = new Lotto(winningNumbers, bonusNumber);

                break;
            }catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }

        int reward = lottoPublish.getCount()*lotto.getReward();
        System.out.println("당첨금액은: " + reward);
        System.out.println("수익률은: " + ( (reward-price)/price  )*100 + "%");
    }
}