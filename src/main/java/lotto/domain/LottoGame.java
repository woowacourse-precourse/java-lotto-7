package lotto.domain;

import lotto.util.RandomNumberGenerator;

import java.util.*;

public class LottoGame {
    private List<Lotto> lottos = new ArrayList<>();
    private CustomLotto customLotto;
    private List<Integer> rank=new ArrayList<>(5);
    private Integer seedMoney;

    public static LottoGame of(int money) {
        return new LottoGame(money);
    }

    private LottoGame(int money) {
        this.seedMoney = money;
        drawNewLottoNumber(money/1000);
        for(int i=0;i<5;i++){
            rank.add(0);
        }
    }

    public void setCustomLotto(CustomLotto customLotto){
        this.customLotto = customLotto;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
    public List<Integer> getRank(){
        return rank;
    }
    public Integer getSeedMoney(){return seedMoney;}

    private void drawNewLottoNumber(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = RandomNumberGenerator.makeRandomNumber();
            lottos.add(new Lotto(numbers));
        }
    }

    public void calculateLottoRank() {
        for (Lotto lotto : lottos) {
            int matchCount = howMayMatch(lotto, customLotto);
            if(matchCount<3){
                continue;
            }
            boolean isBonusMatch = false;
            if (matchCount == 5) {
                isBonusMatch = isMatchBonus(lotto);
            }
            updateRank(matchCount, isBonusMatch);
        }
    }

    private void updateRank(int matchCount, boolean isBonus) {
        if(isBonus || matchCount == 6){
            matchCount++;
        }
        matchCount-=3;
        Integer update = rank.get(matchCount)+1;
        rank.set(matchCount,update);
    }

    private boolean isMatchBonus(Lotto lotto) {
        return lotto.getNumbers().contains(customLotto.getBonus());
    }

    private int howMayMatch(Lotto lotto, CustomLotto customLotto) {
        List<Integer> targetNumbers = lotto.getNumbers();
        List<Integer> compareNumbers = customLotto.getNumbers();

        Set<Integer> commonNumbers = new HashSet<>(targetNumbers);
        commonNumbers.retainAll(compareNumbers);

        return commonNumbers.size();
    }
}
