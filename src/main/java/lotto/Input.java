package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public static Integer inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        Integer money = FindError.moneyError(input);
        return money;
    }

    public static List<Integer> inputWinNumbers(){
        System.out.println();
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

        // 유효성 검사를 위해 Lotto 객체 생성
        Lotto lotto = new Lotto(numbers);

        return lotto.getNumbers();
    }

    public static Integer inputBonusNumber(List<Integer> winNumbers){
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusNumber = Integer.parseInt(Console.readLine());
        FindError.validateBonusNumber(bonusNumber, winNumbers);
        return bonusNumber;
    }
}
