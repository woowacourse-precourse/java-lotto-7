package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Cost;
import lotto.model.Lotto;
import lotto.view.OutputView;

public class LottoController {

    private final List<List<Integer>> lottoNumbers = new ArrayList<>();
    private final OutputView outputView;
    private Lotto lotto;
    private int cost;
    private int bonusNumber;

    public LottoController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        outputView.showStartComment();

        cost = requestCostInput();

        int purchaseCount = cost / 1000;

        outputView.showInsertNewLine();

        outputView.showPurchaseResult(purchaseCount);

        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            lottoNumbers.add(numbers);
            System.out.println(lottoNumbers.get(i));
        }

        outputView.showInsertNewLine();

        outputView.showRequestLottoNumberComment();

        lotto = requestLottoNumberInput();

        outputView.showInsertNewLine();

        outputView.showRequestBonusNumberComment();

        bonusNumber = requestBonusNumberInput(lotto);

        outputView.showInsertNewLine();

        outputView.showWinningStatistics();

        int threeMatched = 0;
        int fourMatched = 0;
        int fiveMatched = 0;
        int bonusMatched = 0;
        int allMatched = 0;

        for (List<Integer> lottoNumber : lottoNumbers) {
            int lottoCount = 0;
            boolean isBonusMatched = lottoNumber.contains(bonusNumber);

            for (int number : lotto.getNumbers()) {
                if (lottoNumber.contains(number)) {
                    lottoCount++;
                }
            }

            if (lottoCount == 6) {
                allMatched++;
                continue;
            }
            if (lottoCount == 5 && isBonusMatched) {
                bonusMatched++;
                continue;
            }
            if (lottoCount == 5) {
                fiveMatched++;
                continue;
            }
            if (lottoCount == 4) {
                fourMatched++;
                continue;
            }
            if (lottoCount == 3) {
                threeMatched++;
            }
        }

        outputView.showWinningResult(threeMatched, fourMatched, fiveMatched, bonusMatched, allMatched);

        int totalWinnings = (5000 * threeMatched) + (50000 * fourMatched) +
                (1500000 * fiveMatched) + (30000000 * bonusMatched) +
                (2000000000 * allMatched);

        double earningRatio = ((double) totalWinnings / cost) * 100;
        String formatEarningRatio = String.format("%,.1f", earningRatio);
        outputView.showTotalEarningRatio(formatEarningRatio);

    }

    private int requestBonusNumberInput(Lotto lotto) {
        try {
            return BonusNumber.of(Integer.parseInt(Console.readLine().trim()), lotto).getBonusNumber();

        } catch (NumberFormatException e) {
            outputView.showBonusNumberErrorMessage();
            return requestBonusNumberInput(lotto);
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e);
            return requestBonusNumberInput(lotto);
        }
    }

    private Lotto requestLottoNumberInput() {
        try {
            return new Lotto(Arrays.stream(Console.readLine().trim().split(","))
                    .map(Integer::parseInt)
                    .toList());
        }catch (NumberFormatException e){
            outputView.showLottoNumberErrorMessage();
            return requestLottoNumberInput();
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e);
            return requestLottoNumberInput();
        }
    }

    private int requestCostInput() {
        try {
            return Cost.from(Integer.parseInt(Console.readLine().trim())).getCost();

        } catch (NumberFormatException e) {
            outputView.showCostErrorMessage();
            return requestCostInput();
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e);
            return requestCostInput();
        }
    }
}
