package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningKind;
import lotto.util.LottoUtil;
import lotto.view.Error;
import lotto.util.Util;
import lotto.view.InputGuide;
import lotto.view.Output;
import lotto.domain.Host;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;

import java.util.List;
import java.util.Map;

public class Service {

    Host host = Host.getHost();
    int amount;
    int lottoCount;
    List<Lotto> lottos;
    Map<WinningKind, Integer> lottoResult;

    public void inputAmount() throws IllegalArgumentException {
        InputGuide.ACCOUNT.guidePrint();
        String inputAccount = Console.readLine();
        Util.nextLine();
        numberValidate(inputAccount);
        amount = Integer.parseInt(inputAccount);
        lottoCount = LottoGenerator.howManyLottos(amount);
    }

    public void showLottos() {
        lottos = LottoGenerator.getLottos(lottoCount);

        Output.purchaseCount(lottoCount);
        Output.purchasedLottos(lottos);
        Util.nextLine();
    }

    public void inputSelectedNumbers() {
        InputGuide.NUMBER_SELECT.guidePrint();
        String input = Console.readLine();
        Util.nextLine();
        List<String> inputs = Util.seperateInput(input);

        List<Integer> selectedNumbers = Util.toNumbers(inputs);
        host.setSelectedNumbers(selectedNumbers);
    }

    public void inputBonusNumber() {
        InputGuide.BONUS.guidePrint();
        String bonusInput = Console.readLine();
        Util.nextLine();
        numberValidate(bonusInput);
        host.setBonusNumber(Integer.parseInt(bonusInput));
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

    private void numberValidate(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(Error.INPUT_FORMAT_ERROR.message());
        }
    }

}
