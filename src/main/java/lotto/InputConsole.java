package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.exception.CheckInput;

public class InputConsole {

    public static void inputConsole() {
        System.out.println("구매금액을 입력해 주세요.");
        int inputMoney = Integer.parseInt(readLine());

        CheckInput.checkInputMoney(inputMoney);

        int lottoNum = LottoList.lottoNumber(inputMoney);
        System.out.println("\n" + lottoNum + "개를 구매했습니다.");

        List<Lotto> lottoList;
        lottoList = LottoList.drawingLotto(lottoNum);

        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winningLottoNum = readLine();

        Lotto winningLottoNumbers = CheckInput.checkLottoNumbers(winningLottoNum);

        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNum = Integer.parseInt(readLine());

        CheckInput.checkBonusNumber(bonusNum, winningLottoNumbers);

        System.out.println("\n당첨 통계");
        System.out.println("---");


    }

}
