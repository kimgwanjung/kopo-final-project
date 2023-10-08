<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="details__left">
    <ul class="menu">
        <li class="menu__item active"> <!-- active 클래스를 추가 -->
        <a href="" class="menu__link">
            <div class="menu__icon">
                <img src="/img/bankmenu.png" width="26px" height="26px">
            </div>
            대출관리
        </a>
    </li>
        <li class="menu__item">
            <a href="" class="menu__link">
                <div class="menu__icon">
                    <img src="/img/bankmenu.png" width=26px" height="26px">
                </div>
                심사내역
            </a>
        </li>
    </ul>
    <div class="consumer">
        <button class="consumer__button">x</button>
        <div class="consumer__text">${loggedInUser.name} 대리님</div>
        <div class="consumer__cheering">화이팅 한 번 외칠까요~?</div>
        <div class="consumer__image"> <img src="/img/김관중.jpg" width="163px" height="190px"> </div>
        <div class="consumer__notice">다음 월급일까지 D-6일</div>
    </div>
</div>