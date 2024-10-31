package lotto;


import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Application {

    private static String readNonEmptyLine() {
        String line;
        try {
            line = Console.readLine();
        } catch (NoSuchElementException e) {
            line = "";
        }
        return line;
    }

    private static String readAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readNonEmptyLine();
    }

    private static String readWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return readNonEmptyLine();
    }

    private static String readBonusNumbers() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return readNonEmptyLine();
    }

    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        int amount = lottoMachine.parseAmount(readAmount());
        lottoMachine.issue(amount);
        lottoMachine.printLottoBunch();
        Lotto winningNumbers = lottoMachine.parseWinningNumber(readWinningNumbers());
        int bonusNumber = lottoMachine.parseBonusNumber(winningNumbers, readBonusNumbers());
    }
}
