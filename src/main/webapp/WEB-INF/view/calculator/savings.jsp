<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>적금 계산기</title>
    <link rel="stylesheet" href="/css/styles.css">
    <script src="/js/savingsCalculator.js"></script>
</head>
<body>
<div id="container">
    <header class = "header">
        <jsp:include page="../../layout/header.jsp" />
    </header>
    <div class="blank"></div>
    <script src="/js/script.js"></script>
    <main>
        <h2>적금 계산기</h2>
        <p>아래의 정보를 입력하면 필요한 월 적립액을 계산해 드립니다. 필요한 정보를 모두 입력한 후 '계산하기' 버튼을 클릭해주세요.</p>

        <section id="savingsCalculator">
            <h2>적금 계산기</h2>

            <label for="targetAmount">최종 목표금액:</label>
            <input type="number" id="targetAmount">

            <label for="savingsPeriod">적립 기간(개월):</label>
            <input type="number" id="savingsPeriod">

            <label for="interestRate">연 이율(%):</label>
            <input type="number" id="interestRate">

            <label for="interestMethod">금리 방식:</label>
            <select id="interestMethod">
                <option value="simpleInterest">단리</option>
                <option value="compoundInterest">복리</option>
            </select>

            <input type="button" value="계산하기" onclick="calculateSavings()">

            <div id="result"></div>
        </section>
    </main>


    <footer class="footer">
        <jsp:include page="../../layout/footer.jsp" />
    </footer>
</div>

</body>
</html>