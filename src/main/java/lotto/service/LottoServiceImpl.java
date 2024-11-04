package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoWinningNumbers;
import lotto.dto.lottoDto.LottoResponse;
import lotto.dto.lottoWinningResultDto.LottoWinningResult;
import lotto.dto.lottoWinningResultDto.LottoWinningResultRequest;
import lotto.dto.lottoWinningResultDto.LottoWinningResultResponse;
import lotto.message.Constant;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.policy.BonusNumberPolicy;
import lotto.policy.LottoPolicy;
import lotto.util.StringParser;
import lotto.view.InputView;
import lotto.view.InputViewImpl;
import lotto.view.OutputView;
import lotto.view.OutputViewImpl;

public class LottoServiceImpl implements LottoService {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoServiceImpl() {
        this.inputView = new InputViewImpl();
        this.outputView = new OutputViewImpl();
    }

    @Override
    public Money inputLottoMoney() {
        String userInputMoney = inputView.inputMoney();
        try {
            return new Money(userInputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLottoMoney();
        }
    }

    @Override
    public int calculatePurchasableLottoCount(Money _money) {
        int money = Integer.parseInt(_money.getMoney());
        return money / 1000;
    }

    @Override
    public List<Lotto> issueLotto(int purchasableLottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchasableLottoCount; i++) {
            lottos.add(issueOneLotto());
        }

        return lottos;
    }

    public Lotto issueOneLotto() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lotto = lotto.stream().sorted().collect(Collectors.toList());
        return new Lotto(lotto);
    }

    @Override
    public void printIssuedLotto(LottoResponse lottoResponse) {
        outputView.printIssuedLotto(lottoResponse);
    }


    @Override
    public LottoWinningResultRequest inputLottoWinningResult() {
        String winningNumbers = inputWinningNumbers();
        String bonusNumber = inputBonusNumber(new Lotto(StringParser.parse(winningNumbers)));
        return new LottoWinningResultRequest(winningNumbers, bonusNumber);
    }

    public String inputWinningNumbers() {
        String winningNumbers = inputView.inputWinningNumbers();
        try {
            new LottoPolicy().checkLottoPolicy(StringParser.parse(winningNumbers));
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
    }

    public String inputBonusNumber(Lotto lotto) {
        String bonusNumber = inputView.inputBonusNumber(lotto);
        try {
            new BonusNumberPolicy().checkBonusNumberPolicy(bonusNumber, lotto);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(lotto);
        }

    }

    @Override
    public LottoWinningResult analyzeWinningResult(LottoWinningNumbers lottoWinningNumbers,
                                                   List<Lotto> issuedLotto) {
        List<Integer> lottoResult = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        for (Lotto lotto : issuedLotto) {
            int lottoRank = getRank(lottoWinningNumbers, lotto);
            if (lottoRank == Constant.NO_RANK.getConstant()) {
                continue;
            }
            lottoResult.set(lottoRank - 1, lottoResult.get(lottoRank - 1) + 1);
        }

        return new LottoWinningResult(lottoResult.get(0), lottoResult.get(1), lottoResult.get(2), lottoResult.get(3),
                lottoResult.get(4));
    }

    private int getRank(LottoWinningNumbers lottoWinningNumbers, Lotto lotto) {
        int bonusNumber = lottoWinningNumbers.bonusNumber();
        int result = compareWinningLotto(lottoWinningNumbers, lotto);
        if (result == Constant.LOTTO_SIX_MATCHES.getConstant()) {
            return 1;
        }
        if (isContainedBonusNumber(lotto, bonusNumber) && result == Constant.LOTTO_FIVE_MATCHES.getConstant()) {
            return 2;
        }
        if (result < Constant.LOTTO_FOUR_MATCHES.getConstant()) {
            return 0;
        }

        return Constant.RANK_EXTRACT_NUMBER.getConstant() - result;
    }

    private int compareWinningLotto(LottoWinningNumbers lottoWinningNumbers, Lotto lotto) {
        Lotto winningLotto = lottoWinningNumbers.winningLotto();
        int result = 0;
        for (Integer number : winningLotto.getNumbers()) {
            if (lotto.getNumbers().contains(number)) {
                result++;
            }
        }
        return result;
    }

    private boolean isContainedBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    @Override
    public double analyzeLottoRateOfReturn(LottoWinningResult lottoWinningResult, int lottoCount) {
        double money = lottoCount * Constant.MONEY_CONVERSION.getConstant();
        double lottoWinningAmount
                = lottoWinningResult.firstPlaceNumber() * Constant.FIRST_PRIZE_MONEY.getConstant()
                + lottoWinningResult.secondPlaceNumber() * Constant.SECOND_PRIZE_MONEY.getConstant()
                + lottoWinningResult.thirdPlaceNumber() * Constant.THIRD_PRIZE_MONEY.getConstant()
                + lottoWinningResult.fourthPlaceNumber() * Constant.FOURTH_PRIZE_MONEY.getConstant()
                + lottoWinningResult.fifthPlaceNumber() * Constant.FIFTH_PRIZE_MONEY.getConstant();

        return (double) Math.round(lottoWinningAmount / money * 1000) / 10;
    }

    @Override
    public void printAnalyzedLottoStatus(LottoWinningResultResponse lottoWinningResultResponse) {
        outputView.printLottoResult(lottoWinningResultResponse);
    }
}
