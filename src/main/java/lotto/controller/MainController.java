package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoBundle;
import lotto.model.LottoFactory;
import lotto.model.LottoRanks;
import lotto.model.Wallet;
import lotto.model.WinningNumbers;
import lotto.utils.LottoRank;
import lotto.view.OutputView;

import static lotto.view.InputView.readBonusNumber;
import static lotto.view.InputView.readPurchaseMoney;
import static lotto.view.InputView.readWinningNumbers;
import static lotto.view.OutputView.printLottoBundleResultHeader;
import static lotto.view.OutputView.printLottoRankResult;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class MainController {
    public static void run() {
        Wallet myWallet = makeWallet();
        OutputView.printPurchaseAmount(myWallet.getAffordableLottoAmount());
        LottoBundle lottoBundle = purchaseLottoBundle(myWallet);
        OutputView.printAllLottosNumbers(lottoBundle);
        WinningNumbers winningNumbers = askWinningNumbers();
        BonusNumber bonusNumber = askBonusNumber(winningNumbers);
        LottoRanks lottoRanks = computeLottoBundleResult(lottoBundle, winningNumbers, bonusNumber);
        makeStatistic(lottoRanks, myWallet);
    }

    public static Wallet makeWallet() {
        while (true) {
            try {
                String purchaseMoney = readPurchaseMoney();
                return new Wallet(purchaseMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static LottoBundle purchaseLottoBundle(Wallet wallet) {
        int amount = wallet.getAffordableLottoAmount();
        return LottoFactory.makeLottosByWalletMoney(amount);
    }

    public static WinningNumbers askWinningNumbers() {
        while (true) {
            try {
                String winningNumbersInput = readWinningNumbers();
                // TODO. Refactor to parser
                List<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(",")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());  
                // 여기서 exception이 발생하면 어떤 exception이지?
                return new WinningNumbers(winningNumbers);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static BonusNumber askBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                String bonusNumberInput = readBonusNumber();
                Integer bonusNumberArgument = Integer.parseInt(bonusNumberInput);

                BonusNumber bonusNumber = new BonusNumber(winningNumbers.getWinningNumbers(), bonusNumberArgument);

                return bonusNumber;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static LottoRanks computeLottoBundleResult(LottoBundle lottoBundle, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        List<LottoRank> lottoRanks = lottoBundle.getLottos().stream().map(lotto -> computeSingleLottoResult(lotto, winningNumbers, bonusNumber)).filter(Objects::nonNull).toList();
        
        return new LottoRanks(lottoRanks);
    }

    private static LottoRank computeSingleLottoResult(Lotto lotto, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        Integer matchCount = 0;
        for (Integer lottoNumber : lotto.getNumbers()) {
            if (winningNumbers.getWinningNumbers().contains(lottoNumber)) {
                matchCount++;
            }
        }
        boolean containsBonusNumber = lotto.getNumbers().contains(bonusNumber);

        return LottoRank.getLottoRankByMatchResult(matchCount, containsBonusNumber);
    }

    public static void makeStatistic(LottoRanks lottoRanks, Wallet myWallet) {
        printLottoBundleResultHeader();
        for (LottoRank lottoRank : LottoRank.values()) {
            Integer count = (Integer) (int) lottoRanks.getLottoRanks().stream().filter(l -> l.getMatchCount().equals(lottoRank.getMatchCount())).count();
            printLottoRankResult(lottoRank, count);
        }
    }
}
