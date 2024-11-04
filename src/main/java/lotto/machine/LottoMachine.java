package lotto.machine;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lotto.Lotto;
import lotto.LottoResult;
import lotto.OutputHandler;
import lotto.Validator;

public class LottoMachine {
    private final OutputHandler outputHandler;
    private final Validator validator;
    private final LottoGenerator lottoGenerator;

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBERS = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private List<Lotto> lottos = new ArrayList<>();
    private long purchaseAmount = 0;

    private List<Integer> winnerNumbers = new ArrayList<>();
    private int bonusNumber = 0;

    public LottoMachine(Validator validator, OutputHandler outputHandler) {
        this.validator = validator;
        this.outputHandler = outputHandler;
        this.lottoGenerator = new LottoGenerator();
    }

    public void requestPurchasePrice() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                final String input = Console.readLine();
                validator.validateCanBeParsedToLong(input);

                final long parsedValue = Long.parseLong(input);
                validator.validatePositiveValue(parsedValue);
                validator.validateDivisibleBy(parsedValue, LOTTO_PRICE);

                purchaseAmount = parsedValue / LOTTO_PRICE;
                return;
            } catch (IllegalArgumentException e) {
                outputHandler.printErrorMessage(e.getMessage());
            }
        }
    }

    public void generateLottos() {
        for (int i = 0; i < purchaseAmount; i++) {
            final Lotto lotto = lottoGenerator.generateByRandom(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBERS);
            lottos.add(lotto);
        }
    }

    public void requestWinnerNumbers() {
        while (true) {
            try {
                System.out.println();
                System.out.println("당첨 번호를 입력해 주세요.");
                final String input = Console.readLine();
                validator.validateCommaSeparatedList(input);

                final String[] splitValue = input.split(",");
                List<Integer> numbers = new ArrayList<>();
                for (String item : splitValue) {
                    validator.validateCanBeParsedToInteger(item);
                    final int number = Integer.parseInt(item);

                    validator.validateNumberHaveValidRange(number, LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);
                    numbers.add(number);
                }

                winnerNumbers.addAll(numbers);
                return;
            } catch (IllegalArgumentException e) {
                outputHandler.printErrorMessage(e.getMessage());
            }
        }
    }

    public void requestBonusNumber() {
        while (true) {
            try {
                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                final String input = Console.readLine();
                validator.validateCanBeParsedToInteger(input);

                final int bonusNumber = Integer.parseInt(input);
                validator.validatePositiveValue(bonusNumber);
                validator.validateIncludeDuplicateNumber(winnerNumbers, bonusNumber);
                this.bonusNumber = bonusNumber;
                return;
            } catch (IllegalArgumentException e) {
                outputHandler.printErrorMessage(e.getMessage());
            }
        }
    }

    public void printLottoStatus() {
        System.out.println();
        System.out.println(purchaseAmount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            lotto.printCurrentStatus();
        }
    }

    public void printLottoResult() {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            final LottoResultCalculator resultCalculator = new LottoResultCalculator(lotto);
            final Optional<PrizeStatus> result = resultCalculator.calculate(winnerNumbers, bonusNumber);
            if (result.isPresent()) {
                lottoResult.incrementPrizeCount(result.get());
            }
        }
        lottoResult.printResult(purchaseAmount * LOTTO_PRICE);
    }
}
