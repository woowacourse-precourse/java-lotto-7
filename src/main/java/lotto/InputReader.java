package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class InputReader {

    Validation validation = new Validation();
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
}
