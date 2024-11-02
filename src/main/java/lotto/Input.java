package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    public static int getCost() {
//        System.out.println("구입금액을 임력해 주세요.");
        System.out.println("Input Purchase Cost");
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> getWinNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (true) {
            numbers = inputWinners();
            break;
        }
        return numbers;
    }

    public static List<Integer> inputWinners() {
        List<Integer> numbers = new ArrayList<>();
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            numbers = Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .toList();

            if (numbers.size() != 6) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 당첨 번호에는 숫자만 들어올 수 있습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
        }
        return numbers;
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        int num = 0;
        while (true) {
            num = inputBonusNumber(winningNumbers);
            break;
        }
        return num;
    }

    public static int inputBonusNumber(List<Integer> winningNumbers) {
        int num = 0;

        try {
            System.out.println("보너스 번호를 입력해 주세요");
            num = Integer.parseInt(Console.readLine());
            if (winningNumbers.contains(num)) {
                throw new IllegalStateException();
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 보너스 번호는 숫자만 입력할 수 있습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 중복된 값이 입력되었습니다.");
        }

        return num;
    }

}
