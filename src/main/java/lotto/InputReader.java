package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class InputReader {

    Validation validation;
    InputReader(Validation validation){
        this.validation = validation;
    }
    public int readLottoPrice(){
        String lottoPrice = Console.readLine();
        validation.validateLottoPrice(lottoPrice);
        return Integer.parseInt(lottoPrice);
    }

    public Lotto readWinningNumbers(){
        String winningNumbers = Console.readLine();
        validation.validateLottoNumber(winningNumbers);
        List<Integer> numbers = Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }

    public int readBonusNumber(Lotto winningLotto){
        String bonusNumber = Console.readLine();
        validation.validateBonusNumber(winningLotto, bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
