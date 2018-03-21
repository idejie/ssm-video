<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="assets/img/logo-fav.png">
    <title>浏览活动</title>
    <link rel="stylesheet" type="text/css" href="assets/lib/perfect-scrollbar/css/perfect-scrollbar.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="assets/lib/material-design-icons/css/material-design-iconic-font.min.css"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="assets/css/app.css" type="text/css"/>
</head>

<body>
<div class="be-wrapper be-fixed-sidebar">
    <nav class="navbar navbar-expand fixed-top be-top-header">
        <div class="container-fluid">
            <div class="be-navbar-header"><a href="#" class="navbar-brand"></a>
            </div>
            <div class="be-right-navbar">
                <ul class="nav navbar-nav float-right be-user-nav">
                    <li class="nav-item dropdown"><a href="#" data-toggle="dropdown" role="button" aria-expanded="false"
                                                     class="nav-link dropdown-toggle"><img src="assets/img/avatar.png"
                                                                                           alt="Avatar"><span
                            class="user-name">${stu.username}</span></a>
                        <div role="menu" class="dropdown-menu">
                            <div class="user-info">
                                <div class="user-name">${stu.username}</div>
                                <div class="user-position online">${stu.id}</div>
                            </div>
                            <a href="/stu/logout" class="dropdown-item"><span class="icon mdi mdi-power"></span>退出</a>
                        </div>
                    </li>
                </ul>
                <div class="page-title"><span>浏览活动</span></div>
            </div>
        </div>
    </nav>
    <div class="be-left-sidebar">
        <div class="left-sidebar-wrapper"><a href="#" class="left-sidebar-toggle">主菜单</a>
            <div class="left-sidebar-spacer">
                <div class="left-sidebar-scroll">
                    <div class="left-sidebar-content">
                        <ul class="sidebar-elements">
                            <li class="divider">Menu</li>
                            <li class="parent"><a href="#"><i class="icon mdi mdi-face"></i><span>个人设置</span></a>
                                <ul class="sub-menu">
                                    <li><a href="/stu/profile/${stu.id}">个人资料</a>
                                    </li>
                                    <li><a href="/stu/repass">修改密码</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="parent open"><a href="charts.html"><i class="icon mdi mdi-chart-donut"></i><span>活动相关</span></a>
                                <ul class="sub-menu">
                                    <li><a href="/activity">浏览活动</a>
                                    <li><a href="/order">订单查看</a>
                                    </li>
                                    </li>
                                </ul>
                            </li>
                            <li class="parent"><a href="#"><i class="icon mdi mdi-dot-circle"></i><span>请假相关</span></a>
                                <ul class="sub-menu">
                                    <li><a href="/leave">发起请假</a>
                                    </li>
                                    <li><a href="/left">查看过往</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="divider">上课相关</li>
                            <li class="parent"><a href="#"><i class="icon mdi mdi-inbox"></i><span>课程</span></a>
                                <ul class="sub-menu">
                                    <li><a href="/lessoned">已修课程</a>
                                    </li>
                                    <li><a href="/lessoning">未修课程</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="parent"><a href="#"><i class="icon mdi mdi-view-web"></i><span>课时</span></a>
                                <ul class="sub-menu">
                                    <li><a href="/chaptered">浏览已修课时</a>
                                    </li>
                                    <li><a href="/chaptering">浏览未修课时</a>
                                    </li>
                                    </li>
                                </ul>
                            </li>
                            <li class="parent"><a href="#"><i class="icon mdi mdi-pin"></i><span>讨论区</span></a>
                                <ul class="sub-menu">
                                    <li><a href="/topic">发起讨论</a>
                                    </li>
                                    <li><a href="/comment">参与讨论</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="parent"><a href="#"><i class="icon mdi mdi-8tracks"></i><span>辅导</span></a>
                                <ul class="sub-menu">
                                    <li><a href="/need-help">请求辅导</a>
                                    </li>
                                    <li><a href="/help-others">发起辅导</a>
                                    </li>
                                </ul>
                            </li>

                        </ul>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <div class="be-content">
        <div class="main-content container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="card card-table">
                        <div class="card-header">
                            <div class="title">浏览活动</div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-header card-header-divider">活动：${activity.title}<span
                                class="card-subtitle">${activity.id}</span></div>
                        <div class="card-body">
                            <p>活动内容：${activity.content}</p>
                            <p>收费标准：${activity.price}</p>
                            <a href="/add-act/${activity.id}" class="btn btn-space btn-primary">报名</a>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card">
                            <div class="card-header card-header-divider">活动：${activity.title}<span
                                    class="card-subtitle">${activity.id}</span></div>
                            <div class="card-body">
                                <p>活动内容：${activity.content}</p>
                                <p>收费标准：${activity.price}</p>
                                <a href="/add-act/${activity.id}" class="btn btn-space btn-primary">报名</a>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-header card-header-divider">活动：${activity.title}<span
                                class="card-subtitle">${activity.id}</span></div>
                        <div class="card-body">
                            <p>活动内容：${activity.content}</p>
                            <p>收费标准：${activity.price}</p>
                            <a href="/add-act/${activity.id}" class="btn btn-space btn-primary">报名</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/lib/jquery/jquery.min.js" type="text/javascript"></script>
<script src="assets/lib/perfect-scrollbar/js/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
<script src="assets/lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
<script src="assets/js/app.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        //initialize the javascript
        App.init();

    });
</script>
</body>

</html>