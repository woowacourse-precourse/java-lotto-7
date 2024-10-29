package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserAmountInput {
    private int amount;
    private int lottoTicketCount;

    public void userAmountInput() {

        System.out.println("구입금액을 입력해 주세요.");

        try {
            String amountInput = Console.readLine();

            amount = Integer.parseInt(amountInput.trim().replaceAll("\\s*,\\s*", ""));

            validate(amount);

            lottoTicketCount = amount / 1000;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 정수여야 합니다.");
        }
    }

    private void validate(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 천 원단위의 양수여야 합니다.");
        }

    }

}
