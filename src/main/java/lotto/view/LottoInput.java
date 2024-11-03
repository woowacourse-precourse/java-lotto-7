package lotto.view;

import camp.nextstep.edu.missionutils.*;

import java.util.Arrays;
import java.util.List;

public class LottoInput {
    public static String inputCost() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static List<String> inputCorrectNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Arrays.stream(Console.readLine().split(",")).toList();
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
