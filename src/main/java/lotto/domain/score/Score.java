package lotto.domain.score;

import lotto.constants.ScoreSystem;
import lotto.domain.BonusComponent;
import lotto.domain.Component;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.dto.ScoreDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Score {

    private final HashMap<List<Integer>, Integer> scoreSystem ;

    public Score(ScoreSystem scoreSystem) {
        this.scoreSystem = new HashMap<>(scoreSystem.getMap());
    }

    public ScoreDto printScore(Lottos lottos, Lotto winningLotto, BonusComponent bonusComponent) {
        scoreSystem.replaceAll((key, value) -> 0);

        List<Lotto> mylottos = new ArrayList<>(lottos.getLottos());
        List<Component> winningComponent = new ArrayList<>(winningLotto.getComponents());

        scoring(bonusComponent, mylottos, winningComponent);

        return new ScoreDto(scoreSystem);
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
