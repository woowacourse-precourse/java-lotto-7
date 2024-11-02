package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Collections;
import java.util.List;
import lotto.enums.WinningType;
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

        CheckWinning.checkDuplicateNum(winningLottoNumbers, lottoList, bonusNum);
        System.out.println("3개 일치 (5,000원) - " + WinningType.FIRST.getCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + WinningType.SECOND.getCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + WinningType.THIRD.getCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + WinningType.FOURTH_BONUS.getCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + WinningType.FIFTH.getCount() + "개");

        System.out.println("총 수익률은 " + CheckWinning.calculateProfit(inputMoney) + "%입니다.");
    }

}
