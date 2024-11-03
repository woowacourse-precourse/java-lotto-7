package lotto.view;

import java.util.Arrays;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(readLine());
    }

    public int[] getWinningNum() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        int[] winningNum = Arrays.stream(readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        return winningNum;
    }

    public int getBonusNum() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Integer.parseInt(readLine());
    }
}


