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
    <title>发起请假</title>
    <link rel="stylesheet" type="text/css" href="assets/lib/perfect-scrollbar/css/perfect-scrollbar.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="assets/lib/material-design-icons/css/material-design-iconic-font.min.css"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="assets/css/app.css" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="assets/lib/datetimepicker/css/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet" type="text/css" href="assets/lib/select2/css/select2.min.css"/>
    <link rel="stylesheet" type="text/css" href="assets/lib/bootstrap-slider/css/bootstrap-slider.min.css"/>
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
                <div class="page-title"><span>发起请假</span></div>
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
                            <li class="parent"><a href="charts.html"><i
                                    class="icon mdi mdi-chart-donut"></i><span>活动相关</span></a>
                                <ul class="sub-menu">
                                    <li><a href="/activity">浏览活动</a>
                                    <li><a href="/order">订单查看</a>
                                    </li>
                                    </li>
                                </ul>
                            </li>
                            <li class="parent open"><a href="#"><i class="icon mdi mdi-dot-circle"></i><span>请假相关</span></a>
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
                            <div class="title">发起请假</div>
                        </div>
                    </div>
                    <div class="card">
                        <form action="#" method="get">
                            <div class="form-group row">
                                <label class="col-12 col-sm-3 col-form-label text-sm-right">起始时间</label>
                                <div class="col-12 col-sm-7 col-md-5 col-lg-4 col-xl-3">
                                    <div data-start-view="0" data-date="1979-09-16T05:25:07Z"
                                         data-date-format="yyyy-mm-dd - HH:ii" data-link-field="dtp_input1"
                                         class="input-group date datetimepicker">
                                        <input size="16" type="text" name="start" value="" class="form-control">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary"><i class="icon-th mdi mdi-calendar"></i>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-12 col-sm-3 col-form-label text-sm-right">终止时间</label>
                                <div class="col-12 col-sm-7 col-md-5 col-lg-4 col-xl-3">
                                    <div data-start-view="0" data-date="1979-09-16T05:25:07Z"
                                         data-date-format="yyyy-mm-dd - HH:ii" data-link-field="dtp_input1"
                                         class="input-group date datetimepicker">
                                        <input size="16" type="text" value="" name="end" class="form-control">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary"><i class="icon-th mdi mdi-calendar"></i>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-12 col-sm-3 col-form-label text-sm-right">请假事由</label>
                                <div class="col-12 col-sm-7 col-md-5 col-lg-4 col-xl-3">

                                    <input type="text" value="" name="reason" class="form-control">

                                </div>
                            </div>
                            <div class="col-sm-6">
                                <p class="text-center">
                                    <button type="submit" class="btn btn-space btn-primary btn-lg">提交</button>
                                </p>
                            </div>

                        </form>
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
<script src="assets/lib/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
<script src="assets/lib/jquery.nestable/jquery.nestable.js" type="text/javascript"></script>
<script src="assets/lib/moment.js/min/moment.min.js" type="text/javascript"></script>
<script src="assets/lib/datetimepicker/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
<script src="assets/lib/select2/js/select2.min.js" type="text/javascript"></script>
<script src="assets/lib/select2/js/select2.full.min.js" type="text/javascript"></script>
<script src="assets/lib/bootstrap-slider/bootstrap-slider.min.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        //initialize the javascript
        App.init();
        App.formElements();
    });
</script>
</body>

</html>