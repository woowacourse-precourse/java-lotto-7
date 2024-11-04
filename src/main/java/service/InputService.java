package service;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputService {

    static final String INPUT_PURCHASE_COST_MESSAGE = "구입금액을 입력해 주세요.";
    static final String  INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public InputService(){}

    public Integer inputLottoPurchaseCost(){
        System.out.println(INPUT_PURCHASE_COST_MESSAGE);
        String purchaseCost = Console.readLine();

        return Integer.parseInt(purchaseCost);
    }

    public List<Integer> inputWinningNumbers(){
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String winningNumbers = Console.readLine();

        return Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();

        return Integer.parseInt(bonusNumber);
    }
}
