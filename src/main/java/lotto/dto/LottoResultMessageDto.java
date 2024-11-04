package lotto.dto;

public class LottoResultMessageDto {

    private String winningRate;
    private String resultMessage;

    public LottoResultMessageDto(String winningRate, String resultMessage) {
        this.winningRate = winningRate;
        this.resultMessage = resultMessage;
    }

    public String getWinningRate() {
        return winningRate;
    }

    public void setWinningRate(String winningRate) {
        this.winningRate = winningRate;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
