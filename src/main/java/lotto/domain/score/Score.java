package lotto.domain.score;

import lotto.constants.value.LottoRule;
import lotto.domain.BonusComponent;
import lotto.domain.Component;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.dto.ScoreDto;

import java.util.*;
import java.util.stream.IntStream;


public class Score {

    private final LinkedHashMap<List<Integer>, Integer> scoreSystem;
    private final List<Integer> scoreSystemReward;

    public Score(LinkedHashMap<List<Integer>, Integer> scoreSystem, List<Integer> scoreSystemReward) {
        this.scoreSystem = scoreSystem;
        this.scoreSystemReward = scoreSystemReward;
    }

    public ScoreDto printScore(Lottos lottos, Lotto winningLotto, BonusComponent bonusComponent) {
        scoreSystem.replaceAll((key, value) -> 0);

        initializeScore(lottos, winningLotto, bonusComponent);

        List<Integer> scoreValues = new ArrayList<>(scoreSystem.values());
        float rateOfReturn = calculateRateOfReturn(lottos, scoreValues);

        return new ScoreDto(new ArrayList<>(scoreValues), rateOfReturn);
    }

    private float calculateRateOfReturn(Lottos lottos, List<Integer> scoreValues) {
        int amountOfLottos = lottos.getLottos().size();
        int totalUsedPrice = LottoRule.LOTTO_PRICE.getInstance() * amountOfLottos;
        int totalSum = IntStream.range(0, scoreValues.size())
                .map(i -> scoreValues.get(i) * scoreSystemReward.get(i))
                .sum();
        return (float) totalSum / totalUsedPrice * 100;
    }

    private void initializeScore(Lottos lottos, Lotto winningLotto, BonusComponent bonusComponent) {
        List<Lotto> mylottos = new ArrayList<>(lottos.getLottos());
        List<Component> winningComponent = new ArrayList<>(winningLotto.getComponents());
        processScore(bonusComponent, mylottos, winningComponent);
    }

    private void processScore(BonusComponent bonusComponent, List<Lotto> mylottos, List<Component> winningComponent) {
        for (Lotto lotto : mylottos) {
            Integer matches = (int) lotto.getComponents()
                    .stream()
                    .filter(winningComponent::contains)
                    .count();
            Integer bonusMatch = 0;
            if (lotto.getComponents().contains(bonusComponent)) {
                bonusMatch++;
            }
            List<Integer> key = Arrays.asList(matches, bonusMatch);
            if (scoreSystem.containsKey(key)) {
                scoreSystem.put(key, scoreSystem.get(key) + 1);
            }
        }
    }

}
