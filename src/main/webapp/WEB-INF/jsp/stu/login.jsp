<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="./assets/img/logo-fav.png">
    <link rel="stylesheet" type="text/css" href="/assets/lib/perfect-scrollbar/css/perfect-scrollbar.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="/assets/lib/material-design-icons/css/material-design-iconic-font.min.css"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="/assets/css/app.css" type="text/css"/>
    <title>学生登录|在线课堂系统</title>
</head>
<body class="be-splash-screen">
<div class="be-wrapper be-login">
    <div class="be-content">
        <div class="main-content container-fluid">
            <div class="splash-container">
                <div class="card card-border-color card-border-color-primary">
                    <div class="card-header">学生登录<span class="splash-description">请输入你相关信息</span></div>
                    <div class="card-body">
                        <form action="/stu/login" method="post">
                            <div class="login-form">
                                <div class="form-group">
                                    <input id="stu_id" name="stu_id" type="text" placeholder="学号" autocomplete="off"
                                           class="form-control">
                                </div>
                                <div class="form-group">
                                    <input id="passwd" name="passwd" type="password" placeholder="密码"
                                           class="form-control">
                                </div>
                                <div class="form-group row login-tools">
                                    <div class="col-6 login-remember">
                                        <label class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input"><span
                                                class="custom-control-label">记住我？</span>
                                        </label>
                                    </div>
                                </div>
                                <c:if test="${not empty error}">
                                    <div role="alert" class="alert alert-danger alert-dismissible">
                                        <button type="button" data-dismiss="alert" aria-label="Close" class="close">
                                            <span aria-hidden="true" class="mdi mdi-close"></span></button>
                                        <div class="icon"><span class="mdi mdi-close-circle-o"></span></div>
                                        <div class="message"><strong>错误!</strong> ${error}</div>
                                    </div>
                                </c:if>
                                <div class="form-group row login-submit">
                                    <div class="col-6">
                                        <a data-dismiss="modal" href="/stu/register"
                                           class="btn btn-secondary btn-xl">注册</a>
                                    </div>
                                    <div class="col-6">
                                        <button data-dismiss="modal" type="submit" class="btn btn-primary btn-xl">登录
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/assets/lib/jquery/jquery.min.js" type="text/javascript"></script>
<script src="/assets/lib/perfect-scrollbar/js/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
<script src="/assets/lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
<script src="/assets/js/app.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        //initialize the javascript
        App.init();
    });

</script>
</body>
</html>