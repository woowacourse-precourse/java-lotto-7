package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static int readPurchasePrice(){
        String purchasePrice = Console.readLine();
        //valid
        return Integer.parseInt(purchasePrice);
    }
    public static List<Integer> readWinningNumbers(){
        String lottoNumbers =  Console.readLine();
        //valid
        return Arrays.stream(lottoNumbers.split(",")).map(Integer::parseInt).toList();
    }
    public static int readBonusNumber(){
        String bonusNumber =  Console.readLine();
        //valid
        return Integer.parseInt(bonusNumber);
    }

}
