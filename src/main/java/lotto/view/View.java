package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class View {
    public String getMoneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public void printLotties(List<List<Integer>> lotties) {
        System.out.println(lotties.size()+"개를 구매했습니다.");
        for (List<Integer> lotto : lotties) {
            System.out.println(lotto.toString());
        }
    }

}
