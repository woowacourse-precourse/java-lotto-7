package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입 금액을 입력해 주세요.");
        String purchase = Console.readLine();
        System.out.println();

        Customer customer = new Customer();
        customer.buyLottos(purchase);

        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = Console.readLine();
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        System.out.println();

        LottoNumberFormatter formatter = new LottoNumberFormatter();
        List<Integer> winningNums = formatter.splitInput(inputWinningNumbers);
        int bonusNum = formatter.convertToBonusNum(inputBonusNumber);
        formatter.hasDuplicateNum(winningNums, bonusNum);

        LottoChecker lottoChecker = new LottoChecker(winningNums, bonusNum);
        lottoChecker.lottoCheck(customer);
    }
}
