package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.LottoService;

import java.util.List;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public void run() {
        int purchaseAmount = readPurchaseAmount();
        List<Integer> winningNumbers = readWinningNumbers();
        int bonusNumber = readBonusNumber();

        lottoService.playLotto(purchaseAmount, winningNumbers, bonusNumber);
    }

    private int readPurchaseAmount() {
        while (true) {
            System.out.println("구입 금액을 입력해 주세요:");
            String input = Console.readLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 숫자여야 합니다.");
            }
        }
    }

    private List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요(쉼표로 구분):");
        String input = Console.readLine();
        return lottoService.parseWinningNumbers(input);
    }

    private int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요:");
        return Integer.parseInt(Console.readLine());
    }
}