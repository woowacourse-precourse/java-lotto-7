package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class InputView {
    public static int buyLotto() {
        System.out.println("구입 금액을 입력해 주세요.");
        int totalLotto = Integer.parseInt(Console.readLine());
        if (totalLotto % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
        }
        return totalLotto;
    }

    public static Lotto enterWinNum() {
        List<Integer> winLottoNumbers = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            splitByComma(input, winLottoNumbers);
            return new Lotto(winLottoNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 포함해야 합니다.");
        }
    }

    private static void splitByComma(String input, List<Integer> lottoNumbers) {
        for (String numStr : input.split(",")) {
            int numbers = Integer.parseInt(numStr.trim());
            lottoNumbers.add(numbers);
        }
    }

    public static int enterBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            int bonusNum = Integer.parseInt(Console.readLine());
            rangeCheck(bonusNum);
            return bonusNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로 입력해 주세요.");
        }
    }

    private static void rangeCheck(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
