package lotto.domain.score;

import lotto.constants.collection.ScoreSystem;
import lotto.constants.collection.ScoreSystemReward;
import lotto.constants.value.LottoRule;
import lotto.domain.BonusComponent;
import lotto.domain.Component;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.dto.ScoreDto;

import java.util.*;
import java.util.stream.IntStream;


public class Score {

    private final LinkedHashMap<List<Integer>, Integer> scoreSystem ;
    private final List<Integer> scoreSystemReward;

    public Score(LinkedHashMap<List<Integer>, Integer> scoreSystem, List<Integer> scoreSystemReward) {
        this.scoreSystem = scoreSystem;
        this.scoreSystemReward = scoreSystemReward;
    }

    public ScoreDto printScore(Lottos lottos, Lotto winningLotto, BonusComponent bonusComponent) {
        scoreSystem.replaceAll((key, value) -> 0);

        List<Lotto> mylottos = new ArrayList<>(lottos.getLottos());
        List<Component> winningComponent = new ArrayList<>(winningLotto.getComponents());

        scoring(bonusComponent, mylottos, winningComponent);

        List<Integer> scoreValues = new ArrayList<>(scoreSystem.values());
        int amountOfLottos = lottos.getLottos().size();
        int totalUsedPrice = LottoRule.LOTTO_PRICE.getInstance()* amountOfLottos;
        int totalSum = IntStream.range(0, scoreValues.size())
                .map(i -> scoreValues.get(i) * scoreSystemReward.get(i))
                .sum();
        float rateOfReturn = (float) totalSum / totalUsedPrice;


        return new ScoreDto(new ArrayList<>(scoreValues),rateOfReturn);
    }

    private void scoring(BonusComponent bonusComponent, List<Lotto> mylottos, List<Component> winningComponent) {
        for(Lotto lotto: mylottos){
            Integer matches = (int) lotto.getComponents()
                    .stream()
                    .filter(winningComponent::contains)
                    .count();
            Integer bonusMatch = 0;
            if(lotto.getComponents().contains(bonusComponent)){
                bonusMatch ++;
            }
            List<Integer> key = Arrays.asList(matches, bonusMatch);

            if (scoreSystem.containsKey(key)) {
                scoreSystem.put(key, scoreSystem.get(key) + 1);
            }

        }
    }
}
