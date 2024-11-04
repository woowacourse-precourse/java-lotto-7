package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Application.bonusNumber;
import static lotto.Application.winningLotto;

import java.util.Arrays;
import java.util.List;

import lotto.model.Lotto;
import static lotto.controller.Validater.checkBounsVaild;
import static lotto.controller.Validater.checkLottoCost;
import static lotto.controller.Validater.checkRange;
import static lotto.controller.Validater.stringToNum;
import static lotto.controller.LogicControl.stringToNumbers;

public class InputView {
    public static int inputAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int lotto_cost = stringToNum(readLine());
                checkLottoCost(lotto_cost);
                return lotto_cost;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    public static void makeWinningLotto() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = readLine();
                List<Integer> numbers = stringToNumbers(Arrays.asList(input.split(",")));
                winningLotto = new Lotto(numbers);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    public static void makeBonusNum() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int n = stringToNum(readLine());
                checkRange(n);
                checkBounsVaild(n);
                bonusNumber = n;
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }
}
