package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public static Integer inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        Integer money = Integer.parseInt(Console.readLine());
        return money;
    }

    public static List<Integer> inputWinNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> winNumbers = parseNumbers(input);
        return winNumbers;
    }

    public static List<Integer> parseNumbers(String input){
        String[] tokens = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            numbers.add(Integer.parseInt(token.trim()));
        }// 문자열을 정수로 변환 후 리스트에 추가

        return numbers;
    }

    public static Integer inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }
}
