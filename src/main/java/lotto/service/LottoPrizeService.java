package lotto.service;

import static lotto.constant.Message.DELIMITER;
import static lotto.view.InputView.getPrintInputBonusNumberMessage;
import static lotto.view.InputView.getPrintInputPrizeNumberMessage;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.domain.PrizeNumbers;

public class LottoPrizeService {
    private static PrizeNumbers prizeNumbers;

    public PrizeNumbers PrizeNumbers(){
        prizeNumbers = new PrizeNumbers(setPrizeNumber(),setBonusNumber());
        return prizeNumbers;
    }

    private Lotto setPrizeNumber() {
        getPrintInputBonusNumberMessage();
        return new Lotto(delimiterPrizeNumbers(Console.readLine()));

    }

    private Integer setBonusNumber(){
        getPrintInputPrizeNumberMessage();
        return bonusStringToInteger(Console.readLine());
    }

    private List<Integer> delimiterPrizeNumbers(String prizeNumbers) {
        return Arrays.stream(prizeNumbers.trim().split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private Integer bonusStringToInteger(String numbers){
        return Integer.valueOf(numbers);
    }


}
