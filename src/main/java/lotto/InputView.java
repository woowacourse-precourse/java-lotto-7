package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    Validator validator = new Validator();

    public Integer inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return getValidMoney();
    }

    private Integer getValidMoney() {
        try {
            String money = Console.readLine();
            Integer parsedMoney = validator.validateMoney(money);
            return parsedMoney;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidMoney();
        }
    }


    public List<Integer> inputWinningLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().replace(" ", "").split(",");

        List<Integer> winningNumbers = Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (!validator.isValidWinningNumbers(winningNumbers)) {
            System.out.println("[ERROR] 당첨 번호는 1에서 45 사이의 중복되지 않는 6개의 숫자여야 합니다. 다시 입력해 주세요.");
            return inputWinningLottoNumbers();
        }
        return winningNumbers;
    }

    public int inputBonusLottoNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        if (!validator.isValidBonusNumber(bonusNumber, winningNumbers)) {
            System.out.println("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 하며, 당첨 번호와 중복될 수 없습니다. 다시 입력해 주세요.");
            return inputBonusLottoNumber(winningNumbers);
        }
        return bonusNumber;
    }
}
