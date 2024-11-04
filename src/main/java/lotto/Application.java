package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static boolean hasBonusNumber = false;
    private static LinkedHashMap<Integer, Integer> winningRecord = new LinkedHashMap<>(Map.of(3,0,4,0,5,0,6,0,7,0));
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int purchasePrice = inputLottoPurchaseAmount();
        int lottoCount = calculateLottoCount(purchasePrice);

        System.out.println(lottoCount + "개를 구매했습니다.");

        List<Lotto> lottoPurchaseList = purchaseRandomLottoTickets(lottoCount);
        printLottoPurchaseList(lottoPurchaseList);

        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto lottoNumbers = inputWinningLottoNumbers();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = inputBonusNumber(lottoNumbers);

        matchLottoNumbers(lottoPurchaseList, lottoNumbers, bonusNumber);

        System.out.println("당첨 통계");
        System.out.println("---");
        printLottoStatistics();

        printRateOfReturn(purchasePrice);
    }

    public static int inputLottoPurchaseAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int purchasePrice = Integer.parseInt(readLine());
            if (!validateCount(purchasePrice)) {
                throw new IllegalArgumentException();
            }
            return purchasePrice;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해주세요. ");
            return inputLottoPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLottoPurchaseAmount();
        }
    }

    public static int calculateLottoCount(int price) {
        int count = 0;
        count = price / 1000;
        return count;
    }

    public static boolean validateCount(int price) {
        if (price == 0) {
            throw new IllegalArgumentException("[ERROR] 로또 1장의 가격은 1000원 입니다. 금액을 다시 입력해 주세요.");
        }
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어지지 않습니다. 금액을 다시 입력해 주세요.");
        }
        return true;
    }

    public static List<Lotto> purchaseRandomLottoTickets(int count) {
        List<Lotto> lottoPurchaseList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            lottoPurchaseList.add(lotto);
        }
        return lottoPurchaseList;
    }

    public static void printLottoPurchaseList(List<Lotto> LottoPurchaseList) {
        for (Lotto lotto : LottoPurchaseList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static Lotto inputWinningLottoNumbers() {
        try {
            String[] s = readLine().split(",");
            List<Integer> w = new ArrayList<>();
            for (String str : s) {
                w.add(Integer.parseInt(str));
            }
            Lotto lotto = new Lotto(w);
            return lotto;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요");
            return inputWinningLottoNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningLottoNumbers();
        }
    }

    public static int inputBonusNumber(Lotto lotto) {
        try {
            int bonusNumber = Integer.parseInt(readLine());
            isBonusNumber(bonusNumber);
            isDuplicatePresent(lotto, bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요");
            return inputBonusNumber(lotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(lotto);
        }
    }

    public static void isBonusNumber(int input) {
        if (!(input > 0 && input <= 45)) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 값을 입력해주세요.");
        }
    }

    public static void isDuplicatePresent(Lotto lotto, int input) {
        for (int n : lotto.getNumbers()) {
            if (n == input) {
                throw new IllegalArgumentException("[ERROR] 중복된 값입니다. 다시 입력해 주세요. ");
            }
        }
    }
    public static void matchLottoNumbers(List<Lotto> lottoPurchaseList, Lotto list, int bonusNumber) {

        int matchedCount = 0;
        for (int i = 0; i < lottoPurchaseList.size(); i++) {
            matchedCount = countMatchedLottoNumbers(lottoPurchaseList.get(i).getNumbers(), list, bonusNumber);
            updateWinningStatistics(matchedCount);
        }
    }
    public static int countMatchedLottoNumbers(List<Integer> lottoList, Lotto list, int bonusNumber) {
        int num = 0;
        for (int i = 0; i < list.lottoSize(); i++) {
            if (lottoList.indexOf(list.getNumber(i)) != -1) {
                num++;
            }
            if (lottoList.get(i) == bonusNumber) {
                hasBonusNumber = true;
            }
        }
        return num;
    }
    public static void updateWinningStatistics(int num) {
        Iterator<Map.Entry<Integer, Integer>> iterator = winningRecord.entrySet().iterator();

        for (; iterator.hasNext(); ) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getKey() == num) {
                winningRecord.put(entry.getKey(), entry.getValue() + 1);
                updateWinningCountWithBonus();
            }
        }
    }
    public static void updateWinningCountWithBonus() {
        for (Map.Entry<Integer, Integer> hitLotto : winningRecord.entrySet()) {
            if (hasBonusNumber && hitLotto.getKey() == 5 && hitLotto.getValue() >= 1) {
                winningRecord.put(hitLotto.getKey(), hitLotto.getValue() - 1);
                winningRecord.put(hitLotto.getKey() + 2, hitLotto.getValue() + 1);
            }
        }
    }
    public static void printLottoStatistics() {

        System.out.println("3개 일치 (5,000원) - " + winningRecord.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + winningRecord.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningRecord.get(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningRecord.get(7) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningRecord.get(6) + "개");

    }
    public static void printRateOfReturn(int purchasePrice) {
        double rate = 0;

        double sum = 5000 * winningRecord.get(3) + 50000 * winningRecord.get(4) + 1500000 * winningRecord.get(5) + 30000000 * winningRecord.get(7) + 2000000000 * winningRecord.get(6);
        rate = (sum / purchasePrice) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.", rate);

    }

}
