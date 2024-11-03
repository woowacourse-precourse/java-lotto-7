package lotto.view;

import lotto.Lotto;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = readLine();
        try{
            Integer.parseInt(money);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
        int amount = Integer.parseInt(money);
        if (amount%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해주세요.");
        }
        return amount;
    }

    public Lotto getWinningNum() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        try{
            List<Integer> winningNumber = Arrays.stream(readLine().split(",")).mapToInt(Integer::parseInt).boxed().toList();
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
        List<Integer> winningNumber = Arrays.stream(readLine().split(",")).mapToInt(Integer::parseInt).boxed().toList();
        Lotto winningNum = new Lotto(winningNumber);
        return winningNum;
    }

    public int getBonusNum() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Integer.parseInt(readLine());
    }
}


