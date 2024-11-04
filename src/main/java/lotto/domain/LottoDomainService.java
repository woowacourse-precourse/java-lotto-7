package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoDomainService {
    private LottoFactory lottoFactory = new LottoFactory();
    private List<Lotto> lottoList = new ArrayList<>();

    private int hit6 = 0;
    private int hit5WithBonus = 0;
    private int hit5 = 0;
    private int hit4 = 0;
    private int hit3 = 0;

    int hit6Money = 2_000_000_000;
    int hit5WithBonusMoney = 30_000_000;
    int hit5WMoney = 1_500_000;
    int hit4WMoney = 50_000;
    int hit3WMoney = 5_000;

    public List<Lotto> purchaseLotto(int count) {
        System.out.println(count+"개를 구매했습니다.");
        lottoList = lottoFactory.createLotto(count);
        return lottoList;
    }

    public void lottoResult(List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> moneyList = lottoList.stream().map(lotto -> {
            int hitCount = compareWinningNumbers(lotto, winningNumbers);
            return hitCountToMoney(hitCount, lotto, bonusNumber);
        }).toList();
        plusHitCount(moneyList);
        printStats();
    }

    private void printStats() {
        System.out.println("3개 일치 (5,000원) - " + hit3 + "개");
        System.out.println("4개 일치 (50,000원) - " + hit4 + "개");
        System.out.println("5개 일치 (1,500,000원) - " + hit5 + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + hit5WithBonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + hit6 + "개");

    }

    private void plusHitCount(List<Integer> moneyList) {
        moneyList.stream().forEach( money -> {
            if (money == hit6Money) {
                hit6 += 1;
            }
            if (money == hit5WithBonusMoney) {
                hit5WithBonus += 1;
            }
            if (money == hit5WMoney) {
                hit5 += 1;
            }
            if (money == hit4WMoney) {
                hit4 += 1;
            }
            if (money == hit3WMoney) {
                hit3 += 1;
            }
        });
    }

    private int compareWinningNumbers(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers().stream().filter(n->Collections.binarySearch(winningNumbers, n) >=0).count();
    }

    private int hitCountToMoney(int hitCount, Lotto lotto, int bonusNumber) {
        if (hitCount == 6) {
            return hit6Money;
        }
        if (hitCount == 5 && (Collections.binarySearch(lotto.getNumbers(), bonusNumber) >= 0)) {
            return hit5WithBonusMoney;
        }
        if (hitCount == 5) {
            return hit5WMoney;
        }
        if (hitCount == 4) {
            return hit4WMoney;
        }
        if (hitCount == 3) {
            return hit3WMoney;
        }
        return 0;
    }

    public double profitRate(int purchaseMoney) {
        long totalPrizeMoney = (long)(hit6 * hit6Money) +
                (long)(hit5WithBonus * hit5WithBonusMoney) +
                (long) (hit5 * hit5WMoney) +
                (long) (hit4 * hit4WMoney) +
                (long) (hit3 * hit3WMoney);
        double rate = ((double)totalPrizeMoney/purchaseMoney) * 100;
        return Math.round(rate * 100) / 100.0;
    }
}
