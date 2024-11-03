package lotto.controller;

import lotto.domain.purchase.LottoInventoryGenerator;
import lotto.domain.play.Result;
import lotto.domain.purchase.LottoMoney;
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
import lotto.utils.IllegalArgumentHandler;
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
        UserMoney initMoney = requestMoney();
        LottoInventory lottoInventory = LottoInventoryGenerator.generateFrom(initMoney);
        showPurchaseInfo(lottoInventory.getAll());
        Lotto winLotto = requestWinLotto();
        WinCriteria winCriteria = requestBonusNumberAndGenerateFrom(winLotto);
        Result result = lottoInventory.calculateResult(winCriteria);
        float ratio = calculateProfitRatioBasedOn(initMoney, result);
        showResult(result, ratio);
    }

    private static float calculateProfitRatioBasedOn(UserMoney firstMoney, Result result) {
        UserMoney spendMoney = firstMoney.getMaxSpendAvailable();
        UserMoney profitMoney = new UserMoney(result.calculateTotalProfit());
        return spendMoney.calculateRatioTo(profitMoney);
    }

    private void showResult(Result result, float ratio) {
        ResultDto resultDto = toResultDto(result, ratio);
        view.getResultView().show(resultDto);
    }

    private void showPurchaseInfo(List<Lotto> lottos) {
        LottosDto lottosDto = toLottosDto(lottos);
        view.getLottoBuyView().showBuyInfo(lottosDto);
    }

    private WinCriteria requestBonusNumberAndGenerateFrom(Lotto winLotto) {
        return new IllegalArgumentHandler<WinCriteria>().doUntilNoOccur(() -> {
            view.getInputView().showBonusNumberExplanation();
            int bonusNumberValue = numberInputConverter.toInt(reader.read());
            return new WinCriteria(winLotto, LottoNumber.of(bonusNumberValue)) ;
        });
    }

    private Lotto requestWinLotto() {
        return new IllegalArgumentHandler<Lotto>().doUntilNoOccur(() -> {
            view.getInputView().requestWinLottoExplanation();
            return new Lotto(numberInputConverter.toList(reader.read()));
        });
    }

    private UserMoney requestMoney() {
        return new IllegalArgumentHandler<UserMoney>().doUntilNoOccur(() -> {
            view.getInputView().showMoneyInputExplanation();
            int userInputMoney = numberInputConverter.toInt(reader.read());
            return new UserMoney(LottoMoney.of(userInputMoney));
        });
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
