package lotto.dto;

public class WinningResultDTO {
    private Integer correct3;
    private Integer correct4;
    private Integer correct5;
    private Integer correct5withBonus;
    private Integer correct6;

    public WinningResultDTO() {
        this.correct3 = 0;
        this.correct4 = 0;
        this.correct5 = 0;
        this.correct5withBonus = 0;
        this.correct6 = 0;
    }

    public void addPointToCorrect3() {
        this.correct3++;
    }

    public void addPointToCorrect4() {
        this.correct4++;
    }

    public void addPointToCorrect5() {
        this.correct5++;
    }

    public void addPointToCorrect5withBonus() {
        this.correct5withBonus++;
    }

    public void addPointToCorrect6() {
        this.correct6++;
    }

    public Integer getCorrect3() {
        return correct3;
    }

    public Integer getCorrect4() {
        return correct4;
    }

    public Integer getCorrect5() {
        return correct5;
    }

    public Integer getCorrect5withBonus() {
        return correct5withBonus;
    }

    public Integer getCorrect6() {
        return correct6;
    }
}
