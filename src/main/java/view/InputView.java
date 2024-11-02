package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public int inputLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int LottoPurchaseAmount = Integer.parseInt(Console.readLine());

        return LottoPurchaseAmount;
    }

    public List<Integer> inputWinnerLottoNumbers() {
        System.out.println("\n당첨 번호를 입력해주세요.");
        String input = Console.readLine();

        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
