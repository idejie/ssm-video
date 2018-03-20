<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>六度空间</title>
    <link rel="stylesheet" type="text/css" href="https://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css">
    <link href="css/custom.css" rel="stylesheet">
</head>
<body ontouchstart>
<!-- Your Code -->
<div id="container" class="container">
    <div class="">
        <h1 class="title">六度空间</h1>
        <div class="weui-cells_title">
            <p>功能列表</p>
        </div>
        <ul>
            <li class onclick="javascript:window.location.href='invite_code'">
                <div class="weui-flex ">
                    <p  class="weui-flex_item">申请邀请码</p>
                    <img class="li-img" src="./icon/icon_invite_code.png" alt="">
                </div>
            </li>
            <li class onclick="javascript:window.location.href='join_group'">
                <div class="weui-flex ">
                    <p  class="weui-flex_item">申请入群</p>
                    <img class="li-img" src="./icon/icon_group.png" alt="">
                </div>
            </li>
            <li class onclick="javascript:window.location.href='profile'">
                <div class="weui-flex ">
                    <p  class="weui-flex_item">个人设置</p>
                    <img class="li-img" src="./icon/icon_profile.png" alt="">
                </div>
            </li>
            <li class onclick="javascript:window.location.href='find_user'">
                <div class="weui-flex ">
                    <p  class="weui-flex_item">搜索用户</p>
                    <img class="li-img" src="./icon/icon_find_user.png" alt="">
                </div>
            </li>
            <li class onclick="javascript:window.location.href='create_activity'">
                <div class="weui-flex ">
                    <p  class="weui-flex_item">发布活动</p>
                    <img class="li-img" src="./icon/icon_create_activity.png" alt="">
                </div>
            </li>
        </ul>
    </div>
    <div class="weui-footer">
        <p class="weui-footer__links">
            <a href="javascript:void(0);" class="weui-footer__link">六度空间</a>
            <a href="index.jsp" class="weui-footer__link">返回首页</a>
        </p>
        <p class="weui-footer__text">Copyright © Reserved </p>
    </div>
</div>
</body>
</html>