package lotto.view;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.util.Arrays.stream;

public class InputView {

    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(readLine());
    }

    public int[] getWinningNum() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Arrays.stream(readLine().split(",")).mapToInt(Integer::parseInt).toArray();
    }

    // TODO: 보너스 번호 입력받기
    public int getBonusNum() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Integer.parseInt(readLine());
    }
}


