package lotto.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Collections;
import java.util.List;
import lotto.CheckWinning;
import lotto.Lotto;
import lotto.enums.WinningType;
import lotto.exception.CheckInput;

public class InputConsole {

    public static int intputMoney(){
        System.out.println("구매금액을 입력해 주세요.");
        int inputMoney = Integer.parseInt(readLine());

        CheckInput.checkInputMoney(inputMoney);

        return inputMoney;
    }

    public static Lotto inputWinningNumbers(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winningLottoNum = readLine();

        Lotto winningLottoNumbers = CheckInput.checkLottoNumbers(winningLottoNum);

        return winningLottoNumbers;
    }

    public static int inputBonusNumbers(Lotto winningLottoNumbers){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNum = Integer.parseInt(readLine());

        CheckInput.checkBonusNumber(bonusNum, winningLottoNumbers);
        return bonusNum;
    }
}
