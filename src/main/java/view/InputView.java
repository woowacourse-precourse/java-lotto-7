package view;

import camp.nextstep.edu.missionutils.Console;
import util.Message;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    public int inputPurchaseCost() {
        System.out.println(Message.PURCHASE_COST);
        return Integer.parseInt(Console.readLine().trim());
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(Message.WINNING_NUMBER);
        return Stream.of(Console.readLine().trim().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        System.out.println(Message.BONUS_NUMBER);
        return Integer.parseInt(Console.readLine().trim());
    }
}
