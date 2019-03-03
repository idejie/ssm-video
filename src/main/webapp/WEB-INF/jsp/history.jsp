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
                                                     class="nav-link dropdown-toggle"><img src="/assets/img/avatar.png"
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
                <div class="page-title"><span>历史记录</span></div>
            </div>
        </div>
    </nav>
    <div class="be-content">

        <div class="main-content container-fluid">


            <div class="row">
                <!--Responsive table-->
                <div class="col-sm-12">
                    <div class="card card-table">
                        <div class="card-header">已生成的视频
                            <div class="tools dropdown">

                            </div>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive noSwipe">
                                <table class="table table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th style="width:40%;">封面</th>
                                        <th style="width:5%;">视频ID</th>
                                        <th style="width:20%;">标题</th>
                                        <th style="width:30%;">描述</th>
                                        <th style="width:5%;"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="v" items="${videos}">
                                        <tr>

                                            <td class="cell-detail"><img src="/assets/${v.cover}" alt="Avatar"></td>
                                            <td class="cell-detail"><span>${v.v_id}</span></td>
                                            <td class="cell-detail"><span>${v.title}</span></td>
                                            <td class="cell-detail"><span>${v.descr}</span></td>
                                            <td class="text-right">
                                                <div class="btn-group btn-hspace">
                                                    <button type="button" data-toggle="dropdown"
                                                            class="btn btn-secondary dropdown-toggle">操作 <span
                                                            class="icon-dropdown mdi mdi-chevron-down"></span></button>
                                                    <div role="menu" class="dropdown-menu">
                                                        <a href="/del-video/${v.v_id}" class="dropdown-item">删除</a>
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
                <div class="col-sm-12">
                    <div class="card card-table">
                        <div class="card-header">正在制作的视频
                            <div class="tools dropdown">><a href="/add-video/${user.u_id}" class="icon mdi mdi-plus">制作新视频</a>
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive noSwipe">
                                <table class="table table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th style="width:40%;">封面</th>
                                        <th style="width:5%;">视频ID</th>
                                        <th style="width:20%;">标题</th>
                                        <th style="width:30%;">描述</th>
                                        <th style="width:5%;"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="v" items="${videos2}">
                                        <tr>

                                            <td class="cell-detail"><img src="/assets/${v.cover}" alt="Avatar"></td>
                                            <td class="cell-detail"><span>${v.v_id}</span></td>
                                            <td class="cell-detail"><span>${v.title}</span></td>
                                            <td class="cell-detail"><span>${v.descr}</span></td>
                                            <td class="text-right">
                                                <div class="btn-group btn-hspace">
                                                    <button type="button" data-toggle="dropdown"
                                                            class="btn btn-secondary dropdown-toggle">操作 <span
                                                            class="icon-dropdown mdi mdi-chevron-down"></span></button>
                                                    <div role="menu" class="dropdown-menu"><a href="/edit-video/${v.v_id}"
                                                                                              class="dropdown-item">编辑</a>
                                                        <div class="dropdown-divider"></div>
                                                        <a href="/del-video/${v.v_id}" class="dropdown-item">删除</a>
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