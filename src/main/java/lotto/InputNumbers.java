package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputNumbers {
    public Lotto inputWinningNumbers(){
        while (true){
            try {
                System.out.println("당첨 번호를 입력해 주세요. : ");
                String input = Console.readLine().trim();
                List<Integer> winningNumbers = parseInputToList(input);
                return new Lotto(winningNumbers);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요. : ");
                String input = Console.readLine().trim();
                int bonusNumber = parseBonusNumber(input);
                return bonusNumber; // 보너스 번호 반환
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private List<Integer> parseInputToList(String input) {
    List<Integer> numbers = new ArrayList<>();

    if (!input.trim().isEmpty()) {
        String[] splitNumbers = input.split(",");

        for (String number : splitNumbers) {
            numbers.add(Integer.parseInt(number.trim()));
        }
    }
    return numbers;
    }
}
