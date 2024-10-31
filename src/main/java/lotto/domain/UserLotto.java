package lotto.domain;

public class UserLotto {
    private Lotto Winning_Lotto;
    private int bonus_Number;

    public UserLotto(Lotto Winning_Lotto, int bonus_Number) {
        this.Winning_Lotto = Winning_Lotto;
        this.bonus_Number = bonus_Number;
    }

    public Lotto getWinning_Lotto() {
        return Winning_Lotto;
    }
    public void getWinning_Lotto(Lotto Winning_Lotto) {
        this.Winning_Lotto = Winning_Lotto;
    }

}
