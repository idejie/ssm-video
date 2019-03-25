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
    <title>视频下载-曲奇网</title>
</head>
<body>
<div class="be-wrapper">
    <nav class="navbar navbar-expand fixed-top be-top-header">
        <div class="container-fluid">
            <div class="be-navbar-header"><a href="/" class="navbar-brand"></a>
            </div>
            <div class="be-right-navbar">
                <ul class="nav navbar-nav float-right be-user-nav">
                    <li class="nav-item dropdown"><a href="#" data-toggle="dropdown" role="button" aria-expanded="false"
                                                     class="nav-link dropdown-toggle"><img src="/assets/img/avatar.png"
                                                                                           alt="Avatar"><span
                            class="user-name">${user.username}</span></a>
                        <div role="menu" class="dropdown-menu">
                            <div class="user-info">
                                <div class="user-name">${user.username}</div>
                            </div>
                            <a href="/logout" class="dropdown-item"><span class="icon mdi mdi-power"></span>登出</a>
                        </div>
                    </li>
                </ul>
                <div class="page-title"><span>视频下载</span></div>
            </div>
        </div>
    </nav>
    <div class="be-content">

        <div class="main-content container-fluid">

            <div class="row">
                <div class="col-md-12">
                    <div class="card card-border-color card-border-color-primary">
                        <div class="card-header card-header-divider">下载视频<span class="card-subtitle">您可以选择视频类型和清晰度</span></div>
                        <div class="card-body">
                            <form action="/download/${video.v_id}" style="border-radius: 0px;" method="post">
                                <div class="form-group row pt-1">
                                    <label class="col-12 col-sm-3 col-form-label text-sm-right">视频央视</label>
                                    <div class="col-12 col-sm-8 col-lg-6 form-check mt-2">
                                        <label class="custom-control custom-radio custom-control-inline">
                                            <input type="radio" name="style" checked="" class="custom-control-input" value="1"><span class="custom-control-label custom-control-color">手机版</span>
                                        </label>
                                        <label class="custom-control custom-radio custom-control-inline">
                                            <input type="radio" name="style" class="custom-control-input" value="2"><span class="custom-control-label custom-control-color"> 电脑版</span>
                                        </label>
                                    </div>
                                </div>

                                <div class="form-group row pt-1 pb-1">
                                    <label class="col-12 col-sm-3 col-form-label text-sm-right">清晰度</label>
                                    <div class="col-12 col-sm-8 col-lg-6 form-check mt-2">
                                        <label class="custom-control custom-radio custom-control-inline">
                                            <input type="radio" name="qxd" checked="" class="custom-control-input" value="1"><span class="custom-control-label">超清</span>
                                        </label>
                                        <label class="custom-control custom-radio custom-control-inline">
                                            <input type="radio" name="qxd" class="custom-control-input" value="2"><span class="custom-control-label">高清</span>
                                        </label>
                                        <label class="custom-control custom-radio custom-control-inline">
                                            <input type="radio" name="qxd" class="custom-control-input" value="3"><span class="custom-control-label">标清</span>
                                        </label>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <button data-dismiss="modal" type="submit" class="btn btn-primary btn-xl">下载
                                    </button>
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