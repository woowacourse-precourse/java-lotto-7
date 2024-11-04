package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public int getPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        return amount;
    }

    public static List<Integer> inputWinNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] numbers = input.split(",");

        List<Integer> winNumbers = new ArrayList<>();
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            winNumbers.add(num);
        }
        return winNumbers;
    }
}
