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

        List<Integer> list = Arrays.stream(firstInput.split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());

        try {
            Lotto lotto = new Lotto(list);

            return lotto;
        } catch(IllegalArgumentException e) {
            System.out.println(e);

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
