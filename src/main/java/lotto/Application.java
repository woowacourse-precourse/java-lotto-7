package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static lotto.Validation.*;
import static lotto.Validation.validateWinningNumber;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGame lottoGame;

        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String money = Console.readLine();
                lottoGame = new LottoGame(money);
                break;
            } catch (IllegalArgumentException e) {
            }
        }

        System.out.println();
        lottoGame.printMyLotto();
        System.out.println();

        String[] winningNumberString;
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String winningNumber = Console.readLine();
                winningNumberString = winningNumber.split(",");
                validateWinningNumber(winningNumberString);
                break;
            } catch (IllegalArgumentException e) {
            }
        }

        List<Integer> winningNumbers = Arrays.stream(winningNumberString)
                .map(Integer::parseInt)
                .toList();

        int bonusNumber;
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String bonusNumberString = Console.readLine();
                validateBonusNumber(bonusNumberString);
                bonusNumber = Integer.parseInt(bonusNumberString);
                ValidateWinningNumberContainsBonusNumber(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
            }
        }

        lottoGame.matchNumbers(winningNumbers, bonusNumber);
    }
}
