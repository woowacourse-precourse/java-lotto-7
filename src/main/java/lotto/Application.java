package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money;
        List<Lotto> lottoList = new ArrayList<>();

        while (true) {
            try {
                money = getMoney();
                exception(money);
                break;
            } catch (IllegalArgumentException error) {
                System.out.println("[ERROR]" + error.getMessage());
            }
        }
        int count = countLotto(money);
        outputCount(count);

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = randomNumbers();
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
        }
        outputnumbers(lottoList);

        while (true) {
            try {
                List<Integer> WinningNumbers = inputWinningNumbers();
                Lotto winningNumbers = new Lotto(WinningNumbers);
                break;
            } catch (IllegalArgumentException error) {
                System.out.println("[ERROR]" + error.getMessage());
            }
        }

        while (true) {
            try {
                int bonusNumber = inputBonusNumber();
                bonusException(bonusNumber);
                break;
            } catch (IllegalArgumentException error) {
                System.out.println("[ERROR]" + error.getMessage());
            }
        }
    }

    private static int getMoney() {
        System.out.println("로또 구매 금액을 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }

    private static void exception (int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("금액이 0보다 커야 합니다.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("로또 금액이 1개당 1000원이므로 1000원 단위로 입력하세요.");
        }
    }

    private static int countLotto(int money) {
        return money / 1000;
    }

    private static void outputCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    private static List<Integer> randomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Integer::compareTo);
        return numbers;
    }

    private static void outputnumbers(List<Lotto> lottoList) {
        for (int i = 0; i < lottoList.size(); i++) {
            System.out.println(lottoList.get(i).getNumbers());
        }
    }

    private static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요. (예: 1,2,3,4,5,6)");
        String input = Console.readLine();
        String[] splitInput = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (int i = 0; i < splitInput.length; i++) {
            String num = splitInput[i];
            winningNumbers.add(Integer.parseInt(num));
        }
        return winningNumbers;
    }

    private static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private static void bonusException (int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }
}
