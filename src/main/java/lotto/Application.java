package lotto;


import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            lottoProcess();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            lottoProcess();
        }
    }

    public static void lottoProcess() {
        // 1. 로또 구입금액을 입력받고 예외처리한다
        PurchaseAmount amount = UserInputConsole.readPurchaseAmount();
        int purchasedLottoCnt = amount.amount() / 1000;

        // 2. 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
        System.out.println(purchasedLottoCnt + "개를 구매했습니다.");

        ArrayList<Lotto> purchasedLotto = new ArrayList<>();
        for (int i = 0; i < purchasedLottoCnt; i++) {
            List<Integer> numbers = generateUniqueNumbers();
            Lotto lotto = new Lotto(numbers);
            purchasedLotto.add(lotto);
            System.out.println(lotto);
        }

        // 3. 로또 당첨 번호를 입력 받는다.
        Lotto lottoWinningNumbers = UserInputConsole.readLottoWinningNumber();

        // 4. 보너스 번호를 입력 받는다.
        int bonusNumber = UserInputConsole.readBonusNumber(lottoWinningNumbers);

        // 5. 당첨 통계를 출력한다.
        System.out.println(calculateLottoWinningStatics(purchasedLotto, lottoWinningNumbers, bonusNumber));
    }

    private static List<Integer> generateUniqueNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Set<Integer> uniqueSet = new HashSet<>(numbers);

        while (uniqueSet.size() < 6) {
            int newNumber = Randoms.pickUniqueNumbersInRange(1, 45, 1).getFirst();
            uniqueSet.add(newNumber);
        }
        return new ArrayList<>(uniqueSet);
    }

    private static String calculateLottoWinningStatics(ArrayList<Lotto> purchasedLotto, Lotto lottoWinningNumbers, int bonusNumber) {
        int winThree = 0, winFour = 0, winFive = 0, winSix = 0, winBonus = 0;

        // 당첨 번호 목록
        List<Integer> winningNumbers = lottoWinningNumbers.getNumbers();

        // 구매한 로또와 당첨번호를 비교하며 당첨 등수를 계산
        for (Lotto lotto : purchasedLotto) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int matchCount = 0;

            // 당첨 번호와 일치하는 번호의 개수를 셉니다.
            for (int number : lottoNumbers) {
                if (winningNumbers.contains(number)) {
                    matchCount++;
                }
            }

            // 등수에 따라 카운트를 증가시킵니다.
            if (matchCount == 6) {
                winSix++;
            } else if (matchCount == 5) {
                // 보너스 번호가 포함되어 있는지 확인합니다.
                if (lottoNumbers.contains(bonusNumber)) {
                    winBonus++;
                } else {
                    winFive++;
                }
            } else if (matchCount == 4) {
                winFour++;
            } else if (matchCount == 3) {
                winThree++;
            }
            // 2개 이하 일치 시 당첨되지 않으므로 무시합니다.
        }

        // 각 등수별 상금
        final int PRIZE_THREE = 5000;
        final int PRIZE_FOUR = 50000;
        final int PRIZE_FIVE = 1500000;
        final int PRIZE_BONUS = 30000000;
        final int PRIZE_SIX = 2000000000;

        // 총 상금 계산
        long totalPrize = (long) winThree * PRIZE_THREE
                + (long) winFour * PRIZE_FOUR
                + (long) winFive * PRIZE_FIVE
                + (long) winBonus * PRIZE_BONUS
                + (long) winSix * PRIZE_SIX;

        // 총 구매 금액 계산
        long totalPurchaseAmount = (long) purchasedLotto.size() * 1000;

        BigDecimal totalPrizeBD = BigDecimal.valueOf(totalPrize);
        BigDecimal totalPurchaseAmountBD = BigDecimal.valueOf(totalPurchaseAmount);
        BigDecimal winningStatic = totalPrizeBD.divide(totalPurchaseAmountBD, 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));

        return "당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - " + winThree + "개\n" +
                "4개 일치 (50,000원) - " + winFour + "개\n" +
                "5개 일치 (1,500,000원) - " + winFive + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + winBonus + "개\n" +
                "6개 일치 (2,000,000,000원) - " + winSix + "개\n" +
                "총 수익률은 " + winningStatic + "%입니다.";
    }
}
