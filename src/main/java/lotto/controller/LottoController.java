package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Lotto;
import lotto.Service.LottoService;
import lotto.Vaildator.InputValidator;

public class LottoController {
    private static final LottoService lottoService = new LottoService();

    public static void lottoStart() {
        buyLottos();
        displayLottos();
        inputLottoNumbers();
        inputBonusNumber();
        checkResult();
    }

    private static void buyLottos() {
        System.out.println("구입 금액을 입력해 주세요: ");
        int amount = Integer.parseInt(Console.readLine());
        lottoService.buyLottos(amount);
    }

    private static void inputLottoNumbers() {
        System.out.println("당첨 번호 6개를 입력해 주세요 (쉼표로 구분): ");
        String input = Console.readLine();
        List<Integer> winningNumbers = lottoService.inputLottoNumbers(input);
        InputValidator.valid(winningNumbers);
        lottoService.setWinningNumbers(winningNumbers);
    }

    private static void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요: ");
        String bonus = Console.readLine();
        InputValidator.validBonus(bonus);
        lottoService.setBonusNumber(Integer.parseInt(bonus));
    }

    private static void displayLottos() {
        System.out.println("발행한 로또 번호:");
        for (Lotto lotto : lottoService.getLottos()) {
            System.out.println(lotto);
        }
    }

    private static void checkResult() {
        System.out.println("당첨 통계\n---");
        lottoService.checkResult();
    }
}
