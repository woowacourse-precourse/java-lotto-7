package lotto.woowaLotto.lottoPlayer.woowaLotto.autoLotto.handler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.woowaLotto.lottoPlayer.woowaLotto.autoLotto.handler.domain.Lotto;
import lotto.woowaLotto.lottoPlayer.woowaLotto.autoLotto.handler.domain.LottoResult;
import lotto.woowaLotto.lottoPlayer.woowaLotto.autoLotto.handler.domain.Lottos;
import lotto.woowaLotto.lottoPlayer.woowaLotto.autoLotto.handler.domain.PickedLotto;
import lotto.woowaLotto.lottoPlayer.woowaLotto.autoLotto.handler.util.RandomNumberCreator;

public class AutoLottoHandler {

    private final int MIN_SAME_COUNT = 3;

    private final RandomNumberCreator numberCreator = new RandomNumberCreator();

    public LottoResult getResult(Lottos lottos, PickedLotto pickedLotto, long price) {

        Lotto pickedNums = pickedLotto.getPickedLotto();
        int bonusNum = pickedLotto.getBonusNumber();
        Map<Integer, Integer> results = initializeResults();

        for(Lotto lotto : lottos.getLottos()) {
            verifyLotto(lotto, results, pickedNums, bonusNum);
        }

        float roi = calculateROI(results,price);
        return new LottoResult(results,roi);
    }

    private Map<Integer, Integer> initializeResults() {
        return new HashMap<>(){{
            put(1,0);
            put(2,0);
            put(3,0);
            put(4,0);
            put(5,0);
        }};
    }

    private float calculateROI(Map<Integer,Integer> results, Long price) {
        long prize = calculatePrize(results);
        return (float) prize / price * 100;
    }

    private long calculatePrize(Map<Integer,Integer> results) {
        return results.get(1) * 2000000000 +
                results.get(2) * 30000000 +
                results.get(3) * 1500000 +
                results.get(4) * 50000 +
                results.get(5) * 5000;
    }



    private void verifyLotto(Lotto lotto, Map<Integer,Integer> results, Lotto pickedNums, int bonusNum) {
        int sameCnt = (int) lotto.getNumbers().stream()
                .filter(pickedNums.getNumbers()::contains)
                .count();
        calculateRank(sameCnt,lotto.getNumbers().contains(bonusNum),results);
    }

    private void calculateRank(int sameCnt, boolean bonus, Map<Integer,Integer> results) {
        if(sameCnt < MIN_SAME_COUNT) return;

        if(sameCnt == 3) {
            results.put(5,results.get(5)+1);
        }
        if(sameCnt == 4) {
            results.put(4,results.get(4)+1);
        }
        if(sameCnt == 5) {
            results.put(3,results.get(3)+1);
        }
        if(sameCnt == 5 && bonus){
            results.put(2,results.get(2)+1);
        }
        if(sameCnt == 6){
            results.put(1,results.get(1)+1);
        }
    }

    public Lottos getRandomLottos(int price) {
        Lottos lottos = new Lottos();
        long chance = getChance(price);

        List<List<Integer>> lottoList = new ArrayList<>();

        for (int i = 0; i < chance; i++) {
            lottoList.add(numberCreator.createRandomNum(1,45,6));
        }
        lottoList.sort(Comparator.comparing(List::getFirst));

        for (List<Integer> lotto : lottoList) {
            System.out.println(lotto);
        }
        System.out.println();

        lottos.addLotto(lottoList);

        return lottos;
    }

    private int getChance(int price) {
        int chance = price/1000;

        System.out.printf("%d개를 구매했습니다.%n", chance);

        return chance;
    }


}
