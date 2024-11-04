package lotto.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class LottoInput {
    public int readCost(){
        try{
            System.out.println("구입 금액을 입력해 주세요.");
            return Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해야 합니다.", e);
        }
    }

    public List<Integer> readWinningNumbers(){
        try{
            System.out.println("당첨 번호를 입력해 주세요 (쉼표로 구분된 숫자 6개):");
            String inputNumbers = Console.readLine();
            List<Integer> winningNumbers = Arrays.stream(inputNumbers.split(","))
                    .map(Integer::parseInt)
                    .toList();
            if(winningNumbers.size() != 6){
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
            }
            return winningNumbers;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자로 입력해야 합니다.");
        }
    }

    public int readBonus(){
        try{
            System.out.println("보너스 번호를 입력해 주세요:");
            return Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.", e);
        }
    }
}
