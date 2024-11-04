package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        int n = money / 1000;

        Lotto lotto = new Lotto();
        ArrayList<Lotto> lottos = new ArrayList<>(lotto.number_generator(n));
        System.out.println("\n" + n + "개를 구매했습니다.");
        for (Lotto arr : lottos) {
            arr.number_print();
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input_winningNum = Console.readLine();
        Lotto winnig_numbers = new Lotto(
                Arrays.stream(input_winningNum.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );

        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input_bonusNum = Console.readLine();
        int bonus_Num = Integer.parseInt(input_bonusNum);
        int bonus_cnt = 0;

        ArrayList<Integer> Winning_Details = new ArrayList<>(Collections.nCopies(6, 0));
        int Sum_prize = 0;
        for (Lotto arr : lottos) {
            int match = arr.number_matching(winnig_numbers);
            if (match == 5) {
                if (arr.bonus_matching(bonus_Num)) {
                    bonus_cnt++;
                    continue;
                }
            }
            if (match > 2) {
                Winning_Details.set(match - 1, Winning_Details.get(match - 1) + 1);
            }
        }

        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + Winning_Details.get(2) + "개");
        Sum_prize +=(Winning_Details.get(2) * 5000);
        System.out.println("4개 일치 (50,000원) - " + Winning_Details.get(3) + "개");
        Sum_prize += (Winning_Details.get(3) * 50000);
        System.out.println("5개 일치 (1,500,000원) - " + Winning_Details.get(4) + "개");
        Sum_prize += (Winning_Details.get(4) * 150000);
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + bonus_cnt + "개");
        Sum_prize += (bonus_cnt * 30000000);
        System.out.println("6개 일치 (2,000,000,000원) - " + Winning_Details.get(5) + "개");
        Sum_prize += (Winning_Details.get(5) * 2000000000);

        double profit_rate = (double) Sum_prize / (double) money * 100;
        profit_rate = Math.round(profit_rate * 100.0) / 100.0;
        System.out.println("총 수익률은 "+profit_rate +"%입니다.");

    }
}

