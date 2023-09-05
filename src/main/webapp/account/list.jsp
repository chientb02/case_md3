<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/31/2023
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%--<div .form></div>--%>
<html lang="en" class="">
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập- Đăng kí</title>
    <meta name="robots" content="noindex">
    <link rel="shortcut icon" type="image/x-icon" href="https://cpwebassets.codepen.io/assets/favicon/favicon-aec34940fbc1a6e787974dcd360f2c6b63348d4b1f4e06c77743096d55480f33.ico">
    <link rel="mask-icon" href="https://cpwebassets.codepen.io/assets/favicon/logo-pin-b4b4269c16397ad2f0f7a01bcdf513a1994f4c94b8af2f191c09eb0d601762b1.svg" color="#111">
    <link rel="canonical" href="https://codepen.io/comadaihiep92/pen/jOPGgxy?editors=1111">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
    <style id="INLINE_PEN_STYLESHEET_ID">
        @font-face {
            font-family: 'Ubuntu';
            font-style: normal;
            font-weight: 700;
            font-display: swap;
            src: url(https://fonts.gstatic.com/s/ubuntu/v20/4iCv6KVjbNBYlgoCxCvjsGyI.ttf) format('truetype');
        }
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Ubuntu', sans-serif;
            text-decoration: none;
        }
        .form {
            width: 720px;
            height: 500px;
            margin: 50px auto;
            padding: 45px 65px;
            background: linear-gradient(to right, #e37a95, #8dcb9a);
            border-radius: 40px;
        }
        .form__box {
            width: 100%;
            height: 100%;
            display: flex;
            justify-content: space-around;
            align-items: center;
            background: #fff;
            border-radius: 40px;
        }
        .form__left {
            width: 50%;
        }
        .form__padding {
            width: 210px;
            height: 210px;
            background: #f2f2f2;
            border-radius: 50%;
            margin: 0 auto;
            line-height: 210px;
            position: relative;
        }
        .form__image {
            max-width: 100%;
            width: 60%;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
        .form__right {
            line-height: 26px;
            width: 50%;
        }
        .form__padding-right {
            padding: 0 25px;
        }
        .form__title {
            font-size: 18px;
            font-weight: bold;
            text-align: center;
            margin-bottom: 30px;
        }
        .form__submit-btn {
            background: #1fcc44;
            cursor: pointer;
        }
        .form__submit-btn:hover {
            background: #ff3f70;
        }
        .form__email {
            position: relative;
        }
        input {
            display: block;
            width: 100%;
            margin-bottom: 25px;
            height: 35px;
            border-radius: 20px;
            border: none;
            background: #f2f2f2;
            padding: 10px;
            font-size: 14px;
            position: relative;
        }
        input:after {
            position: absolute;
            content: 'a***';
        }
        a {
            color: #71df88;
            position: relative;
        }
        a:hover {
            color: #ff3f70;
        }

    </style>
    <script src="https://cpwebassets.codepen.io/assets/common/stopExecutionOnTimeout-2c7831bb44f98c1391d6a4ffda0e1fd302503391ca806e7fcc7b9b87197aec26.js"></script>
    <script src="https://cpwebassets.codepen.io/assets/editor/iframe/iframeConsoleRunner-6bce046e7128ddf9391ccf7acbecbf7ce0cbd7b6defbeb2e217a867f51485d25.js"></script>
    <script src="https://cpwebassets.codepen.io/assets/editor/iframe/iframeRefreshCSS-44fe83e49b63affec96918c9af88c0d80b209a862cf87ac46bc933074b8c557d.js"></script>
    <script src="https://cpwebassets.codepen.io/assets/editor/iframe/iframeRuntimeErrors-4f205f2c14e769b448bcf477de2938c681660d5038bc464e3700256713ebe261.js"></script>
</head>
<body>
<div class="form">
    <div class="form__box">
        <div class="form__left">
            <div class="form__padding"><img class="form__image" src="https://i.pinimg.com/originals/8b/44/51/8b4451665d6b2139e29f29b51ffb1829.png"></div>
        </div>
        <div class="form__right">
            <div class="form__padding-right">
                <form action="/account?action=login" method="post">
                    <h1 class="form__title">Đăng nhập</h1>
                    <input name="email" class="form__email" type="email" placeholder="Email" required>
                    <input name="pass" class="form__password" type="password" placeholder="******" required>
                    <input class="form__submit-btn" type="submit" value="Đăng nhập">
                </form><span>Quên mật khẩu <a> / </a><a class="form__link" href="/account?action=update">Đổi mật khẩu</a></span>
                <p> <a class="form__link" href="/account?action=create">Đăng kí</a></p>
                <p style="color: red; font-style: inherit;font-size: smaller;" class="form__title">${messager}</p>
            </div>
        </div>
    </div>
</div>
</body></html>

<%--<div class="form__link" href="#">Username</div>--%>
