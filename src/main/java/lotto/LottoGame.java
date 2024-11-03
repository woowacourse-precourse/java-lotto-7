package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private LottoTickets purchasedTickets;
    private WinningLotto winningLotto;

    public void start() {
        try {
            int purchaseAmount = inputPurchaseAmount();
            generateLottoTickets(purchaseAmount);
            inputWinningNumbers();
            displayResult(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            start();
        }

    }

    private void displayResult(int purchaseAmount) {
        LottoResult result=new LottoResult(purchasedTickets,winningLotto);
        result.printResult();
        result.printProfitRate(purchaseAmount);
    }

    private void inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String numbersInput=Console.readLine();
        System.out.println("\n보너스 번호를 입력해 주세요");
        String bonusInput=Console.readLine();
        winningLotto=new WinningLotto(numbersInput,bonusInput);
    }

    private void generateLottoTickets(int purchaseAmount) {
        int ticketCount= purchaseAmount/LOTTO_PRICE;
        System.out.println(ticketCount+"개를 구매했습니다");
        purchasedTickets=new LottoTickets(ticketCount);
        purchasedTickets.printTickets();
    }

    private int inputPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input = Console.readLine();
        validateNumericInput(input);
        int amount = Integer.parseInt(input);
        validatePurChaseAmount(amount);
        return amount;
    }

    private void validatePurChaseAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다");
        }
    }

    private void validateNumericInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다");
        }
    }


}
