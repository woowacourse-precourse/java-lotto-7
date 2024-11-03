package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Service {

    Host host = Host.getHost();
    int amount;
    List<Lotto> lottos;
    Map<WinningKind, Integer> lottoResult;

    public boolean inputAmount() {
        InputGuide.ACCOUNT.guidePrint();
        String inputAccount = Console.readLine();
        if (!inputAccount.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력하세요.");
        }
        amount = Integer.parseInt(inputAccount);
        return true;
    }

    public void showLottos() {
        int lottoCount = LottoGenerator.howManyLottos(amount);
        lottos = LottoGenerator.getLottos(lottoCount);

        Output.purchaseCount(lottoCount);
        Output.purchasedLottos(lottos);
    }

    public boolean inputSelectedNumbers() {
        InputGuide.NUMBER_SELECT.guidePrint();
        List<String> inputs = Util.seperateInput(Console.readLine());

        List<Integer> selectedNumbers = Util.toNumbers(inputs);
        host.setSelectedNumbers(selectedNumbers);
        return true;
    }

    public boolean inputBonusNumber() {
        InputGuide.BONUS.guidePrint();
        String bonusInput = Console.readLine();
        if (!bonusInput.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
        }
        host.setBonusNumber(Integer.parseInt(bonusInput));
        return true;
    }

    public void operateLottos() {
        lottoResult = LottoUtil.resultInit();
        for (Lotto lotto : lottos) {
            LottoUtil.checkLotto(lottoResult, lotto, host);
        }
    }

    public void OutputResult() {
        Output.resultStart();
        Output.wonResult(lottoResult);

        double yield = LottoUtil.getYield(lottoResult, amount);
        Output.yield(yield);
    }

}
