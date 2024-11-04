package lotto.domain;

import lotto.message.ExceptionMessage;

public class WinningLotto {
    private final Lotto answerLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto answerLotto, BonusNumber bonusNumber) {
        validateDuplicateBonusNumber(answerLotto, bonusNumber);
        this.answerLotto = answerLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateBonusNumber(Lotto answerLotto, BonusNumber bonusNumber) {
        int bonusNumberValue = bonusNumber.getNumber();
        if (answerLotto.getLottoNumbers().stream().anyMatch(number -> number == bonusNumberValue)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_BONUS_NUMBER);
        }
    }

    public LottoResult calculateResult(Lottos lottos) {
        LottoResult lottoResultForm = new LottoResult(LottoRank.createLottoResultForm());
        lottos.getLottos()
                .stream()
                .map(this::calculateLottoRank)
                .forEach(lottoResultForm::addCountByLottoRank);
        return lottoResultForm;
    }

    public LottoRank calculateLottoRank(Lotto userLotto) {
        int matchCount = answerLotto.getMatchCount(userLotto);
        boolean matchBonusFlag = userLotto.hasNumber(bonusNumber.getNumber());
        if (matchBonusFlag) {
            matchCount += 1;
        }
        return LottoRank.findLottoRankByMatchCountAndBonus(matchCount, matchBonusFlag);
    }
}
