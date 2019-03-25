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
    <title>曲奇网</title>
</head>
<body>
 <div class="be-wrapper">
      <nav class="navbar navbar-expand fixed-top be-top-header">
        <div class="container-fluid">
          <div class="be-navbar-header"><a class="navbar-brand"></a>
          </div>
        </div>
      </nav>
      <div class="be-content">
        <div class="main-content container-fluid">
          <h1 class="display-heading text-center">曲奇</h1>
          <p class="display-description text-center">在线视频生成系统</p>
          <div class="row pricing-tables">
            <div class="col-lg-3" style="margin: 0 auto;">
              <div class="pricing-table pricing-table-warning">
                <div class="pricing-table-image">
                  <svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="85" height="70" viewbox="0 35 430 360" xmlns:xlink="http://www.w3.org/1999/xlink" enable-background="new 0 35 430 360">
                    <g>
                      <path d="m371.967,36.248h-322.454c-27.302,0-49.513,22.211-49.513,49.513v247.571c0,15.816 12.244,28.817 27.749,30.046v14.353c0,4.142 3.357,7.5 7.5,7.5h47.997c4.143,0 7.5-3.358 7.5-7.5v-14.249h239.987v14.249c0,4.142 3.357,7.5 7.5,7.5h47.998c4.143,0 7.5-3.358 7.5-7.5v-14.353c15.505-1.229 27.748-14.23 27.748-30.046v-247.571c0-27.302-22.21-49.513-49.512-49.513zm-296.221,333.983h-32.997v-6.749h32.997v6.749zm302.985,0h-32.998v-6.749h32.998v6.749zm27.748-36.899c0,8.354-6.796,15.15-15.149,15.15h-361.18c-8.354,0-15.15-6.796-15.15-15.15v-247.571c0-19.03 15.482-34.513 34.513-34.513h322.454c19.03,0 34.513,15.482 34.513,34.513v247.571z"></path>
                      <path d="m343.395,71.376h-265.309c-19.075,0-34.594,15.519-34.594,34.594v146.542c0,19.075 15.519,34.594 34.594,34.594h32.272c13.626,0 26.023-8.038 31.583-20.478l6.725-15.048c3.15-7.046 10.172-11.599 17.89-11.599h88.369c7.718,0 14.739,4.553 17.888,11.599l6.727,15.048c5.561,12.439 17.958,20.477 31.583,20.477h32.272c19.075,0 34.594-15.519 34.594-34.594v-146.541c-0.001-19.075-15.519-34.594-34.594-34.594zm-284.903,100.365v-18.455h304.496v18.455h-304.496zm304.496,15v18.455h-304.496v-18.455h304.496zm-304.496-48.455v-18.455h304.496v18.455h-304.496zm19.594-51.91h265.309c10.419,0 18.941,8.182 19.536,18.455h-304.381c0.595-10.273 9.117-18.455 19.536-18.455zm32.272,185.73h-32.272c-10.42,0-18.942-8.183-19.536-18.457h72.762l-3.065,6.859c-3.149,7.046-10.171,11.598-17.889,11.598zm144.567-47.124h-88.369c-10.939,0-21.076,5.188-27.53,13.667h-80.534v-18.453h304.496v18.453h-80.533c-6.453-8.479-16.592-13.667-27.53-13.667zm88.47,47.124h-32.272c-7.718,0-14.739-4.553-17.889-11.599l-3.065-6.858h72.763c-0.595,10.275-9.117,18.457-19.537,18.457z"></path>
                      <path d="m90.595,293.624c-12.437,0-22.555,10.118-22.555,22.555 0,12.437 10.118,22.555 22.555,22.555s22.555-10.118 22.555-22.555c-0.001-12.437-10.119-22.555-22.555-22.555zm0,30.11c-4.166,0-7.555-3.389-7.555-7.555 0-4.166 3.389-7.555 7.555-7.555s7.555,3.389 7.555,7.555c-0.001,4.166-3.389,7.555-7.555,7.555z"></path>
                      <path d="m330.886,293.624c-12.438,0-22.556,10.118-22.556,22.555 0,12.437 10.118,22.555 22.556,22.555 12.437,0 22.555-10.118 22.555-22.555-0.001-12.437-10.119-22.555-22.555-22.555zm0,30.11c-4.166,0-7.556-3.389-7.556-7.555 0-4.166 3.39-7.555 7.556-7.555s7.555,3.389 7.555,7.555c-0.001,4.166-3.389,7.555-7.555,7.555z"></path>
                      <path d="m259.995,295.985h-98.51c-4.143,0-7.5,3.358-7.5,7.5s3.357,7.5 7.5,7.5h98.51c4.143,0 7.5-3.358 7.5-7.5s-3.357-7.5-7.5-7.5z"></path>
                      <path d="m242.084,289.236c4.143,0 7.5-3.358 7.5-7.5s-3.357-7.5-7.5-7.5h-62.688c-4.143,0-7.5,3.358-7.5,7.5s3.357,7.5 7.5,7.5h62.688z"></path>
                      <path d="m242.084,317.734h-62.688c-4.143,0-7.5,3.358-7.5,7.5s3.357,7.5 7.5,7.5h62.688c4.143,0 7.5-3.358 7.5-7.5s-3.357-7.5-7.5-7.5z"></path>
                    </g>
                  </svg>
                </div>
                <div class="card-divider card-divider-xl"></div>
                <a href="/start" class="btn btn-warning">开始使用</a>
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