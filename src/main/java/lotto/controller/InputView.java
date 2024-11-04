package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String InputLottoPrice = "구입금액을 입력해 주세요.";
    private static final String InputWinningNumber = "당첨 번호를 입력해 주세요.";
    private static final String InputBonusNumber="보너스 번호를 입력해 주세요.";
    private static List<Integer> winningNumberList;
    private static final int MinAmount = 1000;

    public int inputLottoPrice(){
        System.out.println(InputLottoPrice);
        String inputPrice = Console.readLine();
        int inputLottoPrice = Integer.parseInt(inputPrice);
        return inputLottoPrice;
    }

    public List<Integer> inputWinnerNumber() {
        System.out.println(InputWinningNumber);
        String inputWinner = Console.readLine();
        List<Integer> inputWinnerNumber = Arrays.stream(inputWinner.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return inputWinnerNumber;
    }

    public int inputBonusNumber(){
        System.out.println(InputBonusNumber);
        String inputBonus = Console.readLine();
        int inputBonusNumber = Integer.parseInt(inputBonus);
        return inputBonusNumber;
    }


}
