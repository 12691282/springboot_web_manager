<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <title>系统主页</title>

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
    <div id="wrapper">
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                                    <span class="block m-t-xs" style="font-size:20px;">
                                        <i class="fa fa-area-chart"></i>
                                        <strong class="font-bold">管理系统</strong>
                                    </span>
                                </span>
                            </a>
                        </div>
                        <div class="logo-element">
                        </div>
                    </li>
                    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                        <span class="ng-scope">系统菜单</span>
                    </li>
                    <li>
                        <!-- <a class="J_menuItem" href="userList">
                            <i class="fa fa-home"></i>
                            <span class="nav-label">用户列表</span>
                        </a> -->
                        <a class="J_menuItem" href="/dataInfoShare/list">
                            <i class="fa fa-home"></i>
                            <span class="nav-label">数据列表</span>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row J_mainContent" id="content-main">
                <iframe id="J_iframe" width="100%" height="100%" src="/dataInfoShare/list" frameborder="0" data-id="index_v1.html" seamless></iframe>
            </div>
        </div>
        <!--右侧部分结束-->
    </div>

    <!-- 全局js -->
    <script src="/js/jquery.min.js?v=2.1.4"></script>
    <script src="/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="/js/plus/metisMenu/jquery.metisMenu.js"></script>
    <script src="/js/plus/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="/js/plus/layer/layer.min.js"></script>

    <!-- 自定义js -->
    <script src="/js/hAdmin.js?v=4.1.0"></script>
  
  	<script type="text/javascript">
	$(document).ready(function(){
	    //菜单点击
	    $(".J_menuItem").on('click',function(){
	        var url = $(this).attr('href');
	        $("#J_iframe").attr('src',url);
	        return false;
	    });
	});
	</script>
</body>

</html>
