package lotto;

import java.math.BigInteger;
import java.util.List;

public class Draw {
    private int firstRank;
    private int secondRank;
    private int thirdRank;
    private int fourthRank;
    private int fifthRank;

    Draw() {
        firstRank = 0;
        secondRank = 0;
        thirdRank = 0;
        fourthRank = 0;
        fifthRank = 0;
    }

    public void lotto(List<Lotto> lottos, Lotto userLotto, int bonus) {
        drawLotto(lottos, userLotto, bonus);

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + fifthRank + "개");
        System.out.println("4개 일치 (50,000원) - " + fourthRank + "개");
        System.out.println("5개 일치 (1,500,000원) - " + thirdRank + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + secondRank + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + firstRank + "개");

    }

    public void printEarningRate(int cost) {
        System.out.println("총 수익률은 " + String.format("%.1f", earningRate(cost)) + "%입니다.");    }

    private double earningRate(int cost) {
        BigInteger firstPrize = BigInteger.valueOf(2_000_000_000);
        BigInteger secondPrize = BigInteger.valueOf(30_000_000);
        BigInteger thirdPrize = BigInteger.valueOf(1_500_000);
        BigInteger fourthPrize = BigInteger.valueOf(50_000);
        BigInteger fifthPrize = BigInteger.valueOf(5_000);

        BigInteger totalPrize = firstPrize.multiply(BigInteger.valueOf(firstRank))
                .add(secondPrize.multiply(BigInteger.valueOf(secondRank)))
                .add(thirdPrize.multiply(BigInteger.valueOf(thirdRank)))
                .add(fourthPrize.multiply(BigInteger.valueOf(fourthRank)))
                .add(fifthPrize.multiply(BigInteger.valueOf(fifthRank)));

        return (totalPrize.doubleValue() / cost) * 100;
    }

    private void drawLotto(List<Lotto> lottos, Lotto userLotto, int bonus) {

        for (Lotto lotto : lottos) {
            grantRank(lotto.getNumbers(), userLotto.getNumbers(), bonus);
        }
    }

    private void grantRank(List<Integer> lotto, List<Integer> userLotto, int bonus) {
        int hitCount = 0;
        boolean hitBonus = false;

        for (int i = 0; i < lotto.size(); i++) {
            if (lotto.contains(userLotto.get(i))) {
                hitCount++;
            }
        }
        if (lotto.contains(bonus)) {
            hitBonus = true;
        }

        judgeRank(hitCount, hitBonus);
    }

    private void judgeRank(int hitCount, boolean hitBonus) {
        if (hitCount == 6) {
            firstRank++;
            return;
        }
        if (hitCount == 5 && hitBonus) {
            secondRank++;
            return;
        }
        if (hitCount == 5) {
            thirdRank++;
            return;
        }
        if (hitCount == 4) {
            fourthRank++;
            return;
        }
        if (hitCount == 3) {
            fifthRank++;
        }
    }

}
