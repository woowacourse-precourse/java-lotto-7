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
        int[] rankCount = new int[PrizeMoneyByRank.values().length];
        int myPorfit = 0;
        for (int[] result : matchPoints) {
            PrizeMoneyByRank rank = PrizeMoneyByRank.getRankByMatchCount(result[0], result[1]);
            rankCount[rank.ordinal()]++;
        }

        for (PrizeMoneyByRank rank : PrizeMoneyByRank.values()) {
            if (rank != PrizeMoneyByRank.TRASH) {
                System.out.printf("%d개 일치 (%d원) - %d개%n", rank.getMatchCount(), rank.getPrizeMoney(), rankCount[rank.ordinal()]);
                myPorfit += rank.getPrizeMoney()*rankCount[rank.ordinal()];
            }
        }
        myProfitRate(payMoney,myPorfit);

    }
    public static double myProfitRate(double payMoney, double myProfit){
        double profitRate = myProfit/payMoney*100;
        System.out.println("총 수익률은 "+Math.round(profitRate*10/10)+"%입니다.");
        return profitRate;
    }
}



