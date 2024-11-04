package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;


public class Application {
    static String introduction = "구입 금액을 입력해 주세요.";

    public static void spaceString() {
        System.out.println();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Printer printer = new Printer();
        InputHandler inputHandler = new InputHandler();
        printer.printBudgetNotice();
        String money = Console.readLine();
        Customer customer = new Customer(money);
        spaceString();

        printer.printLottoNumbers(customer.getLottoCount());
        LottoNumberProducer producer = new LottoNumberProducer(customer.getLottoCount());
        producer.createRandomNumbers();
        producer.displayLottoNumbers();
        spaceString();

        printer.printWinNumbersNotice();
        String winNumberStr = Console.readLine();
        String[] winNumberList = winNumberStr.split(",");
        List<Integer> winNumbers = inputHandler.integerInverter(winNumberList);
        Lotto lotto = new Lotto(winNumbers);

        spaceString();
        printer.printBonusNumberNotice();
        String bonusNumberStr = Console.readLine();
        int bonusNumber = Integer.parseInt(bonusNumberStr);
        lotto.bonusValidate(bonusNumber);
        spaceString();

        LottoResultProcessor result = new LottoResultProcessor(customer.getMoney(), lotto.getWinNumbers(), producer.getLottoNumbers(), bonusNumber);
    }
}
