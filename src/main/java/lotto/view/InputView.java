package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public long inputPurchaseAmount(){
        return Long.parseLong(Console.readLine());
    }

    public List<Integer> inputWinningNumber(){
        return stringToIntegerList(Console.readLine());
    }

    private List<Integer> stringToIntegerList(String input){
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public Integer inputBonusNumber(){
        return Integer.parseInt(Console.readLine());
    }
}
