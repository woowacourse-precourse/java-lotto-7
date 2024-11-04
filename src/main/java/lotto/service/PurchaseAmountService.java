package lotto.service;

import lotto.model.PurchaseAmount;
import camp.nextstep.edu.missionutils.Console;

public class PurchaseAmountService {
    private final PurchaseAmount purchaseAmount;

    public PurchaseAmountService() {
        this.purchaseAmount = new PurchaseAmount();
    }

    public void inputMoney() {
        while (true) {
            try {
                System.out.print("구입금액을 입력해 주세요: ");
                String money = Console.readLine();
                System.out.println(money);
                int parsedMoney = Integer.parseInt(money);
                purchaseAmount.validate(parsedMoney);
                purchaseAmount.setMoney(parsedMoney);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 금액을 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getMoney() {
        return purchaseAmount.getMoney();
    }

    public int getLottoTicketCount(int money) {
        return purchaseAmount.getLottoTicketCount(money);
    }
}
