package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public static void lotto() {
        String inputAmount = InputView.getPurchaseAmount();
        int purchaseAmount = validateAndParsePurchaseAmount(inputAmount);
        int count = getCount(purchaseAmount);

        List<Lotto> lottoNumbers = createLottoNumbers(count);
        OutputView.printLottoCount(count);
        OutputView.printLottoNumbers(lottoNumbers);

        String inputWinningNumbers = InputView.getWinningNumbers();
        List<Integer> winningNumbers = convertWinningNumbers(inputWinningNumbers);

        String inputBonusNumber = InputView.getBonusNumber();
        Integer bonus = convertBonusNumber(inputBonusNumber);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);

    }

    private static Integer convertBonusNumber(String inputBonusNumber) {
        try {
            Integer bonus = Integer.parseInt(inputBonusNumber);
            if (bonus < 1 || bonus > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자만 가능합니다.");
            }
            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private static List<Integer> convertWinningNumbers(String inputWinningNumbers) {
        String[] inputNumbers = inputWinningNumbers.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : inputNumbers) {
            int parsedNumber = parseWinningNumber(number.trim());
            winningNumbers.add(parsedNumber);
        }
        return winningNumbers;
    }

    private static int parseWinningNumber(String number) {
        try {
            int winningNumber = Integer.parseInt(number);
            if(winningNumber<1 || winningNumber>45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자만 가능합니다.");
            }
            return winningNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }

    public static List<Lotto> createLottoNumbers (int count) {

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> createdLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            createdLotto.sort(Integer::compareTo);
            Lotto lotto = new Lotto(createdLotto);
            lottos.add(lotto);
        }
        return lottos;
    }
    public static int validateAndParsePurchaseAmount(String purchaseAmount) {
        int parsedPurchaseAmount = parsePurchaseAmount(purchaseAmount);
        validatePurchaseAmount(parsedPurchaseAmount);
        return parsedPurchaseAmount;
    }

    public static int parsePurchaseAmount(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해야 합니다.");
        }
    }
    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public static int getCount(int purchaseAmount) {
        return purchaseAmount/1000;
    }
}