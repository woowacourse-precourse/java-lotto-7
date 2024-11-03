package lotto.model.win;

public enum Prize {

    NOTHING(0, 0, "%d개 일치 (%,d원) - %d개"),
    FIFTH(5000, 3, "%d개 일치 (%,d원) - %d개"),
    FOURTH(50000, 4, "%d개 일치 (%,d원) - %d개"),
    THIRD(1500000, 5, "%d개 일치 (%,d원) - %d개"),
    SECOND(30000000, 5, "%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    WIN(2000000000, 6, "%d개 일치 (%,d원) - %d개");

    public final int money;
    public final int correct;
    public final String outputFormat;

    Prize(int money, int correct, String outputFormat) {
        this.money = money;
        this.correct = correct;
        this.outputFormat = outputFormat;
    }
}
