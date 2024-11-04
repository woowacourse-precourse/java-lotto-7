# java-lotto-precourse
## 로또

### 🧱클래스 다이어그램

### 🧾기능 요구 사항
#### 패키지 구조
<div align="center">
<table> 
<tr> 
	<th align="center">Package</th> 
	<th align="center">Class</th> 
	<th align="center">Description</th> 
</tr>
<tr> 
	<td>Container</td><td>DependencyInjectionContainer</td><td>의존성 주입 컴포넌트 컨테이너</td> 
</tr>
<tr> 
	<td>Controller</td><td>PurchaseLottoController</td><td>메인 로직 컨트롤러</td> 
</tr>
<tr> 
	<td rowspan="2">Service</td>
    <td>AmountService</td><td>`PurchaseAmount` & `ProfitAmount` 비즈니스 로직 처리</td> </tr><tr> 
    <td>LottoService</td><td>`Lotto` & `Lottos` 비즈니스 로직 처리</td> 
</tr>
<tr> 
	<td rowspan="6">Model</td>
    <td>PurchaseAmount</td><td>로또 구입 금액</td></tr><tr>
    <td>ProfitAmount</td><td>로또 당첨 금액</td></tr><tr>
    <td>Bonus</td><td>로또의 보너스 번호</td></tr><tr> 
    <td>WinningLotto</td><td>로또의 당첨 번호 & `Bonus`를 관리하는 일급 컬렉션</td></tr><tr>
	<td>Lotto</td><td>로또의 숫자를 관리하는 일급 컬렉션</td></tr><tr> 
    <td>PurchasedLottos</td><td>구매한 `Lotto`(들)을 관리하는 일급 컬렉션</td>
</tr>
<tr> 
	<td rowspan="3">Command</td>
    <td>PurchaseAmountCommand</td><td>로또 구입 금액 입력 검증 커맨드</td></tr><tr>
    <td>LottoCommand</td><td>로또의 당첨 번호 입력 검증 커맨드</td></tr><tr>
    <td>BonusCommand</td><td>로또의 보너스 번호 입력 검증 커맨드</td></tr><tr>
</tr> 

<tr> 
    <td rowspan="1">View</td> 
    <td>View</td><td>사용자 입/출력 처리</td></tr><tr>
</tr> 
<tr> 
    <td rowspan="6">DTO</td>
    <td>PurchaseAmountUserInput</td> <td>로또 구입 금액 사용자 입력</td></tr><tr>
    <td>WinningLottoUserInput</td> <td>로또의 당첨 번호 사용자 입력</td></tr><tr>
    <td>BonusUserInput</td> <td>로또의 보너스 번호 사용자 입력</td></tr><tr>
    <td>MatchResult</td> <td>`PurchaseLottos`의 당첨 결과</td></tr><tr>
    <td>MatchResults</td> <td>`MatchResult`의 일급 컬렉션</td></tr><tr>
    </tr> 
<tr> <td>Exception</td> 
    <td>GlobalException</td><td>전역 에러 처리</td> 
</tr> 
</table>
</div>

#### 단계별 구현
<table> 
⬜✅
<tr> 
	<th align="center">기능</th> 
	<th align="center">컴포넌트</th> 
	<th align="center">구현</th> 
    <th align="center">브랜치</th> 
