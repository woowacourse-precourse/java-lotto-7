package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInputLotto {   // 사용자가 입력하는 값에 대한 클래스
    public int purchaseAmount() {   // 사용자가 얼마어치 사는지 입력
        System.out.println("얼마어치를 구매하시겠습니까? (1,000원 단위)");
        int amount = Integer.parseInt(Console.readLine());

        return amount;
    }

    public List<Integer> inputPrizeNumbers() {      // 사용자가 당첨 번호를 입력
        System.out.println("당첨 번호를 입력해 주세요");
        String input = Console.readLine();
        String[] InputedNumber = input.split(",");

        List<Integer> numbers = new ArrayList<>();
        for (String number : InputedNumber) {
            numbers.add(Integer.parseInt(number));
        }

        return numbers;
    }

    public int inputBounsNumber() {   // 사용자가 보너스 번호 입력
        System.out.println("보너스 번호를 입력하세요");
        int bonus = Integer.parseInt(Console.readLine());

        return bonus;
    }

    private int purchaseAmountRead() {
        System.out.println("얼마어치를 구매하시겠습니까? (1,000원 단위)");
        int amount = Integer.parseInt(Console.readLine());
    }
    private List<Integer> delimiterNumber(String input) {
        // 쉼표로 구분하여 숫자 반환
        String[] inputNumbers = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : inputNumbers) {
            numbers.add(Integer.parseInt(number));
        }

        return numbers;
    }
}
