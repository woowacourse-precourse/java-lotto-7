package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import lotto.validation.InputNumValidation;
import lotto.validation.NumValidation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    public static long inputNum() {
        String num;
        do {
            System.out.println("구매금액을 입력해 주세요.");
            num = Console.readLine();
        } while (!InputNumValidation.checkInputNum(num));
        return Long.parseLong(num);
    }

    public static List<Integer> inputWinNum() {
        String winNums;
        do {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            winNums = Console.readLine();
        } while (!NumValidation.checkWinNum(winNums));
        return Arrays.stream(winNums.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }

    public static int inputBonusNum(List<Integer> winNums) {
        String inputBonusNum;
        do {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            inputBonusNum = Console.readLine();
        } while (!NumValidation.checkBonusNum(inputBonusNum, winNums));
        return Integer.parseInt(inputBonusNum);
    }

}