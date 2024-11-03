package lotto.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.Lotto;
import lotto.enums.ErrorType;
import lotto.exception.CheckInput;

public class InputConsole {

    public static int intputMoney(){
        System.out.println("구매금액을 입력해 주세요.");

        int inputMoney = 0;
        boolean isValid = false;
        while(!isValid){
            try{
                inputMoney = Integer.parseInt(readLine());
                isValid = CheckInput.checkInputMoney(inputMoney);
            } catch (NumberFormatException e){
                System.out.println(ErrorType.INVALID_PRICE_FORMAT.getErrorMessage());
                System.out.println("구매금액을 다시 입력해 주세요.");
            }
        }

        return inputMoney;
    }

    public static Lotto inputWinningNumbers(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winningLottoNum = readLine();

        boolean isValid = false;
        Lotto winningLottoNumbers = null;
        while(!isValid){

            winningLottoNumbers = CheckInput.checkLottoNumbers(winningLottoNum);
            if(winningLottoNumbers != null){
                isValid = true;
            }

            System.out.println("\n당첨 번호를 다시 입력해 주세요.");
            winningLottoNum = readLine();
        }

        return winningLottoNumbers;
    }

    public static int inputBonusNumbers(Lotto winningLottoNumbers){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNum = Integer.parseInt(readLine());

        while(!CheckInput.checkBonusNumber(bonusNum, winningLottoNumbers)){

            System.out.println("\n보너스 번호를 다시 입력해 주세요.");
            bonusNum = Integer.parseInt(readLine());
        }

        return bonusNum;
    }
}
