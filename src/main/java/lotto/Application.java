package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;

public class Application {

    public static List<Lotto> lottos = new ArrayList<>();
    public static Lotto winningLotto;
    public static int bonusNumber;
    public static Map<Rank, Integer> rankCounter = new TreeMap<>();

    public static int stringToNum(String input) {
        try {
            int num = Integer.parseInt(input);
            return num;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.");
        }
    }

    public static int inputAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int lotto_cost = stringToNum(readLine());
                return lotto_cost;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void makeLotto(int lotto_cost) {
        for (int i = lotto_cost; i - 1000 >= 0; i -= 1000) {
            Lotto element = new Lotto(pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(element);
        }
    }

    public static void outputLottoNumbers() {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.printNumbers());
        }
    }

    public static void buyLotto() {
        int lotto_cost = inputAmount();
        makeLotto(lotto_cost);
        outputLottoNumbers();
    }

    public static void checkRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지만 입력가능합니다.");
        }
    }

    public static List<Integer> stringToNumbers(List<String> numbers_string) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (String e : numbers_string) {
            int element = stringToNum(e);
            // checkRange(element);
            numbers.add(element);
        }
        return numbers;
    }

    public static void makeWinningLotto() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = readLine();
                List<Integer> numbers = stringToNumbers(Arrays.asList(input.split(",")));
                winningLotto = new Lotto(numbers);
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void checkBounsVaild(int bonus) {
        for (Integer e : winningLotto) {
            if (e == bonus) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호가 로또 번호와 중복입니다.");
            }
        }
    }

    public static void makeBonusNum() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int n = stringToNum(readLine());
                checkRange(n);
                checkBounsVaild(n);
                bonusNumber = n;
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void initializeMap() {
        for (Rank rank : Rank.values()) {
            rankCounter.put(rank, 0);
        }
    }

    public static void checkWinning() {
        initializeMap();

        int winningCount = 0;
        for (Lotto lotto : lottos) {
            winningCount = 0;
            for (Integer num : winningLotto) {
                winningCount += lotto.checkNumber(num);
            }

            Rank rank = Rank.checkRank(winningCount, lotto.checkNumber(bonusNumber));
            rankCounter.put(rank, rankCounter.get(rank) + 1);
        }
    }

    public static void inputWinningLotto() {
        makeWinningLotto();
        makeBonusNum();
    }

    public static double calculateBenfit() {
        double benefit = 0;
        for (Rank rank : rankCounter.keySet()) {
            if (rank != Rank.MISS)
                benefit += Rank.calculatePrize(rank, rankCounter.get(rank));
        }
        return benefit;
    }

    public static void printLottoOutput() {
        System.out.println("당첨 통계");
        System.out.println("---");
        rankCounter.forEach((rank, count) -> {
            if (rank != Rank.MISS)
                Rank.printRankPrize(rank, count);
        });
        double benefit = Math.round(calculateBenfit() / (10000 * lottos.size()) * 100 * 100);
        System.out.printf("총 수익률은 %.2f%%입니다.\n", benefit / 100);
    }

    public static void main(String[] args) {
        buyLotto();
        inputWinningLotto();
        checkWinning();
        printLottoOutput();
    }
}
