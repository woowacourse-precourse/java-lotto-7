package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Application {
    public static void main(String[] args) {

        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningNumbers);

    }

    static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요");
        String firstInput = Console.readLine();
        System.out.println(firstInput);

        List<Integer> list = Arrays.stream(firstInput.split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());

        try {
            Lotto lotto = new Lotto(list);

            return lotto.getNumbers();
        } catch(IllegalArgumentException e) {
            System.out.println(e);

            return inputWinningNumbers();
        }

    }

    static int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요");
        String secondInput = Console.readLine();
        System.out.println(secondInput);

        try {
            int bonusNumber = Integer.parseInt(secondInput);

            validateBonusNumber(bonusNumber, winningNumbers);
            return bonusNumber;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return inputBonusNumber(winningNumbers);
        }

    }

    private static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}


