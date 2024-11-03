package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        final int price = getPrice();

        final int numOfLotto = price / 1000;
        System.out.println(numOfLotto + "개를 구매했습니다.");


        final List<List<Integer>> listOfLotto = new ArrayList<>();

        for (int i = 0; i < numOfLotto; i++) {
            List<Integer> pickLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(pickLotto);
            listOfLotto.add(pickLotto);
        }

        for (List<Integer> eachOfLotto : listOfLotto) {
            System.out.println(eachOfLotto);
        }


        System.out.println("당첨 번호를 입력해 주세요.");


        final String inputForWinningNumbers = Console.readLine();

        String[] arrayForWinningNumbers = inputForWinningNumbers.split(",");

        List<String> listOfWinningNumbers = new ArrayList<>(Arrays.asList(arrayForWinningNumbers));

        List<Integer> winningNumbers = new ArrayList<>();

        for (String winningNumber : listOfWinningNumbers) {
            try {
                int number = isNotNum(winningNumber);
                rangeOfNumber(number);
                winningNumbers.add(number);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        System.out.println("보너스 번호를 입력해 주세요.");


        final String inputForBonus = Console.readLine();
        try {
            int bonusNumber = isNotNum(inputForBonus);
            rangeOfNumber(bonusNumber);
            isAlreadyExist(winningNumbers,bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

    private static int getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        final String inputForPrice = Console.readLine();
        try {
            int price = isNotNum(inputForPrice);
            if (price % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야 합니다.");
            }
            return price;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPrice();
        }
    }

    public static int isNotNum(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    public static void rangeOfNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자만 입력 가능합니다.");
        }
    }

    public static void isAlreadyExist(List<Integer> listOfInteger, int number){
        if(listOfInteger.contains(number)){
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 해당하지 않는 숫자만 입력 가능합니다.");
        }
    }
}
