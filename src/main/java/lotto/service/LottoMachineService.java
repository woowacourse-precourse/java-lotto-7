package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Member;
import lotto.enums.lotto.LottoRank;
import lotto.util.LottoParser;
import lotto.util.LottoValidator;

public class LottoMachineService {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final LottoMachine lottoMachine = LottoMachine.getInstance();
    private final Member member = Member.getInstance();

    public void inputLottoPurchaseAmount(String purchaseAmount) {
        int validPrice = LottoValidator.validNumber(purchaseAmount);
        LottoValidator.validatePriceUnit(validPrice);
        lottoMachine.savePurchaseAmount(validPrice);
        member.savePurchaseAmount(validPrice);
    }

    public void inputBonusNumber(String bonusNumber) {
        int validBonusNumber = LottoValidator.validNumber(bonusNumber);
        LottoValidator.validateDuplicateBonusNumber(lottoMachine.getWinningLotto(), validBonusNumber);
        lottoMachine.saveBonusNumber(validBonusNumber);
    }

    public void inputWinningNumbers(String numbers) {
        List<Integer> winningNumbers = LottoParser.parsingNumber(numbers);
        LottoValidator.validateLottoNumber(winningNumbers);
        lottoMachine.saveWinningNumbers(winningNumbers);
    }

    public void issueLottos() {
        int numberOfIssues = LottoParser.parsingPrice(lottoMachine.getPurchaseAmount());
        for (int number = 0; number < numberOfIssues; number++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
            member.saveIssuedLotto(new Lotto(numbers));
        }
    }

    public int correctLottoNumber(Lotto lotto) {
        List<Integer> memberLotto = lotto.getNumbers();
        List<Integer> winningLotto = lottoMachine.getWinningLotto().getNumbers();

        return (int) memberLotto.stream()
                .filter(winningLotto::contains)
                .count();
    }

    public boolean correctBonusNumber(Lotto lotto) {
        List<Integer> memberLotto = lotto.getNumbers();
        return memberLotto.contains(lottoMachine.getBonusNumber());
    }

    public void giveCorrectCountAndMoney() {
        for (Lotto lotto : member.getIssuedLottos()) {
            int matchCount = correctLottoNumber(lotto);
            boolean hasBonus = correctBonusNumber(lotto);

            LottoRank lottoRank = LottoRank.valueOf(matchCount, hasBonus);

            if (lottoRank != null) {
                member.addLottoResult(lottoRank);
            }
        }
    }
}
