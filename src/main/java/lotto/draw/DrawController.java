package lotto.draw;

import lotto.draw.model.BonusNumber;
import lotto.draw.model.Draw;
import lotto.draw.model.DrawNumbers;

public class DrawController {
    DrawView drawView = new DrawView();

    public Draw drawLotto() {
        DrawNumbers drawNumbers = readDrawNumbers();
        BonusNumber bonusNumber = readBonusNumber(drawNumbers);
        return new Draw(drawNumbers, bonusNumber);
    }

    private DrawNumbers readDrawNumbers() {
        while (true) {
            try {
                String drawNumbersInput = drawView.readDrawNumber();
                return new DrawNumbers(drawNumbersInput);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private BonusNumber readBonusNumber(final DrawNumbers drawNumbers) {
        while (true) {
            try {
                String bonusNumberInput = drawView.readBonusNumber();
                return new BonusNumber(bonusNumberInput, drawNumbers);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
