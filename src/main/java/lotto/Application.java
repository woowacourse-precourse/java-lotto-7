package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static final String error_message = "[ERROR]";
    private static final Map<Object, Integer> prizeMoney = new HashMap<>();
    private static final int tickPrice = 1000;

    static {
        prizeMoney.put(3, 5000);           // 3개 일치 (5,000원)
        prizeMoney.put(4, 50000);          // 4개 일치 (50,000원)
        prizeMoney.put(5, 1500000);        // 5개 일치 (1,500,000원)
        prizeMoney.put("bonus", 30000000);       // 5개 일치, 보너스 볼 일치 (30,000,000원)
        prizeMoney.put(6, 2000000000);     // 6개 일치 (2,000,000,000원)
    }

    public static void main(String[] args) {
        while (true) {
            try {
                int purchaseAmount = getPurchaseAmount();
                List<List<Integer>> numbers = makeRandomNumbers(purchaseAmount);
                List<Integer> lottoNumbers = getLottoNumbers();
                Integer bonusNumber = getBonusNumber();

                Lotto lotto = new Lotto(lottoNumbers);
                Map<Object, Integer> result = lotto.checkLottoWin(numbers, bonusNumber);

                int totalAmount = statistics(result);
                calculateReturnRate(purchaseAmount, totalAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void calculateReturnRate(int purchaseAmount, int totalAmount) {
        // 총 투자 금액 계산
        int purchaseMoney = purchaseAmount * tickPrice;

        // 수익률 계산
        double returnRate = 0; // 초기화
        if (purchaseMoney != 0) { // 구매 금액이 0이 아닌 경우에만 수익률 계산
            returnRate = ((double) totalAmount / purchaseMoney) * 100;
        }

        System.out.printf("총 수익률은 %.1f%%입니다.", returnRate);
    }

    private static int statistics(Map<Object, Integer> result) {
        int totalAmount = 0;
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Map.Entry<Object, Integer> entry : result.entrySet()) {
            resultStatistics(entry.getKey(), entry.getValue());
            totalAmount += (prizeMoney.get(entry.getKey()) * entry.getValue());
        }

        return totalAmount;
    }

    private static void resultStatistics(Object key, int count) {
        if ("bonus".equals(key)) {
            printBonusStatistics(count);
        }
        if (key instanceof Integer) {
            printRegularStatistics((Integer) key, count);
        }

    }

    private static void printRegularStatistics(int key, int count) {
        int prize = prizeMoney.getOrDefault(key, 0);
        System.out.printf("%d개 일치 (%s) - %d개%n", key, formatPrize(prize), count);
    }

    private static void printBonusStatistics(int count) {
        int bonusPrize = prizeMoney.get("bonus");
        System.out.printf("5개 일치, 보너스 볼 일치 (%s) - %d개%n", formatPrize(bonusPrize), count);
    }

    private static String formatPrize(int prize) {
        return String.format("%,d원", prize);
    }

    private static List<List<Integer>> makeRandomNumbers(int purchaseAmount) {
        List<List<Integer>> randomNumberList = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//            randomNumbers.sort(Integer::compareTo);
            System.out.println(randomNumbers);
            randomNumberList.add(randomNumbers);
        }
        return randomNumberList;
    }

    private static List<Integer> getLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> lottoNumbers = new ArrayList<>();
        String[] numbers = input.split(",");

        for (String number : numbers) {
            lottoNumbers.add(Integer.parseInt(number.trim()));
        }
        lottoNumbers.sort(Integer::compareTo);

        return lottoNumbers;
    }

    private static Integer getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusInput = Console.readLine();

        return Integer.parseInt(bonusInput.trim());
    }

    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            String input = Console.readLine();
            int purchaseAmount = Integer.parseInt(input);
            if (purchaseAmount % 1000 != 0){
                throw new IllegalArgumentException(error_message + "로또 구입 금액은 1,000 단위로 나누어 떨어져야 합니다.");
            }
            int numTickets = purchaseAmount / 1000;
            System.out.println(numTickets + "개를 구매했습니다.");
            return numTickets;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(error_message + "로또 금액은 숫자여야 합니다.");
        }
    }
}
