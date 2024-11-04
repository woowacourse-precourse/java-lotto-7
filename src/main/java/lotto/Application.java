package lotto;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseMoney = purchaseLotto();
        int lottoQuantity = purchaseMoney / 1000;
        System.out.println();

        List<Lotto> lottoIssue = new ArrayList<>();
        System.out.println(lottoQuantity + "개를 구매했습니다.");
        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(temp);
            Lotto lotto = new Lotto(temp);
            lottoIssue.add(lotto);
            System.out.println(temp);
        }
        System.out.println();

        Lotto winningNumbers = winningNumbers();
        System.out.println();

        int bonusNumber = bonusNumber(winningNumbers);
        System.out.println();

        int[] winningLottos = new int[5];
        System.out.println("당첨 통계");
        System.out.println("---");

        for (int i = 0; i < lottoQuantity; i++) {
            int temp = calculate(i, lottoIssue, winningNumbers, bonusNumber);
            if (temp < 5) {
                winningLottos[temp]++;
            }
        }

        System.out.println("3개 일치 (5,000원) - " + winningLottos[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + winningLottos[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningLottos[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningLottos[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningLottos[4] + "개");

        int profit = winningLottos[0] * 5000 +
                winningLottos[1] * 50000 +
                winningLottos[2] * 1500000 +
                winningLottos[3] * 30000000 +
                winningLottos[4] * 2000000000;
        int cost = purchaseMoney;
        double profitRate = Math.round((profit / Double.valueOf(cost) * 100) * 100) / 100.0;
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    public static int purchaseLotto() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                String purchaseMoneyStr = readLine();

                boolean isInteger = purchaseMoneyStr.chars().allMatch(Character::isDigit);
                if (!isInteger) {
                    throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
                }

                int purchaseMoney = Integer.parseInt(purchaseMoneyStr);

                if ((purchaseMoney % 1000) != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
                }

                return purchaseMoney;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    public static Lotto winningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요");
                String winningNumberStr = readLine();

                String[] winningNumbers = winningNumberStr.split(",");

                List<Integer> numbers = new ArrayList<>();
                for (int i = 0; i < winningNumbers.length; i++) {
                    int temp = Integer.parseInt(winningNumbers[i]);
                    rangeNum(temp);
                    numbers.add(temp);
                }
                Collections.sort(numbers);
                Lotto lotto = new Lotto(numbers);

                return lotto;

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 형식에 맞게 입력해주세요.");
                System.out.println();

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    public static int rangeNum(int temp) throws IllegalArgumentException {
        if (temp > 45 || temp < 1) {
            throw new IllegalArgumentException("[ERROR] 1~45의 숫자를 입력하세요.");
        }
        return 0;
    }

    public static int bonusNumber(Lotto winningNumbers) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String bonusNumberStr = readLine();
                int bonusNumber = Integer.parseInt(bonusNumberStr);

                if (winningNumbers.getNumbers().contains(bonusNumber)) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호와 겹치면 안됩니다.");
                }

                if (bonusNumber > 45 || bonusNumber < 1) {
                    throw new IllegalArgumentException("[ERROR] 1~45의 숫자를 입력하세요.");
                }

                return bonusNumber;

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    public static int calculate(int i, List<Lotto> lottoIssue, Lotto winningNumbers, int bonusNumber) {
        int count = 0;
        for (int j = 0; j < 6; j++) {
            if (lottoIssue.get(i).getNumbers().contains(winningNumbers.getNumbers().get(j))) {
                count++;
            }
        }

        if (count == 3) {
            return 0;

        }
        if (count == 4) {
            return 1;

        }
        if (count == 5) {
            int temp = fivePlusBonus(i, lottoIssue, bonusNumber);
            if (temp < 5) {
                return temp;
            }

            return 2;
        }
        if (count == 6) {
            return 4;
        }
        return 5;
    }

    public static int fivePlusBonus(int i, List<Lotto> lottoIssue, int bonusNumber) {
        for (int j = 0; j < 6; j++) {
            if (lottoIssue.get(i).getNumbers().get(j) == bonusNumber) {
                return 3;
            }
        }
        return 5;
    }
}