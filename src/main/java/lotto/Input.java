package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {
    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int price = parseInt(input.trim());
        validatePrice(price);
        System.out.println();
        return price;
    }

    public static List<Integer> inputWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> winningNumbers = new ArrayList<>();
        for(String number : splitNumber(input)){
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        validateWinningNumbers(winningNumbers);
        System.out.println();
        return winningNumbers;
    }

    public static int inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int number = parseInt(input.trim());
        validateNumberRange(number);
        System.out.println();
        return number;
    }

    private static List<String> splitNumber(String input){
        if (!input.contains(",")) {
            throw new IllegalArgumentException("쉼표 기준으로 구분해주세요.");
        }

        String[] inputs = input.split(",");
        return List.of(inputs);
    }

    private static void validatePrice(int price) {
        if (price < 0 || price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액이 올바르지 않습니다.");
        }
    }

    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for (Integer winningNumber : winningNumbers) {
            validateNumberRange(winningNumber);
        }
    }
    
    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 정확한 숫자를 입력해주세요.");
        }
    }


    private static void validateNumberRange(int num) {
        if (num <= 0 || num  >= 46) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
