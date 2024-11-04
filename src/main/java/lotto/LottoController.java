package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.round;

public class LottoController {
    private List<Lotto> lottos;
    private int purchaseCount;
    private WinningLotto winningLotto;
    private LottoPurchase lottoPurchase;
    private Map<Integer, Integer> winningList;
    private double winningRate;

    public LottoController() {
        lottos = new ArrayList<>();
        lottoPurchase = new LottoPurchase();
        winningList = new HashMap<>();
        initialWinningList();
    }

    //입력부터 출력에 관한 프로세스를 관리
    public void getStart() {
        while (true) {
            try {
                lottoPurchase.inputAmount();
                issueLotto(lottoPurchase.getPurchaseCount());
                printIssuedLottos();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                lottoPurchase.inputLottoNumber();
                updateWinningList(lottoPurchase.getWinningLotto());
                printWinningReport();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //수익률 관련 메서드
        calculateWinningRate();
        printWinningRage();
    }

    public LottoController(String Test) {
        lottos = new ArrayList<>();
        initialWinningList();
    }

    public void issueLotto(int purchaseCount) {
        this.purchaseCount = purchaseCount;

        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
    }

    public void printIssuedLottos() {
        System.out.printf("%d개를 구매했습니다.\n", purchaseCount);
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }

    private void initialWinningList() {
        for (int i = 0; i < 6; i++) {
            winningList.put(i, 0);
        }

    }

    public void updateWinningList(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        for (Lotto lotto : lottos) {
            int lottoRank = getRanking(lotto);
            winningList.put(lottoRank, winningList.getOrDefault(lottoRank, 0) + 1);
        }
    }

    public int getMatchCount(Lotto lotto) {
        int matchCount = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public int getRanking(Lotto lotto) {
        int matchCount = getMatchCount(lotto);
        return findRanking(lotto, matchCount);
    }

    public int findRanking(Lotto lotto, int matchCount) {
        if (matchCount == 6) {
            return 1; // 1등
        } else if (matchCount == 5) {
            if (lotto.getNumbers().contains(winningLotto.getBonusNumber())) {
                return 2; // 2등
            }
            return 3; // 3등
        } else if (matchCount == 4) {
            return 4; // 4등
        } else if (matchCount == 3) {
            return 5; // 5등
        }
        return 0; // 미당첨
    }

    public void printWinningReport() {
        List<Integer> winningListKeys = winningList.keySet().stream().sorted().toList();
        for (int key : winningListKeys) {
            if (key == 5) {
                System.out.printf("3개 일치 (5,000원) - %d개\n", winningList.get(key));
            } else if (key == 4) {
                System.out.printf("4개 일치 (50,000원) - %d개\n", winningList.get(key));
            } else if (key == 3) {
                System.out.printf("5개 일치 (1,500,000원) - %d개\n", winningList.get(key));
            } else if (key == 2) {
                System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", winningList.get(key));
            } else if (key == 1) {
                System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", winningList.get(key));
            }
        }

    }

    public double calculateWinningRate() {
        double totalWinningPrice = 0;

        for (int key : winningList.keySet()) {
            if (key == 1) {
                totalWinningPrice += 2000000000 * winningList.get(key);
            } else if (key == 2) {
                totalWinningPrice += 30000000 * winningList.get(key);
            } else if (key == 3) {
                totalWinningPrice += 1500000 * winningList.get(key);
            } else if (key == 4) {
                totalWinningPrice += 50000 * winningList.get(key);
            } else if (key == 5) {
                totalWinningPrice += 5000 * winningList.get(key);
            }
        }

        int totalPurchaseAmount = purchaseCount * 1000;

        if (totalPurchaseAmount == 0) {
            return 0;
        }

        double rate = Math.round(totalWinningPrice / totalPurchaseAmount * 1000) / 10.0;

        this.winningRate = rate;
        return this.winningRate;
    }

    public void printWinningRage() {
        System.out.println("총 수익률은 " + String.format("%.1f", winningRate) + "%입니다."); // 소수점 한 자리까지 포맷팅
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Integer, Integer> getWinningList() {
        return winningList;
    }
}