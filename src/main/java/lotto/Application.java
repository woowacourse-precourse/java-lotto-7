package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import static lotto.InputGuide.*;
import static lotto.LottoUtil.checkResult;

public class Application {
    public static void main(String[] args) {

        Host host = Host.getHost();

        ACCOUNT.guidePrint();

        String inputAccount = Console.readLine();

        if (!inputAccount.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력하세요.");
        }

        int amount = Integer.parseInt(inputAccount);
        int lottoCount = LottoGenerator.howManyLottos(amount);
        List<Lotto> lottos = LottoGenerator.getLottos(lottoCount);

        Output.purchaseCount(lottoCount);
        Output.purchasedLottos(lottos);

        NUMBER_SELECT.guidePrint();
        List<String> inputs = Util.seperateInput(Console.readLine());

        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : inputs) {
            if (!number.matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 6개의 당첨번호를 쉼표(,)로 구분하여 입력해주세요.");
            }
            winningNumbers.add(Integer.parseInt(number));
        }

        host.setSelectedNumbers(winningNumbers);

        BONUS.guidePrint();
        String bonusInput = Console.readLine();
        if (!bonusInput.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
        }
        host.setBonusNumber(Integer.parseInt(bonusInput));

        Map<WinningKind, Integer> lottoResult = checkResult(lottos, host);

        Output.resultStart();
        Output.wonResult(lottoResult);

        double yield = LottoUtil.getYield(lottoResult, amount);
        Output.yield(yield);

    }
}
