package lotto;

import static lotto.Inputor.getBounsNumbers;
import static lotto.Inputor.getDrawnNumbers;
import static lotto.Inputor.getLottoDrawCount;
import static lotto.LottoGenerator.generateLottos;
import static lotto.OutputPrinter.printLotto;
import static lotto.OutputPrinter.printPrizeSummary;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class LottoApplication {
    public void start() {

        int lottoDrawCount = getLottoDrawCount();

        List<Lotto> lottos = generateLottos(lottoDrawCount);
        printLotto(lottos);

        List<Integer> drawnNumbers = getDrawnNumbers();

        Integer bounsNumber = getBounsNumbers();

        ConcurrentHashMap<Prize, Integer> prizeSummary = new ConcurrentHashMap<>();

        for (Lotto lotto : lottos) {
            getPrizeSummary(lotto, drawnNumbers, bounsNumber, prizeSummary);
        }

        printPrizeSummary(prizeSummary, lottoDrawCount);


    }

    private static void getPrizeSummary(Lotto lotto, List<Integer> drawnNumbers, Integer bounsNumber,
                                        ConcurrentHashMap<Prize, Integer> prizeSummary) {

        Prize result = matchLotto(lotto, drawnNumbers, bounsNumber);
        if (result != null)
            updatePrizeSummary(prizeSummary, result);
    }

    private static ConcurrentHashMap<Prize, Integer> updatePrizeSummary(
            ConcurrentHashMap<Prize, Integer> prizeSummary, Prize result) {

        prizeSummary.compute(result, (key, value) -> {
            if (value == null) {
                return 1;
            } else {
                return value + 1;
            }
        });

        return prizeSummary;
    }

    private static Prize matchLotto(Lotto lotto, List<Integer> drawnNumbers, Integer bounsNumber) {

        Float matchingResult = lotto.countCommonNumbers(drawnNumbers);

        if (matchingResult == 5 && lotto.getLottoNumbers().contains(bounsNumber)) {
            matchingResult += 0.5F;
        }

        return Prize.findByMatchingNumber(matchingResult);
    }
}
