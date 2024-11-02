package lotto.controller;

import lotto.domain.play.RandomLottoGenerator;
import lotto.domain.play.Result;
import lotto.domain.purchase.LottoMoney;
import lotto.domain.purchase.LottoShop;
import lotto.domain.play.WinCriteria;
import lotto.domain.purchase.UserMoney;
import lotto.domain.rule.PrizeRank;
import lotto.domain.ticket.Lotto;
import lotto.domain.play.LottoInventory;
import lotto.domain.ticket.LottoNumber;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.dto.PrizeRankInfoDto;
import lotto.dto.ResultDto;
import lotto.io.InputReader;
import lotto.io.view.View;
import lotto.utils.NumberInputConverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    private final NumberInputConverter numberInputConverter = NumberInputConverter.getInstance();
    private final InputReader reader;
    private final View view;

    public LottoController(InputReader reader, View view) {
        this.reader = reader;
        this.view = view;
    }

    public void run() {
        LottoShop lottoShop = new LottoShop(RandomLottoGenerator.getInstance());
        LottoMoney money = requestMoney();
        UserMoney userMoney = new UserMoney(money.getValue());
        List<Lotto> lottos = lottoShop.purchaseLottoWith(money);
        LottoInventory lottoInventory = new LottoInventory(lottos);
        showPurchaseInfo(lottos);

        List<Integer> userInputWinningNumbers = requestWinningNumbers();
        Lotto winLotto = new Lotto(userInputWinningNumbers);

        int bonusNumberValue = requestBonusNumber();
        LottoNumber bonus = LottoNumber.of(bonusNumberValue);
        WinCriteria winCriteria = new WinCriteria(winLotto, bonus);

        Result result = lottoInventory.calculateResult(winCriteria);
        UserMoney profit = new UserMoney(result.calculateTotalProfit());
        float ratio = userMoney.calculateRatioTo(profit);
        showResult(result, ratio);
    }

    private void showResult(Result result, float ratio) {
        ResultDto resultDto = toResultDto(result, ratio);
        view.getResultView().show(resultDto);
    }

    private void showPurchaseInfo(List<Lotto> lottos) {
        LottosDto lottosDto = toLottosDto(lottos);
        view.getLottoBuyView().showBuyInfo(lottosDto);
    }

    private int requestBonusNumber() {
        view.getInputView().showBonusNumberExplanation();
        return numberInputConverter.toInt(reader.read());
    }

    private List<Integer> requestWinningNumbers() {
        view.getInputView().showWinningNumberExplanation();
        return numberInputConverter.toList(reader.read());
    }

    private LottoMoney requestMoney() {
        view.getInputView().showMoneyInputExplanation();
        int userInputMoney = numberInputConverter.toInt(reader.read());
        return LottoMoney.of(userInputMoney);
    }

    private LottosDto toLottosDto(List<Lotto> lottos) {
        List<LottoDto> lottoDtos = lottos.stream()
                .map(Lotto::peekAll)
                .map(lottoNumbers -> lottoNumbers.stream()
                        .map(LottoNumber::getNumber)
                        .toList())
                .map(LottoDto::new)
                .toList();
        return new LottosDto(lottoDtos);
    }

    private ResultDto toResultDto(Result result, float profitRatio) {
        Map<PrizeRankInfoDto, Integer> prizeRankCounts = new HashMap<>();
        for (PrizeRank prizeRank : PrizeRank.values()) {
            PrizeRankInfoDto info = new PrizeRankInfoDto(prizeRank.getDescription(), prizeRank.getPrize());
            prizeRankCounts.put(info, result.findCount(prizeRank));
        }
        return new ResultDto(prizeRankCounts, profitRatio);
    }
}
