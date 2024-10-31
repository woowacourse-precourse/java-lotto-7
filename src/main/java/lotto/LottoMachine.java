package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoMachine {

    public static final String AMOUNT_ERROR_MSG = "[ERROR] 구입 금액은 1000(원) 단위의 숫자입니다. 예: 14000";
    public static final String LOTTO_NUMBER_RANGE_ERROR_MSG = "[ERROR] 로또 번호는 1 ~ 45 사이의 숫자입니다.";
    public static final String BONUS_NUMBER_DUPLICATE_ERROR_MSG = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final int LOTTO_PRICE = 1000;

    private final HashMap<Integer, Integer> winningStatistics = new HashMap<>();
    private final List<Lotto> lottoBunch = new ArrayList<>();

    public int parseAmount(String input) {
        int amount = 0;

        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(AMOUNT_ERROR_MSG);
        }

        if (amount <= 0 || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(AMOUNT_ERROR_MSG);
        }

        return amount;
    }

    public int parseLottoNumber(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MSG);
        }

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MSG);
        }

        return number;
    }

    public void issue(int amount) {
        for (int i = 0; i < amount / LOTTO_PRICE; i++) {
            lottoBunch.add(Lotto.issue());
        }
    }

    public List<Lotto> getLottoBunch() {
        return lottoBunch;
    }

    public void printLottoBunch() {
        System.out.printf("\n%d개를 구매했습니다.\n", lottoBunch.size());
        for (Lotto lotto : lottoBunch) {
            System.out.println(lotto);
        }
    }

    public Lotto parseWinningNumber(String input) {
        List<String> splitInput = Arrays.asList(input.split(","));
        List<Integer> lottoNumbers = splitInput.stream()
                .map(this::parseLottoNumber)
                .toList();
        return new Lotto(lottoNumbers);
    }

    public int parseBonusNumber(Lotto winningNumbers, String input) {
        int bonusNumber = parseLottoNumber(input);
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR_MSG);
        }
        return bonusNumber;
    }

    public int compareLotto(Lotto lotto, Lotto winningNumber) {
        Set<Integer> intersection = new HashSet<>(lotto.getNumbers());
        intersection.retainAll(winningNumber.getNumbers());
        return intersection.size();
    }

    public void draw(Lotto winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottoBunch) {
            int matching = compareLotto(lotto, winningNumbers);
            boolean bonusMatching = lotto.getNumbers().contains(bonusNumber);

            if (matching == 5 && bonusMatching) {
                matching = 7;
            }
            if (matching > 2) {
                int value = winningStatistics.getOrDefault(matching, 0) + 1;
                winningStatistics.put(matching, value);
            }
        }
    }

    private long getTotalPrize() {
        long totalPrize = 0L;
        totalPrize += 5000L * winningStatistics.getOrDefault(3, 0);
        totalPrize += 50000L * winningStatistics.getOrDefault(4, 0);
        totalPrize += 150000L * winningStatistics.getOrDefault(5, 0);
        totalPrize += 3000000L * winningStatistics.getOrDefault(7, 0);
        totalPrize += 20000000L * winningStatistics.getOrDefault(6, 0);
        return totalPrize;
    }

    public double getReturnRate(double totalPrize, double amount) {
        return Math.round(totalPrize / amount * 100 * 10) / 10.0;
    }
}
