package lotto.model;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.util.RandomNumber;

public class Lottos {

    private List<Lotto> lottos;
    private int number;
    private Map<Rank, Integer> winningStatistics;

    public Lottos(int number) {
        List<Lotto> generatedLotto = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            generatedLotto.add(new Lotto(RandomNumber.createRandomNumbers()));
        }
        this.lottos = generatedLotto;
    }

    public void calculateWinningStatistics(WinningLotto winningLotto) {
        winningStatistics = lottos.stream()
                .collect(groupingBy(
                        lotto -> lotto.getLottoRanking(winningLotto),
                        summingInt(lotto -> 1)
                ));
        Arrays.stream(Rank.values()).forEach(rank -> winningStatistics.putIfAbsent(rank, 0));
    }
}
