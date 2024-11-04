package lotto.domain;

import lotto.util.AmountDivider;
import lotto.util.Parser;
import lotto.validate.Validator;

import java.util.*;

public class User {
    private final int purchaseAmount;
    private final int lottoTickets;
    private List<Lotto> lottoList;
    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    private User(String input) {
        String removedSpace = Parser.removeSpace(input);
        this.purchaseAmount = Validator.validateParsingToInt(removedSpace);
        Validator.validateDividedByUnit(purchaseAmount);
        this.lottoTickets = AmountDivider.divideLottoAmount(purchaseAmount);
    }

    public static User createUser(String input) {
        return new User(input);
    }

    public void setUpLottoList(List<Lotto> lottoList) {
        this.lottoList = Collections.unmodifiableList(lottoList);
    }

    public void setWinningNumbers(String input) {
        String removedSpace = Parser.removeSpace(input);
        this.winningNumbers = Parser.parseToList(removedSpace);
        List<Integer> validatedList = Validator.validationDuplicate(winningNumbers);
        Validator.validationSize(validatedList);
    }

    public void setBonusNumber(String input) {
        this.bonusNumber = Validator.validateParsingToInt(input);
        Validator.validationInRange(this.bonusNumber);
    }

    public int getLottoTickets() {
        return lottoTickets;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public Set<Integer> getWinningNumbers() {
        return new TreeSet<>(winningNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
