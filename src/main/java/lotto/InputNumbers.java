package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputNumbers {
    public Lotto inputWinningNumbers() {
        while(true){
            try{
                System.out.println("당첨 번호를 입력해 주세요. : ");
                String input = Console.readLine().trim();
                List<Integer> numbers = parseInputToList(input);
                return new Lotto(numbers);
            }catch (IllegalArgumentException e){
                System.err.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber() {
        while(true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요. : ");
                String input = Console.readLine().trim();
                int bonusNumber = Integer.parseInt(input);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private List<Integer> parseInputToList(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] splitNumbers = input.split(",");

        for (String num : splitNumbers){
            num = num.trim();
            int parseNumbers = Integer.parseInt(num);
            numbers.add((parseNumbers));
        }
        return numbers;
    }
}