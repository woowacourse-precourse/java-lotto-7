package lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoUtility {
    public List<Integer> stringToWinningNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        try {
            numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하셔야 합니다.");
        }
        return numbers;
    }

    public String getWinningInfoMessage(LottoWinningStandard standard, int matchedCount) {
        if(standard.equals(LottoWinningStandard.SECOND_PRIZE)) {
            return "5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchedCount + "개";
        }

        DecimalFormat formatter = new DecimalFormat("#,###");
        String prize = formatter.format(standard.getPrizeMoney());
        return standard.getMatchedNumberCount() + "개 일치 (" + prize + "원) - " + matchedCount + "개";
    }

    public static void printMessage(String message) {
    public int getBonusNumber(Lotto winningLotto) {
        boolean stop = false;
        int bonus = 0;
        while (!stop) {
            String input = Console.readLine();
            try {
                bonus = bonusValidate(input);
                if (bonus > 0 && bonusDuplicate(winningLotto, bonus)) {
                    stop = true;
                }
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        }
        return bonus;
    }

    public boolean bonusDuplicate(Lotto winningLotto, int bonus) {
        boolean isDuplicated = winningLotto.getNumbers().stream().anyMatch(number -> number == bonus);
        if (isDuplicated) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        return true;
    }

    private int bonusValidate(String input) {
        int bonus = 0;
        try {
            bonus = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            printMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if(bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonus;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
