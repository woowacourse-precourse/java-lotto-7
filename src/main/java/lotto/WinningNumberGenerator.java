package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.stream.IntStream;

public class WinningNumberGenerator {

    public static List<Integer> generateWinningNumbers() {
        List<Integer> numbers = LottoNumberGenerator.generate();
        return new ArrayList<>(numbers.subList(0, 6));
    }

    public static int generateBonusNumber(List<Integer> winningNumbers) {
        List<Integer> numberPool = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        numberPool.removeAll(winningNumbers);
        Collections.shuffle(numberPool);
        return numberPool.get(0);
    }
}