</tr>
<tr>
    <td rowspan="4">예외처리</td>
        <td rowspan="1"><b><em>GlobalException</em></b></td>
            <td>✅전역 예외처리</td>
                <td rowspan="4">exception</td></tr><tr>
        <td rowspan="1"><b><em>InputException</em></b></td>
        <td>✅사용자 입력 관련 예외처리</td> </tr><tr> 
        <td rowspan="1"><b><em>AmountException</em></b></td>
        <td>✅금액 관련 예외처리</td> </tr><tr> 
        <td rowspan="1"><b><em>LottoException</em></b></td>
        <td>✅로또 관련 예외처리</td> </tr><tr> 
	<td rowspan="3">로또 구입 금액 사용자 입력</td>
        <td rowspan="1"><b><em>PurchaseAmountCommand</em></b></td>
        <td>✅`PurchaseAmount` 유효성 검증</td> 
                <td rowspan="3">feat/purchase-amount-input</td></tr><tr> 
        <td rowspan="1"><b><em>View</em></b></td>
            <td>✅`PurchaseAmountUserInput` 사용자 입력 처리 </td> </tr><tr> 
        <td rowspan="1">PurchaseAmountCommand</td>
            <td>✅`PurchaseAmountUserInput` 반환</td> </tr><tr>
    <td rowspan="6">로또 구매</td>
        <td rowspan="1"><b><em>Lotto</em></b></td>
            <td>✅1장 가격 상수 </td> 
                <td rowspan="6">feat/purchase-lottos</td></tr><tr> 
        <td rowspan="1"><b><em>LottoService</em></b></td>
            <td>✅`Lotto` 1장 가격 반환</td> </tr><tr> 
        <td rowspan="1"><b><em>AmountService</em></b></td>
            <td>✅`PurchasedLottos` 구매</td> </tr><tr> 
        <td rowspan="1"><b><em>PurchasedLottos</em></b></td>
            <td>✅`PurchasedLottos` 생성</td> </tr><tr>     
        <td rowspan="1">LottoService</td>
            <td>✅`PurchasedLottos` 발행</td> </tr><tr>
        <td rowspan="1">Lotto</td>
        <td>✅`Lotto` 오름차순 정렬</td> </tr><tr> 
    <td rowspan="3">리팩토링</td>
        <td rowspan="1">View</td>
            <td>✅`displayOutPut` 메서드 추가</td> 
                <td rowspan="3">refactor</td></tr><tr> 
        <td rowspan="1">ValidateCommand</td>
            <td>✅사용자 입력 재시도 로직 추가</td> </tr><tr> 
        <td rowspan="1">Lotto</td>
            <td>✅`LottoTest` 통과 하기 위한 검증 로직 추가</td> </tr><tr>
    <td rowspan="4">당첨 번호 입력</td>
        <td rowspan="1"><b><em>LottoCommand</em></b></td>
        <td>✅`Lotto` 당첨 번호 유효성 검증</td> 
                <td rowspan="4">feat/winning-lotto-input</td></tr><tr> 
        <td rowspan="1">View</td>
            <td>✅`WinningLottoUserInput`  당첨 번호 사용자 입력 처리 </td> </tr><tr> 
        <td rowspan="1">LottoCommand</td>
            <td>✅`WinningLottoUserInput` 당첨 번호 반환</td> </tr><tr>
        <td rowspan="1">LottoService</td>
            <td>✅`WinningLottoUserInput`를 `WinningLotto`로 변환</td> </tr><tr> 
    <td rowspan="4">보너스 번호 입력</td>
        <td rowspan="1"><b><em>BonusCommand</em></b></td>
            <td>✅`Bonus` 보너스 번호 유효성 검증</td> 
                <td rowspan="4">feat/lotto-bonus-input</td></tr><tr>         
        <td rowspan="2">View</td>
            <td>✅`Bonus` 보너스 번호 사용자 입력 처리 </td> </tr><tr> 
            <td>✅`Bonus` 반환</td> </tr><tr>
        <td rowspan="1">LottoService</td>
            <td>✅`WinningLotto`에 보너스 번호 추가</td> </tr><tr> 
     <td rowspan="4">로또 당첨 조회</td>
        <td rowspan="1">LottoService</td>
            <td>✅`WinningLotto`와 `PurchasedLottos` 매칭 여부</td> 
                <td rowspan="4">feat/match-winning-lotto</tr><tr> 
        <td rowspan="1">LottoService</td>
            <td>✅`MatchResults` 반환</td> </tr><tr> 
        <td rowspan="1"><b><em>MatchResult</em></b></td>
            <td>✅`MatchResult` 생성</td> </tr><tr> 
        <td rowspan="1"><b><em>MatchResults</em></b></td>
            <td>✅`MatchResult` 추가</td> </tr><tr> 
    <td rowspan="5">로또 당첨 통계 출력</td>
        <td rowspan="1"><b><em>ProfitRate</em></b></td>
            <td>✅`ProfitRate` 수익률 생성</td> 
                <td rowspan="5">feat/match-winning-lotto-output</tr><tr> 
        <td rowspan="1"><b><em>ProfitAmount</em></b></td>
            <td>✅`ProfitAmount` 수익 금액 생성</td> </tr><tr> 
        <td rowspan="1">AmountService</td>
            <td>✅`ProfitRate` 반환</td> </tr><tr> 
        <td rowspan="1"><b><em>LottoProfitCommand</em></b></td>
            <td>✅`MatchResult` & `ProfitRate`당첨 금액 및 수익률 출력 커맨드 생성</td> </tr><tr>
        <td rowspan="1">View</td>
            <td>✅`LottoProfitCommand`로 수익률 출력</td> </tr><tr>
    <td rowspan="1">출력 리팩토링</td>
        <td rowspan="1">OutputCommand</td>
            <td>✅출력 로직 개선</td> 
                <td rowspan="1">refactor-output</tr><tr> 
    <td rowspan="1">로또 컨트롤러</td>
            <td rowspan="1"><b><em>LottoController</em></b></td>
                <td>✅로직 조합</td> 
                    <td rowspan="1">dev/controller</tr><tr> 
    <td rowspan="1">의존성 주입</td>
        <td rowspan="1"><b><em>DependencyInjectionContainer</em></b></td>
            <td>✅컴포넌트 의존성 주입</td> 
                <td rowspan="1">dev/dependency</tr><tr> 
    <td rowspan="6">출력 포맷 리팩토링</td>
        <td rowspan="3">ValidateCommand</td>
            <td>✅개행문자 추가</td> 
                <td rowspan="6">refactor-output-message</tr><tr>
            <td>✅구매 금액 자료형 변경</td> </tr><tr>
            <td>✅숫자 포맷 가독성 향상</td> </tr><tr>
        <td rowspan="1">LottoConstant</td>
            <td>✅상수 병합</td> </tr><tr>
        <td rowspan="1">Command</td>
            <td>✅패키지 수정</td> </tr><tr>
            
</tr>
</table>