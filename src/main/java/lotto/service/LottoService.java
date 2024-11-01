package lotto.service;

import lotto.Lotto;
import lotto.util.MathUtil;
import lotto.util.ParseUtil;
import lotto.util.RandomUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    static final String DELIMITER = ",";

    public List<Lotto> generateLottos(int size) {
        List<Lotto> lottos = IntStream.range(0, size)
                .mapToObj(i -> new Lotto(RandomUtil.getSixRandomNumbers(1, 45)))
                .collect(Collectors.toList());
        return lottos;
    }

    public Map<Integer, Integer> getMatchCounts(List<Lotto> lottos, Lotto winningLotto) {
        Map<Integer, Integer> matchCounts = IntStream.rangeClosed(0, 6)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> 0));

        lottos.stream()
                .map(lotto -> MathUtil.getMatchCount(lotto.getNumbers(), winningLotto.getNumbers()))
                .forEach(matchCount -> matchCounts.put(matchCount, matchCounts.get(matchCount) + 1));

        return matchCounts;
    }

    public Lotto getWinningLotto(String winningNumbersInput) {
        List<String> tokens = ParseUtil.splitByDelimiters(winningNumbersInput, DELIMITER);
        List<Integer> winningNumbers = ParseUtil.parseToIntegerList(tokens);
        Lotto winningLotto = new Lotto(winningNumbers);
        return winningLotto;
    }
}
