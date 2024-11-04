package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Lotto;
import domain.Prize;
import lotto.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoView {
    private List<Lotto> purchasedLottos;

    public LottoView() {
        this.purchasedLottos = new ArrayList<>();
    }

    public void setPurchasedLottos(List<Lotto> purchasedLottos) {
        this.purchasedLottos = purchasedLottos;
    }

    public int getPurchaseAmount() {
        while (true) {
            try {
                System.out.print("구입금액을 입력해 주세요: ");
                String input = Console.readLine();
                InputValidator.validatePurchase(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void displayPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public Lotto getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        while (true) {
            try {
                System.out.print("당첨 번호를 입력해 주세요: ");
                String input = Console.readLine();
                String[] numbers = input.split(",");
                winningNumbers.clear();
                for (String number : numbers) {
                    winningNumbers.add(Integer.parseInt(number.trim()));
                }
                return new Lotto(winningNumbers);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonusNumber() {
        int bonusNumber;
        while (true) {
            try {
                System.out.print("보너스 번호를 입력해 주세요: ");
                String input = Console.readLine();
                bonusNumber = Integer.parseInt(input.trim());

                validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
        for (Lotto lotto : purchasedLottos) {
            if (lotto.getNumbers().contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.");
            }
        }
    }

    public void displayStatistics(Map<Prize, Integer> winnings) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Map.Entry<Prize, Integer> entry : winnings.entrySet()) {
            System.out.println(entry.getKey().name() + " (" + entry.getKey().getPrizeAmount() + "원) - " + entry.getValue() + "개");
        }
    }

    public void displayReturnRate(int totalSpent, int totalWinnings) {
        double returnRate = totalSpent == 0 ? 0 : (double) totalWinnings / totalSpent * 100;
        System.out.println("총 수익률은 " + returnRate + "%입니다.");
    }
}
