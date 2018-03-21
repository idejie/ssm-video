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
    <link rel="shortcut icon" href="/assets/img/logo-fav.png">
    <title>学生注册|在线课堂</title>
    <link rel="stylesheet" type="text/css" href="/assets/lib/perfect-scrollbar/css/perfect-scrollbar.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="/assets/lib/material-design-icons/css/material-design-iconic-font.min.css"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="/assets/css/app.css" type="text/css"/>
</head>
<body class="be-splash-screen">
<div class="be-wrapper be-login be-signup">
    <div class="be-content">
        <div class="main-content container-fluid">
            <div class="splash-container sign-up">
                <div class="card card-border-color card-border-color-primary">
                    <div class="card-header">在线课堂<span class="splash-description">请输入你的相关信息.</span></div>
                    <div class="card-body">
                        <form action="/stu/register" method="post"><span class="splash-title pb-4">学生注册</span>
                            <div class="form-group">
                                <input type="text" name="stu_id" id="stu_id" required="" placeholder="学号"
                                       autocomplete="off" class="form-control">
                            </div>
                            <div class="form-group">
                                <input type="text" name="stu_name" id="stu_name" required="" placeholder="姓名"
                                       autocomplete="off" class="form-control">
                            </div>
                            <div class="form-group">
                                <input type="password" name="passwd" id="passwd" required="" placeholder="密码"
                                       autocomplete="off" class="form-control">
                            </div>
                            <div class="form-group">
                                <input type="text" name="age" id="age" required="" placeholder="年龄" autocomplete="off"
                                       class="form-control">
                            </div>
                            <div class="form-group">
                                <input type="text" name="tele" id="tele" required="" placeholder="电话" autocomplete="off"
                                       class="form-control">
                            </div>
                            <div class="form-group">
                                <input type="text" name="qq" id="qq" required="" placeholder="QQ" autocomplete="off"
                                       class="form-control">
                            </div>
                            <div class="form-group">
                                <input type="email" name="email" required="" placeholder="E-mail" autocomplete="off"
                                       class="form-control">
                            </div>
                            <div class="form-group row signup-password">
                                <div class="col-6">
                                    <input id="college" name="college" type="text" required="" placeholder="学院"
                                           class="form-control">
                                </div>
                                <div class="col-6">
                                    <input id="subject" name="subject" required="" placeholder="专业"
                                           class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="grade" name="grade" required="" placeholder="班级" autocomplete="off"
                                       class="form-control">
                            </div>
                            <div class="form-group pt-2">
                                <button type="submit" class="btn btn-block btn-primary btn-xl">注册</button>
                            </div>

                            <div class="form-group pt-3 mb-3">
                                <label class="custom-control custom-checkbox">
                                    <input type="checkbox" checked="true" class="custom-control-input"><span
                                        class="custom-control-label">创建用户，表示您已同意本系统的 <a href="#">相关条款和协议</a>.</span>
                                </label>
                            </div>
                            <c:if test="${not empty error}">
                                <div role="alert" class="alert alert-danger alert-dismissible">
                                    <button type="button" data-dismiss="alert" aria-label="Close" class="close"><span
                                            aria-hidden="true" class="mdi mdi-close"></span></button>
                                    <div class="icon"><span class="mdi mdi-close-circle-o"></span></div>
                                    <div class="message"><strong>错误!</strong> ${error}</div>
                                </div>
                            </c:if>
                        </form>
                    </div>
                </div>
                <div class="splash-footer">Copyright Reserved &copy; 1900-2900 <a href="#">China University</a></div>
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