package lotto.service;

import java.util.List;

public class ValidChecker {
    public void checkUnderMaximum(int number) {
        if(number>45||number<1){
            System.out.println("[ERROR] 숫자는 1~45 중 골라야 합니다");
            throw new IllegalArgumentException("[ERROR] 숫자는 1~45 중 골라야 합니다");
        }
    }

    public void notInt(String input){
        for (char c : input.toCharArray()) {
            if ((int) c < 48 || (int) c > 57) {
                System.out.println("[ERROR] 숫자가 아닌 입력은 허용되지 않습니다");
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 입력은 허용되지 않습니다");
            }
        }
    }

    public void notContainComma(String input) {
        if (!input.contains(",")) {
            System.out.println("[ERROR] 쉼표로 구분된 6개의 숫자를 넣어주세요");
            throw new IllegalArgumentException("[ERROR] 쉼표로 구분된 6개의 숫자를 넣어주세요");
        }
    }

    public void notSixNumbers(String input) {
        String[] parts = input.split(",");
        if (parts.length != 6) {
            System.out.println("[ERROR] 쉼표로 구분된 6개의 숫자를 넣어주세요");
            throw new IllegalArgumentException("[ERROR] 쉼표로 구분된 6개의 숫자를 넣어주세요");
        }
    }

    public void isBonusDuplicated(String number,List<Integer> winningNumbers){
        if(winningNumbers.contains(Integer.parseInt(number))) {
            System.out.println("[ERROR] 보너스 숫자는 당첨 숫자 6개와 중복될 수 없습니다.");
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 숫자 6개와 중복될 수 없습니다.");
        }
    }
}
