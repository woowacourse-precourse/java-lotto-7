package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private InputView() {

    }

    public static int readLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> readWinningLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요,");
        return List.of(Console.readLine().split(","))
                .stream()
                .map(Integer::parseInt)
                .toList();
    }

    public static int readLottoBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
