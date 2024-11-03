package lotto.domain;

import static lotto.constant.DefaultPrompt.ENTER_BONUS_NUMBER_TEXT;
import static lotto.constant.DefaultPrompt.ENTER_PURCHASE_AMOUNT_TEXT;
import static lotto.constant.DefaultPrompt.ENTER_WINNING_NUMBER_TEXT;
import static lotto.constant.DefaultPrompt.RESULT_PURCHASE_AMOUNT_AND_AUTOMATIC_LOTTO_TEMPLATE;
import static lotto.constant.DefaultPrompt.RESULT_WINNING_STATISTICS_LOTTO_TEMPLATE;
import static lotto.constant.DefaultPrompt.display;
import static lotto.constant.DefaultPrompt.displayEmptyLine;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.manager.AutomaticLottoMachine;
import lotto.domain.manager.LottoStatistics;
import lotto.domain.manager.WinningLottos;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoNumber;

public class LottoStore {
    public static final String ERROR_ONLY_NUMBERS_FOR_THE_PURCHASE_AMOUNT = "[ERROR] 구입금액에는 숫자만을 입력해야 합니다.";

    public void open() {
        var automaticLottoMachine = enterPurchaseAmount();
        RESULT_PURCHASE_AMOUNT_AND_AUTOMATIC_LOTTO_TEMPLATE.display(
                automaticLottoMachine.getQuantity(),
                automaticLottoMachine);

        Lotto winingLotto = enterWinningNumber();
        WinningLottos winningLottos = enterBonusNumber(winingLotto);
        var lottoStatistics = new LottoStatistics(automaticLottoMachine, winningLottos);
        RESULT_WINNING_STATISTICS_LOTTO_TEMPLATE.display(lottoStatistics);
    }

    private Lotto enterWinningNumber() {
        while (true) {
            try {
                ENTER_WINNING_NUMBER_TEXT.display();
                String rawNumbers = Console.readLine();
                validateEnter(rawNumbers);
                List<Integer> numbers = separate(rawNumbers);
                Lotto lotto = new Lotto(numbers);
                displayEmptyLine();

                return lotto;
            } catch (IllegalArgumentException e) {
                display(e.getMessage());
            }
        }
    }

    private WinningLottos enterBonusNumber(Lotto winingLotto) {
        while (true) {
            try {
                ENTER_BONUS_NUMBER_TEXT.display();
                String rawBonusNumber = Console.readLine();
                int bonusNumber = parse(rawBonusNumber);
                LottoNumber bonus = new LottoNumber(bonusNumber);
                WinningLottos winningLottos = new WinningLottos(winingLotto, bonus);

                displayEmptyLine();
                return winningLottos;
            } catch (IllegalArgumentException e) {
                display(e.getMessage());
            }
        }
    }

    private List<Integer> separate(String rawNumbers) {
        return Arrays.stream(rawNumbers.split(","))
                .map(String::trim)
                .map(this::parse)
                .toList();
    }

    private AutomaticLottoMachine enterPurchaseAmount() {
        while (true) {
            try {
                ENTER_PURCHASE_AMOUNT_TEXT.display();
                String rawAmount = Console.readLine();
                validateEnter(rawAmount);

                int amount = parse(rawAmount);
                var automaticLottoMachine = new AutomaticLottoMachine(amount);

                displayEmptyLine();

                return automaticLottoMachine;
            } catch (IllegalArgumentException e) {
                display(e.getMessage());
            }
        }
    }


    private void validateEnter(String rawInput) {
        if (rawInput == null || rawInput.isBlank()) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBERS_FOR_THE_PURCHASE_AMOUNT);
        }
    }

    private int parse(String rawPurchaseAmount) {
        try {
            return Integer.parseInt(rawPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBERS_FOR_THE_PURCHASE_AMOUNT);
        }
    }

}
