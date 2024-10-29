package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserAmountInput {
    private int amount;
    private int lottoTicketCount;

    public void userAmountInput() {

        System.out.println("구입금액을 입력해 주세요.");
        String amountInput = Console.readLine();

        processUserAmount(amountInput);
    }

    private void processUserAmount(String amountInput) {
        try {

            amount = parseAmount(amountInput); // 파싱된 값을 amount에 할당
            validate(amount);
            lottoTicketCount = amount / 1000;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 천 원단위의 정수여야 합니다.");
        }
    }

    private int parseAmount(String amountInput) {
        return Integer.parseInt(amountInput.trim().replaceAll("\\s*,\\s*", ""));
    }

    private void validate(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 천 원단위의 양수여야 합니다.");
        }
    }
}
