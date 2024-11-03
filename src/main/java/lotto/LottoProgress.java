package lotto;

import java.util.List;
import lotto.Console.InputConsole;
import lotto.Console.OutputConsole;

public class LottoProgress {

    public static void lottoProgress(){
        int inputMoney = InputConsole.intputMoney();
        int lottoNum = buyLotto(inputMoney);

        Lotto winningLottoNumbers = InputConsole.inputWinningNumbers();
        int bonusNum = InputConsole.inputBonusNumbers(winningLottoNumbers);



    }

    private static int buyLotto(int inputMoney){
        int lottoNum = LottoList.lottoNumber(inputMoney);
        System.out.println("\n" + lottoNum + "개를 구매했습니다.");

        List<Lotto> lottoList  = LottoList.drawingLotto(lottoNum);
        OutputConsole.outputLottoList(lottoList);

        return lottoNum;
    }
}
