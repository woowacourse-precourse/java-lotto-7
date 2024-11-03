package lotto.model;

import static lotto.constants.CommonConstants.LOTTO_SIZE;
import static lotto.constants.CommonConstants.MAX_LOTTO_NUMBER;
import static lotto.constants.CommonConstants.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoPurchaseDetails {
    private static final String PURCHASED_NUM_LOTTO_MESSAGE = "%d개를 구매했습니다.";
    private static final String NEW_LINE = "\n";

    private final long numLotto;
    private final List<Lotto> lottoGroup;

    public LottoPurchaseDetails(long numLotto) {
        this.numLotto = numLotto;
        lottoGroup = generateLottoGroup(numLotto);
    }

    public List<Lotto> getLottoGroup() {
        return lottoGroup;
    }

    public String getPurchaseDetailsMessage() {
        StringBuilder purchaseDetailsMessage = new StringBuilder();

        purchaseDetailsMessage.append(String.format(PURCHASED_NUM_LOTTO_MESSAGE, numLotto)).append(NEW_LINE);
        for (Lotto lotto : lottoGroup) {
            purchaseDetailsMessage.append(lotto.getNumbers()).append(NEW_LINE);
        }

        return purchaseDetailsMessage.toString();
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
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }
}
