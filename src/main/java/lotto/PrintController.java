package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class PrintController {

    LottoController lottoController = new LottoController();

    //구입금액
    public int inputPurchaseNumber() {
        System.out.println("구입금액을 입력해 주세요");
        String purchaseNumber = Console.readLine();
        return lottoController.parsePurchaseNumber(purchaseNumber);
    }

    //로또출력
    public List<Lotto> printLottos(int purchaseNumber) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseNumber; i++) {
            Lotto lotto = new Lotto(Lotto.generateNumbers());
            lottos.add(lotto);
        }
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        return lottos;
    }

    //당첨번호
    public List<Integer> inputWinNumber(){
        System.out.println("당첨 번호흫 입력해 주세요.");
        String winNumber = Console.readLine();
        return lottoController.parseWinNumber(winNumber);
    }

    //보너스번호
    public int inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return lottoController.parseBonusNumber(bonusNumber);
    }

    //당첨통계
    public void printStatistics(List<Lotto> lottos, WinNumbers winNumbers) {
        System.out.println("당첨 통계\n---");

    }

    //수익률
}
