package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public int getPurchaseAmount() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getWinningNumbers() {
        try {
            return Arrays.stream(Console.readLine().split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public int getBonusNumber(){
        try {
            return Integer.parseInt(Console.readLine());
        } catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
