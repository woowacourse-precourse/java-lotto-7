package console;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputService {

    private int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());

        return money;
    }

    private int convertQuantity(int money) {
        int quantity = 0;

        if (money >= 1000) {
            quantity = money / 1000;
        }
        return quantity;
    }

    public int lottoQuantityInput() {
        return convertQuantity(getMoney());
    }

    private String getWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    private String[] splitWinNumbers(String winNumbers) {
        String[] splitWinNumbers = winNumbers.split(",");

        return splitWinNumbers;
    }

    private List<Integer> convertWinNumbers(String[] splitWinNumbers) {
        List<Integer> convertToInteger = new ArrayList<>();

        for (String splitWinNumber : splitWinNumbers) {
            convertToInteger.add(Integer.parseInt(splitWinNumber));
        }

        return convertToInteger;
    }

    public List<Integer> winNumbersInput() {
        return convertWinNumbers(splitWinNumbers(getWinNumbers()));
    }
}
