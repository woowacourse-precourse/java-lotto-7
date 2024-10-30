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
    <td>AmountService</td><td>`PurchaseAmount` & `WinningAmount` 비즈니스 로직 처리</td> </tr><tr> 
    <td>LottoService</td><td>`Lotto` & `Lottos` 비즈니스 로직 처리</td> 
</tr>
<tr> 
	<td rowspan="6">Model</td>
    <td>PurchaseAmount</td><td>로또 구입 금액</td></tr><tr>
    <td>WinningAmount</td><td>로또 당첨 금액</td></tr><tr>
    <td>Bonus</td><td>로또의 보너스 번호</td></tr><tr> 
    <td>WinningLotto</td><td>로또의 당첨 번호 & `Bonus`를 관리하는 일급 컬렉션</td></tr><tr>
	<td>Lotto</td><td>로또의 숫자를 관리하는 일급 컬렉션</td></tr><tr> 
    <td>PurchasedLottos</td><td>구매한 `Lotto`(들)을 관리하는 일급 컬렉션</td>
</tr> 
<tr> 
	<td rowspan="1">Observer</td>
    <td>LottoObserver</td><td>당첨 등수를 반환하는 옵저버</td></tr><tr>
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
    <td rowspan="8">DTO</td>
    <td>PurchaseLottoRequest</td> <td>로또 구입 금액 & 당첨/보너스 번호</td></tr><tr> 
    <td>PurchaseResponse</td> <td>발행한 로또 수량</td></tr><tr> 
    <td>LottoResponse</td> <td>발행한 로또 번호</td></tr><tr>
    <td>MatchResult</td> <td>`PurchaseLottos`의 등수</td></tr><tr>
    <td>MatchResults</td> <td>`MatchResult`의 일급 컬렉션</td></tr><tr>
    <td>Prize</td> <td>등수에 따른 당첨 금액</td></tr><tr>
    <td>PurchaseLottoResponse</td> <td>당첨 통계</td></tr><tr></tr><tr>
    </tr> 
<tr> <td>Exception</td> 
    <td>GlobalException</td><td>전역 에러 처리</td> 
</tr> 
</table>
</div>

#### 단계별 구현
GlobalException
- [ ] 전역 예외처리

InputException
- [ ] 사용자 입력 관련 예외처리

AmountException
- [ ] 금액 관련 예외처리

LottoException
- [ ] 로또 관련 예외처리

View
- [ ] 인터페이스 생성
- [ ] 입력 처리
- [ ] 출력 처리
<table> 
⬜✅
<tr> 
	<th align="center">기능</th> 
	<th align="center">컴포넌트</th> 
	<th align="center">구현</th> 
</tr>
<tr>
    <td rowspan="4">예외처리</td>
        <td rowspan="1"><b><em>GlobalException</em></b></td>
            <td>✅전역 예외처리</td> </tr><tr>
        <td rowspan="1"><b><em>InputException</em></b></td>
        <td>✅사용자 입력 관련 예외처리</td> </tr><tr> 
        <td rowspan="1"><b><em>AmountException</em></b></td>
        <td>⬜금액 관련 예외처리</td> </tr><tr> 
        <td rowspan="1"><b><em>LottoException</em></b></td>
        <td>⬜로또 관련 예외처리</td> </tr><tr> 
	<td rowspan="3">로또 구입 금액 사용자 입력</td>
        <td rowspan="1"><b><em>PurchaseAmountCommand</em></b></td>
        <td>⬜ `PurchaseAmount` 유효성 검증</td> </tr><tr> 
        <td rowspan="2"><b><em>View</em></b></td>
            <td>⬜ `PurchaseAmount` 사용자 입력 처리 </td> </tr><tr> 
            <td>⬜ `PurchaseAmount` 반환</td> </tr><tr>
    <td rowspan="6">로또 구매</td>
        <td rowspan="1"><b><em>Lotto</em></b></td>
            <td>⬜ 1장 가격 상수 </td> </tr><tr> 
        <td rowspan="1"><b><em>LottoService</em></b></td>
            <td>⬜ `Lotto` 1장 가격 반환</td> </tr><tr> 
        <td rowspan="1"><b><em>AmountService</em></b></td>
            <td>⬜ `PurchasedLottos` 구매</td> </tr><tr> 
        <td rowspan="1"><b><em>PurchasedLottos</em></b></td>
            <td>⬜ `PurchasedLottos` 생성</td> </tr><tr>     
        <td rowspan="1">LottoService</td>
            <td>⬜ `PurchasedLottos` 발행</td> </tr><tr>
        <td rowspan="1">Lotto</td>
        <td>⬜ `Lotto` 오름차순 정렬</td> </tr><tr> 
    <td rowspan="4">당첨 번호 입력</td>
        <td rowspan="1"><b><em>LottoCommand</em></b></td>
        <td>⬜ `Lotto` 당첨 번호 유효성 검증</td> </tr><tr> 
        <td rowspan="2"><b><em>View</em></b></td>
            <td>⬜ `Lotto`  당첨 번호 사용자 입력 처리 </td> </tr><tr> 
            <td>⬜ `Lotto` 당첨 번호 반환</td> </tr><tr>
        <td rowspan="1">LottoService</td>
            <td>⬜ `Lotto`를 `WinningLotto`로 변환</td> </tr><tr> 
    <td rowspan="4">보너스 번호 입력</td>
        <td rowspan="1"><b><em>BonusCommand</em></b></td>
            <td>⬜ `Bonus` 보너스 번호 유효성 검증</td> </tr><tr>         
        <td rowspan="2">View</td>
            <td>⬜ `Bonus` 보너스 번호 사용자 입력 처리 </td> </tr><tr> 
            <td>⬜ `Bonus` 반환</td> </tr><tr>
        <td rowspan="1">LottoService</td>
            <td>⬜ `WinningLotto`에 보너스 번호 추가</td> </tr><tr> 
     <td rowspan="4">로또 당첨 조회</td>
        <td rowspan="1">LottoService</td>
            <td>⬜ `WinningLotto`와 `PurchasedLottos` 매칭 여부</td> </tr><tr> 
        <td rowspan="1">LottoService</td>
            <td>⬜ `MatchResults` 반환</td> </tr><tr> 
        <td rowspan="1"><b><em>MatchResult</em></b></td>
            <td>⬜ `MatchResult` 생성</td> </tr><tr> 
        <td rowspan="1"><b><em>MatchResults</em></b></td>
            <td>⬜ `MatchResult` 추가</td> </tr><tr> 
    <td rowspan="5">로또 당첨 통계 출력</td>
        <td rowspan="1"><b><em>Prize</em></b></td>
            <td>⬜  `Prize` 생성</td> </tr><tr> 
        <td rowspan="1">LottoService</td>
            <td>⬜  `Prize` 반환</td> </tr><tr> 
        <td rowspan="1">AmountService</td>
            <td>⬜ `Prize`와 `MatchResult`를 `PurchaseLottoResponse`로 변환</td> </tr><tr> 
        <td rowspan="1">View</td>
            <td>⬜ `PurchaseLottoResponse`로 로또 일치 숫자 갯수 출력</td> </tr><tr>
        <td rowspan="1">View</td>
            <td>⬜ `PurchaseLottoResponse`로 수익률 출력</td> </tr><tr>
    <td rowspan="1">의존성 주입</td>
        <td rowspan="1"><b><em>DependencyInjectionContainer</em></b></td>
            <td>⬜ 컴포넌트 의존성 주입</td> </tr><tr>
</tr>
</table>