package lotto.Service;

import lotto.Util.Lotto;

import javax.swing.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoService {
    private Lotto lotto;
    String input = readLine();

    public Lotto WinningNumberSplit() {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        lotto = new Lotto(numbers);
        return lotto;
    }


}
