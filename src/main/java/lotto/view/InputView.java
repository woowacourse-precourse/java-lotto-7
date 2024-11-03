package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;


public class InputView {
    public static int inputAmount() {
        int amount;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                amount = parseInt(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return amount;
    }
    private static int parseInt(String input) {
        try {
            int value = Integer.parseInt(input);
            if (value <= 0) {
                throw new IllegalArgumentException("[ERROR] 0 이상의 숫자를 입력해 주세요.");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }
    public static Lotto inputPrize() {
        ArrayList<Integer> numbers;
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                numbers = splitNum(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return new Lotto(numbers);
    }
    private static ArrayList<Integer> splitNum(String input){
        String[] splitInput = input.split(",");
        ArrayList<Integer> intList = new ArrayList<>();
        for (String i : splitInput){
            int parseI = parseInt(i.trim());
            if (parseI < 1 || parseI > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1과 45 사이의 숫자로 입력해주세요.");
            }
            intList.add(parseI);
        }
        return intList;
    }
    public static int inputBonus() {
        int bonus;
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                bonus = parseInt(Console.readLine());
                if (bonus < 1 || bonus > 45) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1과 45 사이의 숫자로 입력해주세요.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonus;
    }

}