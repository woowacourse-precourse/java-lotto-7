package lotto;

import java.util.*;

public class Application {
    private static int getCost() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = camp.nextstep.edu.missionutils.Console.readLine();

            try {
                int cost = parseNumber(input);
                validateCost(cost);
                return cost;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateCost(int cost) {
        if (cost <= 0 || cost % 1000 != 0) {
            throw new IllegalArgumentException(ERROR.UNIT.getMessage());
        }
    }

    private static List<Lotto> buyLottos(int amount) {
        System.out.printf("%d개를 구매했습니다.\n", amount);
        List<Lotto> lottos = new ArrayList<>();

        while (amount-- > 0) {lottos.add(new Lotto(
                    camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return lottos;
    }

    private static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lotto.printNumbers();
        }
    }

    private static boolean[] getWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String[] inputs = camp.nextstep.edu.missionutils.Console.readLine().split(",");

            try {
                List<Integer> winningNumbers = parseWinningNumbers(inputs);
                validateWinningNumbers(winningNumbers);
                return flagWinningNumbers(winningNumbers);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> parseWinningNumbers(String[] inputs) {
        List<Integer> winningNumbers = new ArrayList<>();

        for (String input : inputs) {
            try {
                int winningNumber = Integer.parseInt(input);
                winningNumbers.add(winningNumber);
            } catch (Exception e) {
                throw new IllegalArgumentException(ERROR.FORMAT.getMessage());
            }
        }

        return winningNumbers;
    }

    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR.COUNT.getMessage());
        }

        for (int winningNumber : winningNumbers) {
            Lotto.validateNumber(winningNumber);
        }
    }

    private static boolean[] flagWinningNumbers(List<Integer> winningNumbers) {
        boolean[] winningNumberFlags = new boolean[46];

        for (int winningNumber : winningNumbers) {
            if (winningNumberFlags[winningNumber]) {
                throw new IllegalArgumentException(ERROR.DUPLICATE.getMessage());
            }
            winningNumberFlags[winningNumber] = true;
        }

        return winningNumberFlags;
    }

    private static int getBonusNumber(boolean[] winningNumberFlags) {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = camp.nextstep.edu.missionutils.Console.readLine();

            try {
                int bonusNumber = parseNumber(input);
                Lotto.validateNumber(bonusNumber);
                validateBonusNumber(winningNumberFlags, bonusNumber);
                return bonusNumber;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private static void validateBonusNumber(boolean[] winningNumberFlags, int bonusNumber) {
        if (winningNumberFlags[bonusNumber]) {
            throw new IllegalArgumentException(ERROR.DUPLICATE.getMessage());
        }
    }

    private static int parseNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            return number;
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR.PARSE.getMessage());
        }
    }

    private static int[] checkWinnings(List<Lotto> lottos, boolean[] winningNumberFlags, int bonusNumber) {
        int[] winningCount = new int[6];

        for (Lotto lotto : lottos) {
            RANK rank = lotto.checkWinning(winningNumberFlags, bonusNumber);
            winningCount[rank.getIndex()]++;
        }

        return winningCount;
    }

    private static void printWinnings(int[] winningCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", winningCount[5]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", winningCount[4]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", winningCount[3]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", winningCount[2]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", winningCount[1]);
    }

    private static long sumPrize(int[] winningCount) {
        long prizeSum = 0;

        for (RANK rank : RANK.values()) {
            prizeSum += rank.getPrize() * winningCount[rank.getIndex()];
        }

        return prizeSum;
    }

    private static void printROR(int cost, long prizeSum) {
        double ROR = (double)prizeSum / cost * 100;
        System.out.printf("총 수익률은 %s%%입니다.\n", String.format("%.1f", ROR));
    }

    public static void main(String[] args) {
        //구입 금액 입력
        int cost = getCost();
        int amount = cost / 1000;
        System.out.println();

        //발행한 로또 출력
        List<Lotto> lottos = buyLottos(amount);
        printLottos(lottos);
        System.out.println();

        //당첨 번호 입력
        boolean[] winningNumberFlags = getWinningNumbers();
        System.out.println();

        //보너스 번호 입력
        int bonusNumber = getBonusNumber(winningNumberFlags);
        System.out.println();

        //당첨 통계 출력
        int[] winningCount = checkWinnings(lottos, winningNumberFlags, bonusNumber);
        printWinnings(winningCount);

        //수익률 출력
        long prizeSum = sumPrize(winningCount);
        printROR(cost, prizeSum);
    }
}
