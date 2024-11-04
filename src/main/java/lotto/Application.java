package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());

        System.out.println(purchaseAmount / 1000 + "개를 구매했습니다.");
        // TODO: 로또 번호 출력

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = Arrays.stream(Console.readLine().split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

        System.out.println("당첨 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        System.out.println("당첨 통계\n---\n");
        // TODO: 당첨 갯수 출력

        System.out.println("총 수익률은 " + null + "%입니다.");
        Console.close();
    }
}
