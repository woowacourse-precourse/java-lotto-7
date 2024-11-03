package lotto;

import java.util.List;

public class LottoProgress {

    public static void lottoProgress(){
        int inputMoney = InputConsole.intputMoney();
        int lottoNum = buyLotto(inputMoney);



    }

    private static int buyLotto(int inputMoney){
        int lottoNum = LottoList.lottoNumber(inputMoney);
        System.out.println("\n" + lottoNum + "개를 구매했습니다.");

        List<Lotto> lottoList  = LottoList.drawingLotto(lottoNum);
        OutputConsole.outputLottoList(lottoList);

        return lottoNum;
    }
}
