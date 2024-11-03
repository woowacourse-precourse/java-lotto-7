package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int getLottoMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> getWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        //TODO: 메서드 분리하기
        List<Integer> numbers = new ArrayList<>();
        for (String number : winningNumbers.split(",")) {
            numbers.add(Integer.parseInt(number.trim()));
        }
        return numbers;
    }

    public static int getBousNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
