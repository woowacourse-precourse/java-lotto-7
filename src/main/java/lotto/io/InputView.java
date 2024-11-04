package lotto.io;

import java.util.function.Supplier;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinnerLotto;
import lotto.error.ErrorCode;

public class InputView {

    private static final Reader DEFAULT_READER = new ConsoleReader();
    private final Reader reader;

    public InputView(Reader reader) {
        this.reader = reader;
    }

    public InputView() {
        this.reader = DEFAULT_READER;
    }

    private String readLine() {
        String input = reader.readLine();
        validate(input);
        return input;
    }

    private static void printReInput(IllegalArgumentException ex) {
        System.out.flush();
        System.out.println(ex.getMessage());
        System.out.println("다시 입력하세요.");
    }

    private static void validate(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorCode.BLANK_INPUT_MESSAGE.getMessage());
        }
    }

    public PurchaseAmount inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        while(true){
            try{
                String inputPurchaseAmount = readLine();
                System.out.println();
                return new PurchaseAmount(inputPurchaseAmount);
            } catch (IllegalArgumentException ex){
                printReInput(ex);
            }
        }
    }

    public WinnerLotto inputWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        while(true){
            try{
                String inputWinningNumbers = readLine();
                System.out.println();
                return WinnerLotto.from(inputWinningNumbers);
            } catch (IllegalArgumentException ex){
                printReInput(ex);
            }
        }
    }

    public WinnerLotto inputBonusNumbers(WinnerLotto winnerLotto){
        System.out.println("보너스 번호를 입력해 주세요.");
        while(true){
            try{
                String bonusNumber = readLine();
                System.out.println();
                return winnerLotto.addBonusNumber(bonusNumber);
            } catch (IllegalArgumentException ex){
                printReInput(ex);
            }
        }
    }
}
