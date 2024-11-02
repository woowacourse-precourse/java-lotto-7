package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();

        System.out.println("로또 구입 금액을 입력해주세요.");
        int amount = Integer.parseInt(Console.readLine());
        game.BuyLotto(amount);

        System.out.println("당첨 번호를 입력해주세요.");
        List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNumbers = Integer.parseInt(Console.readLine());

        game.UpdateWinnings(winningNumbers, bonusNumbers);
        game.PrintWinnings();
        game.CalculateEarningsRate(amount);
    }
}
