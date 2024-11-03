package lotto;


import camp.nextstep.edu.missionutils.Console;
import lotto.prompt.LottoDrawPrompt;
import lotto.prompt.LottoPurchasePrompt;

public class Application {

    private static String readAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    private static String readWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    private static String readBonusNumbers() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static void main(String[] args) {
        lotto.controller.LottoMachine lottoMachine2 = new lotto.controller.LottoMachine();
        lottoMachine2.purchase(new LottoPurchasePrompt());
        lottoMachine2.draw(new LottoDrawPrompt());
        System.exit(0);
        LottoMachine lottoMachine = new LottoMachine();
        int amount;
        Lotto winningNumbers;
        int bonusNumber;
        while (true) {
            try {
                amount = lottoMachine.parseAmount(readAmount());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        lottoMachine.issue(amount);
        lottoMachine.printLottoBunch();

        while (true) {
            try {
                winningNumbers = lottoMachine.parseWinningNumber(readWinningNumbers());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                bonusNumber = lottoMachine.parseBonusNumber(winningNumbers, readBonusNumbers());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        lottoMachine.draw(winningNumbers, bonusNumber);
        lottoMachine.printWinningStatistics(amount);
        Console.close();
    }
}
