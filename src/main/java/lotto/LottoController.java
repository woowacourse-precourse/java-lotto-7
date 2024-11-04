package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;
    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }
    public void run() {
        int purchaseAmount = getValidatedPurchaseAmount();
        lottoService.purchaseLottos(purchaseAmount);
        lottoService.printLottos();

        Lotto userNumbers = getUserNumbers();
        int bonusNumber = getBonusNumber();

        lottoService.calculateResults(userNumbers, bonusNumber);
        lottoService.printResults(purchaseAmount);
    }
    private int getValidatedPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int validate = 0;
        try{
            validate = lottoService.validatePurchaseAmount(input);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
        return validate;
    }
    private Lotto getUserNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return lottoService.validateUserNumbers(input);
    }
    private int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return lottoService.validateBonusNumber(input);
    }
}
