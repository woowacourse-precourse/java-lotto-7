package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lottery {
    private static final List<Lotto> LOTTOES = new ArrayList<>();
    private static int THREE_COMPARE = 0;
    private static int FOUR_COMPARE = 0;
    private static int FIVE_COMPARE = 0;
    private static int FIVE_BONUS_COMPARE = 0;
    private static int SIX_COMPARE = 0;

    public void issue(int purchaseAmount) {
        if(purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또는 천원 이상부터 구매가능합니다.");
        }

        int issue = purchaseAmount / 1000;

        System.out.println(issue + "개를 구매했습니다.");

        for (int i = 0; i < issue; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            LOTTOES.add(new Lotto(numbers));

            System.out.println(Arrays.toString(numbers.toArray()));
        }
    }

    public void prize(String prizeNum, String bonusNum, String purchaseAmount) {
        Lotto lottoPrizeNum = new Lotto(Arrays.stream(prizeNum.split(",")).mapToInt(Integer::parseInt).boxed().toList());

        for (Lotto lotto : LOTTOES) {
            lotto.getNumbers().retainAll(lottoPrizeNum.getNumbers());
            boolean bonusMatch = checkBonus(lotto, bonusNum);

            checkPrize(lotto.getNumbers().size(), bonusMatch);
        }

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(Rank.THREE_RANK.getMessage() + THREE_COMPARE + "개");
        System.out.println(Rank.FOUR_RANK.getMessage() + FOUR_COMPARE + "개");
        System.out.println(Rank.FIVE_RANK.getMessage() + FIVE_COMPARE + "개");
        System.out.println(Rank.FIVE_BONUS_RANK.getMessage() + FIVE_BONUS_COMPARE + "개");
        System.out.println(Rank.SIX_RANK.getMessage() + SIX_COMPARE + "개");
        System.out.println("총 수익률은 " + getRate(Integer.parseInt(purchaseAmount)) + "%입니다.");
    }

    public int checkPrize(int compare, boolean bonusMatch) {
        if (compare == 6) {
            return SIX_COMPARE++;
        } else if (compare == 5 && bonusMatch) {
            return FIVE_BONUS_COMPARE++;
        } else if (compare == 5) {
            return FIVE_COMPARE++;
        } else if (compare == 4) {
            return FOUR_COMPARE++;
        } else if (compare == 3) {
            return THREE_COMPARE++;
        }
        return 0;
    }

    public boolean checkBonus(Lotto lotto, String bonusNum) {
        return lotto.getNumbers().contains(Integer.parseInt(bonusNum));
    }

    public double getRate(int purchaseAmount) {
        return Math.round(calculateRate() * 100 / purchaseAmount);
    }

    public long calculateRate() {
        return Rank.THREE_RANK.getPrice() * THREE_COMPARE +
                Rank.FOUR_RANK.getPrice() * FOUR_COMPARE +
                Rank.FIVE_RANK.getPrice() * FIVE_COMPARE +
                Rank.FIVE_BONUS_RANK.getPrice() * FIVE_BONUS_COMPARE +
                Rank.SIX_RANK.getPrice() * SIX_COMPARE;
    }
}
