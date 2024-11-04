package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
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
        int input_bonusNum = Integer.parseInt(Console.readLine());

    }
}

