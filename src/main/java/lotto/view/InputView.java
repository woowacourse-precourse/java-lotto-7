package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static int getPurchaseAmount(){
        System.out.println("구입 금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static WinningLotto getWinningLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");

        List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("보너스 번호를 입력해주세요.");

        int bonusNumber = Integer.parseInt(Console.readLine());
        return new WinningLotto(winningNumbers,bonusNumber);
    }
}
