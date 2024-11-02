package lotto.utils;

public enum LottoMatchStatus {
    THREE_MATCH_RESULT("3개 일치(5,000원)"),
    FOUR_MATCH_RESULT("4개 일치 (50,000원)"),
    FIVE_MATCH_RESULT("5개 일치 (1,500,000원)"),
    FIVE_MATCH_WITH_BONUS_RESULT("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCH_RESULT("6개 일치 (2,000,000,000원)");
    private String status;
    LottoMatchStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return status;
    }
}
