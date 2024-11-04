package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public static int purchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String text = Console.readLine();
        System.out.println();
        return getNumber(text);
    }

    public static List<Integer> winNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String text = Console.readLine();
        List<Integer> numbers = new ArrayList<>();
        for (String s : text.split(",")) {
            int number = getNumber(s);
            numbers.add(number);
        }
        Lotto lotto = new Lotto(numbers);
        System.out.println();
        return lotto.getNumbers();
    }

    public static int inputBonus(List<Integer> winNumber){
        System.out.println("보너스 번호를 입력해 주세요.");
        String text = Console.readLine();
        System.out.println();
        for (Integer i : winNumber) {
            if (getNumber(text) == i) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 동일합니다.");
            }
        }
        return getNumber(text);
    }

    private static int getNumber(String s) {
        int number;
        try {
            number = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 제대로 입력해주세요.");
        }
        return number;
    }



}
