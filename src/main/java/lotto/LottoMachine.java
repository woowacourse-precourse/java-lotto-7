package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import lotto.Lotto;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> purchasedLottos = new ArrayList<>();
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void purchaseLottos(int amount) {
        int count = amount / LOTTO_PRICE;
        System.out.printf("%d개를 구매했습니다.%n", count);
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            purchasedLottos.add(lotto);
            System.out.println(numbers);
        }
    }
    public void inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");
        winningNumbers = new ArrayList<>();
        for (String s : input) {
            winningNumbers.add(Integer.parseInt(s.trim()));
        }
    }

    public void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
    public void calculateResult(int purchaseAmount) {
        int[] matchCounts = new int[6];
        int totalPrize = 0;

        for (Lotto lotto : purchasedLottos) {
            int matchCount = countMatches(lotto.getNumbers(), winningNumbers);

            if (matchCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
                totalPrize += getPrize(5);
                matchCounts[5]++;
                continue;
            }
            if (matchCount >= 3) {
                matchCounts[matchCount - 3]++;
                totalPrize += getPrize(matchCount);
            }
        }
        displayResult(matchCounts);
        displayYield(totalPrize, purchaseAmount);
    }
    private int getPrize(int matchCount) {
        if (matchCount == 6) return 2_000_000_000;
        if (matchCount == 5) return 1_500_000;
        if (matchCount == 4) return 50_000;
        if (matchCount == 3) return 5_000;
        return 0;
    }
    private int countMatches(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private void displayResult(int[] matchCounts) {
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", matchCounts[0]);
        System.out.printf("4개 일치 (50,000원) - %d개%n", matchCounts[1]);
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", matchCounts[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", matchCounts[5]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", matchCounts[3]);
    }

    private void displayYield(int totalPrize, int purchaseAmount) {
        double yield = (double) totalPrize / purchaseAmount * 100;
        DecimalFormat df = new DecimalFormat("#, ##0.0");
        System.out.printf("총 수익률은 %s%%입니다.%n", df.format(yield));
    }


}
