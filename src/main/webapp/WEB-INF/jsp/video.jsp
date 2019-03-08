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
    <title>个人中心-曲奇网</title>
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
                                                     class="nav-link dropdown-toggle"><img src="assets/img/avatar.png"
                                                                                           alt="Avatar"><span
                            class="user-name">Túpac Amaru</span></a>
                        <div role="menu" class="dropdown-menu">
                            <div class="user-info">
                                <div class="user-name">${user.username}</div>
                            </div>
                            <a href="/logout" class="dropdown-item"><span class="icon mdi mdi-power"></span>登出</a>
                        </div>
                    </li>
                </ul>
                <div class="page-title"><span>视频制作</span></div>
            </div>
        </div>
    </nav>
    <div class="be-content">

        <div class="main-content container-fluid">


            <div class="row">
                <!--Responsive table-->
                <div class="col-sm-12">
                    <div class="card card-table">
                        <div class="card-header">已添加的素材
                            <div class="tools dropdown">

                            </div>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive noSwipe">
                                <table class="table table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th style="width:10%;">r_id</th>
                                        <th style="width:20%;">图片</th>
                                        <th style="width:50%;">台词</th>
                                        <th style="width:10%;">style</th>

                                        <th style="width:10%;"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="r" items="${res}">
                                        <tr>
                                            <td class="cell-detail"><span>${r.r_id}</span></td>

                                            <td class="cell-detail"><img src="${r.pic_url}" alt="Avatar"
                                                                         style="width: 80px;height: 40px"></td>
                                            <td class="cell-detail"><span>${r.subtitle}</span></td>
                                            <td class="cell-detail"><span>${r.style}</span></td>

                                            <td class="text-right">
                                                <div class="btn-group btn-hspace">
                                                    <button type="button" data-toggle="dropdown"
                                                            class="btn btn-secondary dropdown-toggle">操作 <span
                                                            class="icon-dropdown mdi mdi-chevron-down"></span></button>
                                                    <div role="menu" class="dropdown-menu">
                                                        <a href="/del-res/${r_id}" class="dropdown-item">删除</a>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="card card-border-color card-border-color-primary">
                        <div class="card-header card-header-divider">添加一条素材


                            <c:choose>
                            <c:when test="${not empty chosen_pic}">
                            <form action="/v/${video.v_id}/add-res" method="get">
                                <div class="form-group row">
                                    <label class="col-12 col-sm-3 col-form-label text-sm-right">图片</label>
                                    <div class="col-12 col-sm-8 col-lg-6">
                                        <input name="chosen_pic" style="width: 0px;height: 0px;" value="${chosen_pic}">
                                        <span class="custom-control-label"><img src="${chosen_pic}"
                                                                                style="width: 80px;height: 40px"></span>
                                    </div>
                                </div>
                                </c:when>
                                <c:otherwise>
                                <div class="form-group row">
                                    <label class="col-12 col-sm-3 col-form-label text-sm-right">搜索图片</label>
                                    <div class="col-8 col-sm-8 col-lg-6 dropdown">
                                        <form action="/v/${video.v_id}/add-pic" method="get">
                                            <div class="form-group">
                                                <input id="keyword" type="text" placeholder="Keyword" autocomplete="off"
                                                       class="form-control" name="keyword">
                                            </div>
                                            <div class="form-group login-submit">
                                                <button data-dismiss="modal" type="submit"
                                                        class="btn btn-primary btn-xl">搜索
                                                </button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <form>
                                    </c:otherwise>
                                    </c:choose>


                                    <div class="form-group row">
                                        <label for="inputPassword3"
                                               class="col-12 col-sm-3 col-form-label text-sm-right">台词</label>
                                        <div class="col-12 col-sm-8 col-lg-6">
                                            <textarea id="inputPassword3" type="text" class="form-control"
                                                      name="subtitle"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="inputPlaceholder3"
                                               class="col-12 col-sm-3 col-form-label text-sm-right">开始时间</label>
                                        <div class="col-12 col-sm-8 col-lg-6">
                                            <input id="inputPlaceholder3" type="text" placeholder=""
                                                   class="form-control" name="start_time">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="inputDisabled3"
                                               class="col-12 col-sm-3 col-form-label text-sm-right">结束时间</label>
                                        <div class="col-12 col-sm-8 col-lg-6">
                                            <input id="inputDisabled3" type="text" placeholder="" class="form-control"
                                                   name="end_time">
                                        </div>
                                    </div>
                                    <button data-dismiss="modal" type="submit" class="btn btn-primary btn-xl">确定
                                    </button>
                                </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="card card-border-color card-border-color-primary">
                        <div class="card-header card-header-divider">添加背景音乐
                            <div class="card-body">
                                <form action="/v/${video.v_id}/add-music" method="post" enctype="multipart/form-data">
                                    <div class="form-group row">
                                        <label for="file-1" class="col-12 col-sm-3 col-form-label text-sm-right">Button
                                            File Input</label>
                                        <div class="col-12 col-sm-6">
                                            <input id="file-1" type="file" name="music"
                                                   data-multiple-caption="{count} files selected" multiple=""
                                                   class="inputfile">
                                            <label for="file-1" class="btn-secondary"> <i
                                                    class="mdi mdi-upload"></i><span>上传音乐</span></label>
                                        </div>
                                    </div>
                                    <button data-dismiss="modal" type="submit" class="btn btn-primary btn-xl">开始生成
                                    </button>
                                </form>
                            </div>
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