package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawLotto {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final List<Integer> prize = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

    public DrawLotto(String winningNumber, String bonusNumber) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : winningNumber.split(",")) {
            numbers.add(Integer.parseInt(s));
        }
        this.winningNumbers = numbers;
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void lottoResult(User user) {
        for (Lotto lotto : user.getLottos()) {
            int winningNumberCount = 0;
            int bonusNumberCount = 0;

            for (int i = 0; i < lotto.getNumbers().size(); i++) {
                if (lotto.getNumbers().get(i).equals(winningNumbers.get(i))) {
                    winningNumberCount++;
                }
                if (lotto.getNumbers().get(i).equals(bonusNumber)) {
                    bonusNumberCount++;
                }
            }

            if (winningNumberCount == 6) {
                prize.add(0, prize.get(0) + 1);
            }

            if (winningNumberCount == 5) {
                if (bonusNumberCount == 1) {
                    prize.add(1, prize.get(1) + 1);
                }

                if (bonusNumberCount == 0) {
                    prize.add(2, prize.get(2) + 1);
                }
            }

            if (winningNumberCount == 4) {
                prize.add(3, prize.get(3) + 1);
            }

            if (winningNumberCount == 3) {
                prize.add(4, prize.get(4) + 1);
            }
        }
    }

    public void showResult(User user) {
        lottoResult(user);

        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + prize.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + prize.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prize.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prize.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prize.get(0) + "개");

        long rateOfReturn = prize.get(0) * 2000000000L + prize.get(1) * 30000000 + prize.get(2) * 1500000 + prize.get(3) * 50000 + prize.get(4) * 5000;
        System.out.println("총 수익률은 " + (rateOfReturn - user.getMoneyAmount()) / user.getMoneyAmount() * 100 + "%입니다.");
    }
}
