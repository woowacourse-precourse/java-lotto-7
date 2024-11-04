package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        UserLottos userLottos = createUserLottos();
        showUserLottos(userLottos);
        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber(winningLotto);
        Result result  = new Result(winningLotto, bonusNumber, userLottos.getLottos());
        showResult(result, userLottos);
    }

    private static UserLottos createUserLottos() {
        while (true) {
            try {
                int purchaseAmount = CommonValidation.convertStringToInt(inputPurchaseAmount());
                return new UserLottos(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String inputPurchaseAmount() {
        System.out.println(IOMessage.PURCHASE_AMOUNT.getMessage());
        return readLine();
    }

    private static void showUserLottos(UserLottos userLottos) {
        System.out.println();
        System.out.println(userLottos.getQuantity() + IOMessage.PURCHASE_QUANTITY.getMessage());
        System.out.println(getUserLottos(userLottos));
    }

    private static String getUserLottos(UserLottos userLottos) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : userLottos.getLottos()) {
            sb.append(lotto.getNumbers().toString()).append("\n");
        }
        return sb.toString().trim();
    }

    private static Lotto getWinningLotto() {
        System.out.println();
        while (true) {
            try {
                String input = inputWinningNumbers();
                return new Lotto(LottoNumbersCreator.createWinningNumbers(input));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String inputWinningNumbers() {
        System.out.println(IOMessage.WINNING_NUMBERS.getMessage());
        return readLine();
    }

    private static int getBonusNumber(Lotto winningNumbers) {
        System.out.println();
        while (true) {
            try {
                int bonusNumber = CommonValidation.convertStringToInt(inputBonusNumber());
                CommonValidation.validateNumbersRange(bonusNumber);
                CommonValidation.validateBonusNumberDuplication(winningNumbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String inputBonusNumber() {
        System.out.println(IOMessage.BONUS_NUMBER.getMessage());
        return readLine();
    }

    private static void showResult(Result result, UserLottos userLottos) {
        System.out.printf("\n%s\n%s\n", IOMessage.STATISTICS.getMessage(), IOMessage.DIVIDER.getMessage());
        System.out.println(result.getResult());
        System.out.println("총 수익률은 " + result.calculateStatistic(userLottos.getPurchaseAmount()) + "%입니다.");
    }
}
