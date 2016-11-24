<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html class="sessions_login">

<head lang="en">
    <meta charset="UTF-8">
    <title>登录</title>
    <meta name="keywords"
          content="照片,摄影师,摄影作品集,在线摄影作品集,照片精选,网络摄影作品集,在线照片展廊,分享图片,专业摄影,社会摄影,上传照片,分享照片,出色的摄影作品集,摄影社区,最新摄影作品,快速创建作品集,模特和摄影师,商业摄影,建筑摄影,专业作品集管理">
    <meta name="author" content="">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimal-ui" name="viewport" />

    <link href="http://500px.me/style/home/navbar.css" rel="stylesheet">
    <link href="http://500px.me/style/home/main.css" rel="stylesheet">
    <link id="loginCss" href="http://500px.me/style/setting/login.css" rel="stylesheet">
    <link href="http://500px.me/style/index.css" rel="stylesheet">

    <script src="http://500px.me/js/jquery-1.11.2.min.js"></script>
    <!-- HTML5 Support for IE -->
    <!--[if lt IE 9]>
    <script src="http://500px.me/js/html5shim.js"></script>
    <![endif]-->
    <link rel="shortcut icon" href="http://500px.me/images/favicon.ico" />


<script>
        function handleClass(){
            var winWidth = $(window).width();
            if(winWidth < 600){
                $(document.body).addClass("smartphone");
            }else {
                $(document.body).addClass("smartphone");
            }
        }
        $(function(){
            handleClass();
            $(window).resize(handleClass);
        })
    </script>

 
</head>
<body ng-app="SJ-APP" id="user_sets" class="v3">
<input type="hidden" id="message" name="message" value="${message}">
<div class="main-nav">
    <div class="wrapper clearfix">
        <script type="text/javascript" src="http://500px.me/js/user/login.js"></script>

    </div>
</div>
<div id="login">

    <div class="login_wrap">
        <div class="login_form_wrap"><div class="signup_login_form show_login">
            <div class="top">
                <div class="top_wrap">

                    <div class="header_wrap clearfix">
                        <h1 class="login_only">
       						登录摄影师社区后台
                    	</h1>
                    </div>
                    
                    <div class="fields clearfix">
                        <div class="login-form">
                            <div class="show_on_email">
                                <form id="form" method="post" action="<%=basePath%>login" class="signup_with_email">
                                    <ul>
                                        <li>
                                            <select name="systemIdS" id="systemIdS" >
                                                <option value="test_500px">500px-测试</option>
                                                <option value="online_500px">500px-线上</option>
                                            </select>
                                        </li>
                                        <li>
                                            <input id="userName"  type="text"  placeholder="手机号码或电子邮件" onblur="checkUserName()" name="userName" class="field email">
                                        </li>
                                        <li>
                                            <input id="password" type="password" placeholder="密码"   name="password" class="field password">
                                            <br><span class="note" id="userNameOrPasswordErr" name="userNameOrPasswordErr"></span>
                                        </li>
                                        <li>
                                            <input type="button" id="subButton" value="登录" class="button submit large login_only" onclick="submitForm()">
                                        </li>
                                        <input id="systemId" type="hidden"  name="systemId">
                                    </ul>
                                </form>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <div class="loading"></div>
        </div></div>
    </div>


</div>

<!-- JS Begin-->
<script type="text/javascript">

    function checkUserName(){
        var username = $("#userName").val().trim();//用户名
        username = username.replace(/[ ]/g,'');
        $("#userName").val(username);
        var noteStr = '';//用户名的提示信息
        if(username==null || username == ''){
            noteStr = '请输入手机号码或电子邮件';
            $("#userNameOrPasswordErr").html(noteStr);
            return false;
        }
        //1.校验手机号//邮箱校验
        if(!(/^1[0-9][0-9]\d{8}$/.test(username)) && !(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,5})+$/.test(username))){
            noteStr = "请输入手机号码或电子邮件";
            $("#userNameOrPasswordErr").html(noteStr);
            return false;
        }
        $("#userNameOrPasswordErr").html('');
        return true ;
    }

    function submitForm(){
        var b = checkUserName();
        var password = $("#password").val();//用户名
        if(checkUserName()){
            if(password==null || password == ''){
                $("#userNameOrPasswordErr").html('密码不能为空');
                return ;
            }
            var options=$("#systemIdS option:selected").val();
            $("#systemId").val(options);
            $("#form").submit();
        }
    }

    //前台报错信息提示
    var message = $("#message").val();
    if(message!=null && message!=''){
        $("#userNameOrPasswordErr").html(message);
    }
</script>
<!-- JS End-->
</body>
</html>


