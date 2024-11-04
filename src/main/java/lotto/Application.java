package lotto;

import java.util.*;

public class Application {
    private static int getCost() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = camp.nextstep.edu.missionutils.Console.readLine();

        try {
            int cost = Integer.parseInt(input);
            return cost;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }

    private static void vaildateCost(int cost) {
        if (cost <= 0 || cost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000 단위의 자연수만 입력할 수 있습니다.");
        }
    }

    private static int getAmount() {
        while (true) {
            try {
                int cost = getCost();
                vaildateCost(cost);
                int amount = cost / 1000;
                return amount;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Lotto> buyLottos(int amount) {
        System.out.printf("\n%d개를 구매했습니다.\n", amount);
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
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String[] inputs = camp.nextstep.edu.missionutils.Console.readLine().split(",");

            try {
                List<Integer> winningNumbers = parseWinningNumbers(inputs);
                vaildateWinningNumbers(winningNumbers);
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
                throw new IllegalArgumentException("[ERROR] 입력 형식이 잘못되었습니다.");
            }
        }

        return winningNumbers;
    }

    private static void vaildateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 6개 입력해주세요.");
        }

        for (int winningNumber : winningNumbers) {
            if (winningNumber < 1 || winningNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1~45 입니다.");
            }
        }
    }

    private static boolean[] flagWinningNumbers(List<Integer> winningNumbers) {
        boolean[] winningNumberFlags = new boolean[46];

        for (int winningNumber : winningNumbers) {
            winningNumberFlags[winningNumber] = true;
        }

        return winningNumberFlags;
    }

    public static void main(String[] args) {
        int amount = getAmount();
        List<Lotto> lottos = buyLottos(amount);
        printLottos(lottos);
        boolean[] winningNumberFlags = getWinningNumbers();
    }
}
