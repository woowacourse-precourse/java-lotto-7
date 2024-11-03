package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.List;

enum LottoMatchCount {
    MATCH_THREE(3, 5000),
    MATCH_FOUR(4, 50000),
    MATCH_FIVE(5, 1500000),
    MATCH_FIVE_WITH_BONUS(5, 30000000),
    MATCH_SIX(6, 2000000000);

    private final int matchCount;
    private final int rewardAmount;
    private int count;

    LottoMatchCount(int matchCount, int rewardAmount) {
        this.matchCount = matchCount;
        this.rewardAmount = rewardAmount;
        this.count = 0;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getCount() {
        return count;
    }

    public int getRewardAmount() {
        return rewardAmount;
    }

    public static void incrementCount(int matchCount, boolean hasBonus) {
        for (LottoMatchCount lottoMatchCount : values()) {
            if (lottoMatchCount.matchCount != matchCount) continue;

            if(!hasBonus || matchCount != 5) {
                lottoMatchCount.count+=1;
                return;
            }

            if(lottoMatchCount == MATCH_FIVE_WITH_BONUS) {
                lottoMatchCount.count+=1;
                return;
            }

        }
    }

    public static int calculateTotalReward() {
        int totalReward = 0;
        for (LottoMatchCount match : values()) {
            totalReward += match.count * match.rewardAmount;
        }
        return totalReward;
    }

}

public class Application {
    static int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    private static Integer[] convertToInteger(String[] input) {
        Integer[] values = new Integer[6];
        for(int i = 0; i < 6; i++) {
            try {
                values[i] = Integer.parseInt(input[i].trim());
            }
            catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
            }
        }
        return values;
    }

    static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    static void validateStringLength(String[] input) {
        if(input.length != 6) {
            throw new IllegalArgumentException("[ERROR] 번호 6개를 입력해야 합니다.");
        }
    }

    static void validateLottoNumbers(Integer[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            validateLottoNumber(numbers[i]);
            validateDistinctNumbers(numbers, i, numbers[i]);
        }
    }

    static void validateLottoNumber(int n) {
        if (n < 1 || n > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateDistinctNumbers(Integer[] numbers, int index, int number) {
        for(int i = 0; i < index; i++) {
            if (numbers[i].equals(number)){
                throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
            }
        }
    }

    static List<Integer> generateRandomNumbers(){
        List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        randomNumbers.sort(Integer::compareTo);
        return randomNumbers;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean isValid = false;

        int amount = 0;
        while(!isValid) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();
            try {
                amount = convertToInteger(input);
                validateAmount(amount);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println();


        int n = amount / 1000;
        Lotto[] lottos = new Lotto[n];

        for(int i = 0; i < n; i++){
            List<Integer> numbers = generateRandomNumbers();
            lottos[i] = new Lotto(numbers);
        }

        System.out.printf("%d개를 구매했습니다.%n", n);
        for(int i = 0; i < n; i++){
            System.out.println(lottos[i].getNumbers());
        }

        System.out.println();

        isValid = false;
        Integer[] winningNumbers = new Integer[6];
        while(!isValid) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine();
            try {
                String[] values = input.split(",");
                validateStringLength(values);

                winningNumbers = convertToInteger(values);

                validateLottoNumbers(winningNumbers);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println();

        isValid = false;
        int bonusNumber = 0;
        while(!isValid) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = Console.readLine();
            try {
                bonusNumber = convertToInteger(input);
                validateLottoNumber(bonusNumber);
                validateDistinctNumbers(winningNumbers, 6, bonusNumber);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for(int i = 0; i < n; i++) {
            int matchingCount = lottos[i].countMatchingNumber(List.of(winningNumbers));
            boolean hasBonus = lottos[i].isMatchingBonusNumber(bonusNumber);
            LottoMatchCount.incrementCount(matchingCount, hasBonus);
        }

        int totalReward = LottoMatchCount.calculateTotalReward();

        System.out.printf("%d개 일치 (5,000원) - %d개%n",
                LottoMatchCount.MATCH_THREE.getMatchCount(), LottoMatchCount.MATCH_THREE.getCount());
        System.out.printf("%d개 일치 (50,000원) - %d개%n",
                LottoMatchCount.MATCH_FOUR.getMatchCount(), LottoMatchCount.MATCH_FOUR.getCount());
        System.out.printf("%d개 일치 (1,500,000원) - %d개%n",
                LottoMatchCount.MATCH_FIVE.getMatchCount(), LottoMatchCount.MATCH_FIVE.getCount());
        System.out.printf("%d개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n",
                LottoMatchCount.MATCH_FIVE_WITH_BONUS.getMatchCount(), LottoMatchCount.MATCH_FIVE_WITH_BONUS.getCount());
        System.out.printf("%d개 일치 (2,000,000,000원) - %d개%n",
                LottoMatchCount.MATCH_SIX.getMatchCount(), LottoMatchCount.MATCH_SIX.getCount());

        double profitRate = ((double) totalReward / amount) * 100;
        profitRate = Math.round(profitRate * 100) / 100.0;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);

    }
}

