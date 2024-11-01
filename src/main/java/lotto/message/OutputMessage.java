package lotto.message;

public enum OutputMessage {
    OUTPUT_BUY_LOTTOS("%d개를 구매했습니다.");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return String.format(message);
    }

    public String getFormatMessage(int formatInteger){
        return String.format(message, formatInteger);
    }

}
