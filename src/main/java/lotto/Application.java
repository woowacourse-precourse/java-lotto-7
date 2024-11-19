package lotto;

public class Application {
    public static void main(String[] args) {
        UserLottos userLottos = createUserLottos();
        IOPrompt.showUserLottos(userLottos);
        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber(winningLotto);
        Result result  = new Result(winningLotto, bonusNumber, userLottos.getLottos());
        IOPrompt.showResult(result, userLottos);
    }

    private static UserLottos createUserLottos() {
        while (true) {
            try {
                int purchaseAmount = CommonValidation.convertStringToInt(IOPrompt.inputPurchaseAmount());
                return new UserLottos(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Lotto getWinningLotto() {
        System.out.println();
        while (true) {
            try {
                String input = IOPrompt.inputWinningNumbers();
                return new Lotto(LottoNumbersCreator.createWinningNumbers(input));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int getBonusNumber(Lotto winningNumbers) {
        System.out.println();
        while (true) {
            try {
                int bonusNumber = CommonValidation.convertStringToInt(IOPrompt.inputBonusNumber());
                CommonValidation.validateNumbersRange(bonusNumber);
                CommonValidation.validateBonusNumberDuplication(winningNumbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
