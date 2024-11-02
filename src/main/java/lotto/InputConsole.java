package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.CheckInput;

public class InputConsole {

    public static void inputConsole() {
        System.out.println("구매금액을 입력해 주세요.");
        int inputMoney = Integer.parseInt(readLine());

        CheckInput.checkInputMoney(inputMoney);

        int lottoNum = LottoList.lottoNumber(inputMoney);
        System.out.println("\n" + lottoNum + "개를 구매했습니다.");

        List<Lotto> lottoList = new ArrayList<>();
        lottoList = LottoList.drawingLotto(lottoNum);

        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }

    }

}
