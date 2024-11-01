package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.Service.LottoService;

public class LottoController {
    private static final List<Lotto> lottos = new ArrayList<>();
    private static final LottoService lottoService = new LottoService();
    private static int bonusNum;

    public static void lottoStart() {
        buyLottos();
        displayLottos();
        inputLottoNumbers();
        inputBonusNumber();
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
        lottoService.setWinningNumbers(winningNumbers);
    }

    private static void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요: ");
        String bonus = Console.readLine();
        lottoService.setBonusNumber(Integer.parseInt(bonus));
    }

    private static void displayLottos() {
        System.out.println("발행한 로또 번호:");
        for (Lotto lotto : lottoService.getLottos()) {
            System.out.println(lotto);
        }
    }
}
