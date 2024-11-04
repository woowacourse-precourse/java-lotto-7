package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoDraw {

    static Lotto inputWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요");
        String firstInput = Console.readLine();

        try {
            List<Integer> list = Arrays.stream(firstInput.split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed().collect(Collectors.toList());

            Lotto lotto = new Lotto(list);

            return lotto;
        } catch(NumberFormatException e) {
            System.out.println("[ERROR] 숫자 형식이 잘못되었습니다. 다시 입력해 주세요.");

            return inputWinningNumbers();
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return inputWinningNumbers();
        }
    }

    static int inputBonusNumber(Lotto inputLotto) {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요");
        String secondInput = Console.readLine();

        try {
            int bonusNumber = Integer.parseInt(secondInput);

            inputLotto.validateBonusNumber(bonusNumber);
            return bonusNumber;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return inputBonusNumber(inputLotto);
        }

    }

}
