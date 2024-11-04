package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public int size() {
        return lottos.size();
    }

    public String information() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.toString());
        }
        return stringBuilder.toString();
    }

    public void calculateMatchingNumberCount(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        lottos.forEach((lotto) -> lotto.calculateMatchingNumberCount(winningNumbers, bonusNumber));
    }
}