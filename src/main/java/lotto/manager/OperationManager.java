package lotto.manager;

import lotto.io.IO;
import lotto.validate.Validator;

public class OperationManager {
    private final IO io = new IO();
    private final OutputManager out = new OutputManager();
    private final Validator validator = new Validator();
    private final LottoManager lottoManager = new LottoManager();

    public void purchase() {
        while (true) {
            try {
                String payment = io.payment();
                validator.payment(payment);
                out.purchaseLottoResult(lottoManager.create(Long.parseLong(payment)));

                break;
            } catch (IllegalArgumentException e) {
                io.printError(e.getMessage());
            }
        }
    }

    public void writeWinningNumber() {
        while (true) {
            try {
                String writeNumber = io.winningNumber();
                validator.winningNumber(writeNumber);
                lottoManager.createWinningNumber(writeNumber);

                break;
            } catch (IllegalArgumentException e) {
                io.printError(e.getMessage());
            }
        }
    }

    public void writeBonusNumber() {
        while (true) {
            try {
                String bonusNumber = io.bonusNumber();
                validator.bonusNumber(bonusNumber);
                lottoManager.setBonusNumber(Integer.parseInt(bonusNumber));

                break;
            } catch (IllegalArgumentException e) {
                io.printError(e.getMessage());
            }
        }
    }

    public void draw() {
        lottoManager.initWinningResult();
        out.lottoResult(lottoManager.winningCalculator());
        out.earningsRate(lottoManager.earningsRateCalculator());
    }

    public void execute() {
        purchase();
        writeWinningNumber();
        writeBonusNumber();
        draw();
    }
}
