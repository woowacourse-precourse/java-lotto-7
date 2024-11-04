package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class InputView {

    public int readMoney() {
        int money;
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String userInput = Console.readLine();
            Console.close();
            try {
                money = parseInteger(userInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;  // 유효한 금액을 반환
    }
    public List<Integer> readWiningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput=Console.readLine();
        Console.close();
        try {
            List<Integer> numbers=Arrays.stream(userInput.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.");
        }

    }

    public int readBonusNumbers() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInput=Console.readLine();
        Console.close();
        return parseInteger(userInput);
    }

    private int parseInteger(String string){
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("[ERROR] 값이 입력되지 않았습니다.");
        }

    }
}
