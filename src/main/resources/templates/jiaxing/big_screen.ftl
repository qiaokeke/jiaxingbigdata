<!DOCTYPE html>
<html lang="zn-cn">
	<head>
		<meta charset="utf-8" />
		<title>能耗大屏</title>
		<link rel="stylesheet" type="text/css" href="/static/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="/static/css/big_screen.css"/>
		<script type="text/javascript" src="/static/js/echarts/echarts.js"></script>
		<script type="text/javascript" src="/static/js/jquery.min.js"></script>
		<script type="text/javascript" src="/static/js/big_screen.js"></script>
	</head>
	<body>
  <div id="filter">
	  <div class="container-fluid" style="padding-top: 10px;">
	  	<div class="row">
	  	  <div class="col-xs-3 col-sm-3 col-md-3 text-center">
	  	    <span class="glyphicon glyphicon-time time"></span>
          <span class="now"></span>
	  	  </div>
	  	  <div class="col-xs-6 col-sm-6 col-md-6 text-center title-font">能耗监测数据平台</div>
	  	  <div class="col-xs-3 col-sm-3 col-md-3"></div>
	  	</div>
	  </div>
	  <div class="item-style pull-left">
  	  <div>
  	    <div class="item-font text-center">实时能耗</div>
    	  <div class="item-1">
    	    <table class="table table-condensed table-bg">
    	    	<tr class="text-center">
    	    		<td></td>
    	    		<td>公司名称</td>
    	    		<td>能耗(吨标准煤)</td>
    	    	</tr>
    	    	<tr class="text-center">
    	    		<td><span class="badge">1</span></td>
    	    		<td>9#厂房嘉兴赛捷弹簧制造有限公司</td>
    	    		<td>25</td>
    	    	</tr>
    	    	<tr class="text-center">
              <td><span class="badge">2</span></td>
              <td>8#厂房嘉兴普利派克包装有限公司</td>
              <td>21</td>
            </tr>
            <tr class="text-center">
              <td><span class="badge">3</span></td>
              <td>5#厂房嘉兴浩拓贸易有限公司</td>
              <td>18</td>
            </tr>
            <tr class="text-center">
              <td><span class="badge">4</span></td>
              <td>17#厂房上海鸿研物流技术有限公司</td>
              <td>8</td>
            </tr>
            <tr class="text-center">
              <td><span class="badge">5</span></td>
              <td>16#厂房嘉兴进隆塑业有限公司</td>
              <td>8</td>
            </tr>
    	    </table>
    	  </div>
  	  </div>
  	  <div>
  	    <div class="item-font text-center">能耗余额</div>
  	    <div id="item2"></div>
  	  </div>
	  </div>
	  <div class="pull-left center">
	     <div class="container-fluid">
	       <div class="row">
	         <div class="col-xs-4 col-sm-4 col-md-4 text-right center-top">当年能耗</div>
	         <div class="col-xs-8 col-sm-8 col-md-8" id="fontDiv"></div>
	       </div>
	     </div>
	     <div class="item3">
	       <div class="item-font text-center">能耗榜单</div>
	       <div id="center-bottom"></div>
	     </div>
	  </div>
    <div id="right" class="item-style pull-left">
      <div id="right-top"></div>
      <div id="right-bottom"></div>
    </div>

    </div>
	  <script type="text/javascript" src="/static/js/bootstrap.min.js"></script>
	</body>
</html>
