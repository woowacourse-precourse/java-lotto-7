package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            return Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해 주세요.");
        }
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        try {
            return Arrays.stream(Console.readLine().split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해 주세요.");
        }
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해 주세요.");
        }
    }
}
