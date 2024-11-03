package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoPurchaseDetails {
    private static final int START = 1;
    private static final int END = 45;
    private static final int COUNT = 6;

    private final long numLottto;
    private final List<Lotto> lottoGroup;

    public LottoPurchaseDetails(long numLottto) {
        this.numLottto = numLottto;
        lottoGroup = generateLottoGroup(numLottto);
    }

    public List<Lotto> getLottoGroup() {
        return lottoGroup;
    }

    public long getNumLottto() {
        return numLottto;
    }

    private List<Lotto> generateLottoGroup(long numLotto) {
        List<Lotto> generatedLottoGroup = new ArrayList<>();
        Set<Integer> lottoIds = new HashSet<>();

        while (needsMoreLottos(numLotto, generatedLottoGroup)) {
            Lotto newLotto = generateLotto();
            addIfNotDuplicated(lottoIds, newLotto, generatedLottoGroup);
        }

        return generatedLottoGroup;
    }

    private static void addIfNotDuplicated(Set<Integer> lottoIds, Lotto newLotto, List<Lotto> generatedLottoGroup) {
        if (isNotDuplicateId(lottoIds, newLotto)) {
            generatedLottoGroup.add(newLotto);
            lottoIds.add(newLotto.getId());
        }
    }

    private static boolean isNotDuplicateId(Set<Integer> lottoIds, Lotto newLotto) {
        return !lottoIds.contains(newLotto.getId());
    }

    private static boolean needsMoreLottos(long numLotto, List<Lotto> generatedLottoGroup) {
        return generatedLottoGroup.size() < numLotto;
    }

    private static Lotto generateLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(START, END, COUNT);
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }


}
