package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.LottoBundle;
import lotto.model.LottoFactory;
import lotto.model.Wallet;
import lotto.model.WinningNumbers;
import lotto.view.OutputView;

import static lotto.view.InputView.readBonusNumber;
import static lotto.view.InputView.readPurchaseMoney;
import static lotto.view.InputView.readWinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class MainController {
    public static void run() {
        Wallet myWallet = makeWallet();
        OutputView.printPurchaseAmount(myWallet.getAffordableLottoAmount());
        LottoBundle lottoBundle = purchaseLottoBundle(myWallet);
        OutputView.printAllLottosNumbers(lottoBundle);
        WinningNumbers winningNumbers = askWinningNumbers();
        BonusNumber bonusNumber = askBonusNumber(winningNumbers);
        
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
}
