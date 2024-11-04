package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.generator.LottoGenerator;
import lotto.model.Lotto;
import lotto.model.LottoGroup;
import lotto.model.Pay;

public class LottoService {
    private static final int MATCHED_LIST_LENGTH = 5;
    private static final int BONUS_CHECK_NUMBER = 5;
    private static final int THREE_MATCHED = 0;
    private static final int FOUR_MATCHED = 1;
    private static final int FIVE_MATCHED = 2;
    private static final int FIVE_BONUS_MATCHED = 3;
    private static final int SIX_MATCHED = 4;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    PrintService printService = PrintService.createPrintService();
    LottoGenerator lottoGenerator = LottoGenerator.createLottoGenerator();

    private LottoService() {

    }

    public static LottoService createLottoService() {
        return new LottoService();
    }

    public List<int[]> calculateMatched(LottoGroup lottoGroup, Lotto winnerLotto,
                                        int bonusNumber) {
        List<int[]> matchedList = new ArrayList<>();
        List<Lotto> lottos = lottoGroup.getLottos();
        for (Lotto lotto : lottos) {
            List<Integer> checkSet = new ArrayList<>(lotto.getNumbers());
            checkSet.retainAll(winnerLotto.getNumbers());
            matchedList = checkBonusMatched(lotto, checkSet, matchedList, bonusNumber);
            matchedList = checkThreeMatched(lotto, checkSet, matchedList);
            matchedList = checkFourMatched(lotto, checkSet, matchedList);
            matchedList = checkSixMatched(lotto, checkSet, matchedList);
        }
        return matchedList;
    }

    private List<int[]> checkSixMatched(Lotto lotto, List<Integer> checkSet, List<int[]> matchedList) {
        if (checkSet.size() == SIX) {
            int[] matched = addMatched(SIX_MATCHED);
            matchedList.add(matched);
        }
        return matchedList;
    }

    private List<int[]> checkFourMatched(Lotto lotto, List<Integer> checkSet, List<int[]> matchedList) {
        if (checkSet.size() == FOUR) {
            int[] matched = addMatched(FOUR_MATCHED);
            matchedList.add(matched);
        }
        return matchedList;
    }

    private List<int[]> checkThreeMatched(Lotto lotto, List<Integer> checkSet, List<int[]> matchedList) {
        if (checkSet.size() == THREE) {
            int[] matched = addMatched(THREE_MATCHED);
            matchedList.add(matched);
        }
        return matchedList;
    }

    private List<int[]> checkBonusMatched(Lotto lotto, List<Integer> checkSet, List<int[]> matchedList,
                                          int bonusNumber) {
        if (checkSet.size() == FIVE) {
            if (lotto.getNumbers().contains(bonusNumber)) {
                int[] matched = addMatched(FIVE_BONUS_MATCHED);
                matchedList.add(matched);
            }
            if (!lotto.getNumbers().contains(bonusNumber)) {
                int[] matched = addMatched(FIVE_MATCHED);
                matchedList.add(matched);
            }
        }
        return matchedList;
    }

    private int[] addMatched(int bonusCheckNumber) {
        int[] matched = new int[MATCHED_LIST_LENGTH];
        matched[bonusCheckNumber]++;
        return matched;
    }

    public Pay payInput() {
        try {
            printService.printInsertPay();
            String payInput = Console.readLine();
            Pay pay = Pay.createPay(payInput);
            return pay;
        } catch (NumberFormatException e) {
            printService.printPayInputError();
            return payInput();
        } catch (IllegalArgumentException e) {
            printService.printNotThousand();
            return payInput();
        }
    }

    public LottoGroup generateLottoGroup(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Lotto lotto = Lotto.createLotto(lottoGenerator.getLottoNumbers());
            lottos.add(lotto);
        }
        return LottoGroup.createLottoGroup(lottos);
    }

    public Lotto generateWinnerLotto() {
        try {
            String numbers = Console.readLine();
            if (numbers.isEmpty()) {
                return Lotto.createLotto(lottoGenerator.getLottoNumbers());
            }
            return Lotto.createLottoByString(numbers);
        } catch (IllegalArgumentException e) {
            printService.printSyntaxError();
            return generateWinnerLotto();
        }
    }

    public int validateBonusNumber(Lotto winnerLotto) {
        try {
            String bonusInput = Console.readLine();
            if (bonusInput.isEmpty()) {
                return validateDuplicatedBonusNumber(winnerLotto, bonusInput);
            }
            return validateIsNumber(winnerLotto, bonusInput);
        } catch (NumberFormatException e) {
            printService.printSyntaxError();
            return validateBonusNumber(winnerLotto);
        }
    }

    private int validateIsNumber(Lotto winnerLotto, String bonusInput) {
        try {
            int bonusNumber = Integer.parseInt(bonusInput);
            return validateCorrectRange(winnerLotto, bonusNumber);
        } catch (NumberFormatException e) {
            printService.printWrongRange();
            return validateBonusNumber(winnerLotto);
        }
    }

    private int validateCorrectRange(Lotto winnerLotto, int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            printService.printWrongRange();
            return validateBonusNumber(winnerLotto);
        }
        if (winnerLotto.validateBonusNumberIsDuplicated(bonusNumber)) {
            printService.printWrongBonusNumber(bonusNumber);
            return validateBonusNumber(winnerLotto);
        }
        return bonusNumber;
    }

    private int validateDuplicatedBonusNumber(Lotto winnerLotto, String bonusInput) {
        int bonusNumber = lottoGenerator.getBonusNumber();
        while (winnerLotto.validateBonusNumberIsDuplicated(bonusNumber)) {
            bonusNumber = lottoGenerator.getBonusNumber();
        }
        return bonusNumber;
    }
}
