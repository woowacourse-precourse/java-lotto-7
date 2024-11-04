package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    private static final int PRICEPERLOTTO = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int payMoney = getPayMoney();
        int lottoPurchasesNum = calculateLottoPurchasesNum(payMoney);
        List<Lotto> myLottoNum = myLottoNum(lottoPurchasesNum);
        List<Integer> luckyNum = getLuckyNum();
        int bonusNumber = getBonusNumber(luckyNum);
        int[][] result = matchByLotto(luckyNum, myLottoNum, lottoPurchasesNum, bonusNumber);
        displayResults(result,payMoney);

    }

    public static List<Integer> lottoNumberGenerator() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumber;
    }

    public static int getPayMoney() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String unCheckedPayMoney = Console.readLine();
                int payMoney = checkPayMoney(unCheckedPayMoney);
                return payMoney;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 정수만 입력가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int checkPayMoney(String unCheckedPayMoney) {
        int checkPayMoney = Integer.parseInt(unCheckedPayMoney);
        if (checkPayMoney < PRICEPERLOTTO || checkPayMoney % PRICEPERLOTTO > 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액은 1000으로 나누어 떨어져야합니다.");
        }
        return checkPayMoney;
    }

    public static int calculateLottoPurchasesNum(int payMoney) {
        int lottoPurchasesNum = payMoney / PRICEPERLOTTO;
        System.out.println(lottoPurchasesNum + "개를 구매했습니다.");
        return lottoPurchasesNum;
    }

    public static List<Lotto> myLottoNum(int lottoPurchasesNum) {
        List<Lotto> myLottoNum = new ArrayList<>();
        for (int i = 1; i < lottoPurchasesNum + 1; i++) {
            Lotto lotto = new Lotto(lottoNumberGenerator());
            myLottoNum.add(lotto);
            System.out.println(lotto);
        }
        return myLottoNum;
    }

    public static List<Integer> getLuckyNum() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String unCheckedLuckyNumber = Console.readLine();
                List<Integer> luckyNum = checkLuckyNum(unCheckedLuckyNumber);
                new Lotto(luckyNum);
                return luckyNum;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 로또 번호는 정수만 입력가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> checkLuckyNum(String unCheckedLuckyNumber) {
        StringTokenizer tokenizer = new StringTokenizer(unCheckedLuckyNumber, ",");
        List<Integer> checkLuckyNum = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            int token = Integer.parseInt(tokenizer.nextToken());
            checkLuckyNum.add(token);
        }
        return checkLuckyNum;
    }

    public static int getBonusNumber(List<Integer> luckyNum) {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String unCheckedBonusNumber = Console.readLine();
                int bonusNumber = checkBonusNumber(unCheckedBonusNumber,luckyNum);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 정수만 입력가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int checkBonusNumber(String unCheckedBonusNumber,List<Integer> luckyNum) {
        int checkBonusNumber = Integer.parseInt(unCheckedBonusNumber);
        if (checkBonusNumber < 0 || checkBonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (luckyNum.contains(checkBonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        return checkBonusNumber;
    }

    public static int getMatchPoint(List<Integer> luckyNum, List<Integer> lottoNum) {
        int matchPoint = 0;
        for (int i = 0; i < luckyNum.size(); i++) {
            if (lottoNum.contains(luckyNum.get(i))) {
                matchPoint += 1;
            }
        }
        return matchPoint;
    }

    public static int[][] matchByLotto(List<Integer> luckyNum, List<Lotto> myLottoNum, int purchaseNum, int bonusNum) {
        int[][] matchPoints = new int[purchaseNum][2];
        for (int i = 0; i < purchaseNum; i++) {
            int matchPoint = getMatchPoint(luckyNum, myLottoNum.get(i).getNumbers());
            matchPoints[i][0] = matchPoint;
            if (matchPoint == 5) {
                matchPoints[i][1] = calculateSecondtoThird(myLottoNum.get(i).getNumbers(), bonusNum);
            }
        }
        return matchPoints;
    }

    public static int calculateSecondtoThird(List<Integer> myLottoNum, int bonusNumber) {
        for (int i = 0; i < myLottoNum.size(); i++) {
            if (myLottoNum.contains(bonusNumber)) {
                return 1;
            }
        }
        return 0;
    }

    public static void displayResults(int[][] matchPoints, int payMoney) {
        int[] rankCounts = new int[PrizeMoneyByRank.values().length];

        for (int[] result : matchPoints) {
            PrizeMoneyByRank rank = PrizeMoneyByRank.getRankByMatchCount(result[0], result[1]);
            rankCounts[rank.ordinal()]++;
        }

        printStatistics(rankCounts);
        double totalProfit = calculateTotalProfit(rankCounts);
        displayProfitRate(payMoney, totalProfit);
    }

    public static void printStatistics(int[] rankCounts) {
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (%d원) - %d개%n", PrizeMoneyByRank.FIFTH.getPrizeMoney(), rankCounts[PrizeMoneyByRank.FIFTH.ordinal()]);
        System.out.printf("4개 일치 (%d원) - %d개%n", PrizeMoneyByRank.FOURTH.getPrizeMoney(), rankCounts[PrizeMoneyByRank.FOURTH.ordinal()]);
        System.out.printf("5개 일치 (%d원) - %d개%n", PrizeMoneyByRank.THIRD.getPrizeMoney(), rankCounts[PrizeMoneyByRank.THIRD.ordinal()]);
        System.out.printf("5개 일치, 보너스 볼 일치 (%d원) - %d개%n", PrizeMoneyByRank.SECOND.getPrizeMoney(), rankCounts[PrizeMoneyByRank.SECOND.ordinal()]);
        System.out.printf("6개 일치 (%d원) - %d개%n", PrizeMoneyByRank.FIRST.getPrizeMoney(), rankCounts[PrizeMoneyByRank.FIRST.ordinal()]);
    }

    public static double calculateTotalProfit(int[] rankCounts) {
        double totalProfit = 0;
        for (PrizeMoneyByRank rank : PrizeMoneyByRank.values()) {
            if (rank != PrizeMoneyByRank.TRASH) {
                totalProfit += rank.getPrizeMoney() * rankCounts[rank.ordinal()];
            }
        }
        return totalProfit;
    }

    public static void displayProfitRate(double payMoney, double totalProfit) {
        double profitRate = totalProfit / payMoney * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}