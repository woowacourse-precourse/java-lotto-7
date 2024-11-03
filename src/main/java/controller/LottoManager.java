package controller;

import service.LottoMaker;
import view.Input;
import view.Output;

public class LottoManager {
    Input input = new Input();
    Output output = new Output();
    LottoMaker lottoMaker = new LottoMaker();

    public void run() {
        IoPurchaseAmount();
        printLottoNumbers();
        IoWinningNumbers();
        IoBonusNumber();
        printWinningResult();
    }

    private void IoPurchaseAmount() {
        while (true) {
            try {
                int lottoAmount = lottoMaker.getLottoCount(input.getPurchaseAmount());
                lottoMaker.createLotto();
                output.printPurchaseAmount(lottoAmount);
                output.printNewLine();
                break;
            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }

    private void printLottoNumbers() {
        output.printLottoNumbers(lottoMaker.getLottoNumbers());
        output.printNewLine();
    }

    private void IoWinningNumbers() {
        while (true) {
            try {
                lottoMaker.setWinningNumbers(input.getWinningNumbers());
                output.printNewLine();
                break;
            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }

    public void IoBonusNumber() {
        while (true) {
            try {
                lottoMaker.setBonusNumber(input.getBonusNumber());
                output.printNewLine();
                break;
            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }

    public void printWinningResult() {
        output.printWinningResult(lottoMaker.getWinningResults());
        output.printProfitRate(lottoMaker.getProfitRate());
    }


}
