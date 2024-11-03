package lotto;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoMachine lottoMachine = new LottoMachine();

        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        lottoMachine.purchaseLottos(amount);
        lottoMachine.inputWinningNumbers();
        lottoMachine.inputBonusNumber();

        lottoMachine.calculateResult();
    }
}
