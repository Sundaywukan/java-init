//var baseUrl="http://192.168.1.117:8080/xmiaodai";
//var baseUrl="http://116.62.66.135/xmiaodai";
//var baseUrl="http://localhost:8080/xmiaodai";
var baseUrl="http://localhost:8080/CloudShare";


$(function() {
	//加载heard和导航栏
	$(".main-header").html("<a href='/CloudShare/admin/pages/user/list.html' class='logo'><span class='logo-mini'><b>云</b></span>"+
			"<span class='logo-lg'>云分享</span></a>"+
			"<nav class='navbar navbar-static-top'><a href='#' class='sidebar-toggle' data-toggle='push-menu' role='button'>"+
			"<span class='sr-only'>Toggle navigation</span>"+
			"<span class='icon-bar'></span> <span class='icon-bar'></span> <span class='icon-bar'></span></a></nav>");
	$(".main-sidebar").html("<section class='sidebar'>"+
				"<ul class='sidebar-menu' data-widget='tree'>"+
					"<li class='header'>主导航</li>"+
					"<li id='user'><a href='/CloudShare/admin/pages/user/list.html'> <i class='fa  fa-user'></i> <span>用户管理</span>"+
					"</a></li>"+
					"<li id='brand'><a href='/CloudShare/admin/pages/brand/list.html'> <i class='fa  fa-bookmark'></i> <span>品牌商申请</span>"+
					"</a></li>"+
					"<li id='friendcircle'><a href='/CloudShare/admin/pages/friendcircle/list.html'> <i class='fa fa-opera'></i> <span>朋友圈</span>"+
					"</a></li>"+
					"<li id='article'><a href='/CloudShare/admin/pages/article/list.html'> <i class='fa fa-book'></i> <span>文章</span>"+
					"</a></li>"+
					"<li id='setting'><a href='/CloudShare/admin/pages/setting/updatepassword.html'> <i class='fa  fa-bars'></i> <span>设置</span>"+
					"</a></li>"+
					"</ul></section>");
	
});


var lang = {
		"sProcessing": "处理中...",
		"sLengthMenu": "每页 _MENU_ 项",
		"sZeroRecords": "没有匹配结果",
		"sInfo": "当前显示第 _START_ 至 _END_ 项，共 _TOTAL_ 项。",
		"sInfoEmpty": "当前显示第 0 至 0 项，共 0 项",
		"sInfoFiltered": "(由 _MAX_ 项结果过滤)",
		"sInfoPostFix": "",
		"sSearch": "搜索:",
		"sUrl": "",
		"sEmptyTable": "表中数据为空",
		"sLoadingRecords": "载入中...",
		"sInfoThousands": ",",
	"oPaginate": {
		"sFirst": "首页",
		"sPrevious": "上页",
		"sNext": "下页",
		"sLast": "末页",
		"sJump": "跳转"
	},
	"oAria": {
		"sSortAscending": ": 以升序排列此列",
		"sSortDescending": ": 以降序排列此列"
	}
};
var params = '';
var highlightCount = 0;

Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

function getQueryParam(e) {
    var t = new RegExp("(^|&)" + e + "=([^&]*)(&|$)");
    var a = window.location.search.substr(1).match(t);
    if (a != null) return a[2];
    return ""
}

function highlightSiderItem(selector) {
	highlightCount++;
	if($(selector).size() > 0) {
		$(selector).addClass("active");
	} else {
		if(highlightCount<10) {
			setTimeout(function(){highlightSiderItem(selector);}, 500);
		}
	}
}

function myHide(id2,type){
      var div = document.getElementById(id2);
      div.parentNode.removeChild(div);
    if(type==1){
      history.back();
    }
};
function alertHide(id,type){
  var id1 = id;
  setTimeout(function(){
    myHide(id1,type);
  },2000);
};
function myAlert(text,type){
   var content = document.getElementsByClassName('content-wrapper');
    var span1 = document.createElement('span');
    var  text=  document.createTextNode(text);
    span1.appendChild(text);
    var div1 = document.createElement('div');
    div1.setAttribute('id','myAlter');
    // div1.style.backgroundColor = color||'rgba(243,156,18,0.8)';
    // div1.style.position = 'fixed';
    // div1.style.top = '5.0rem';
    // div1.style.zIndex = '5';
    // div1.style.left = '20%';
    // div1.style.right = '20%';
    // div1.style.lineHeight = '2.4rem';
    // div1.style.textAlign = 'center';
    // div1.style.borderRadius = '1.2rem';
    // div1.style.color = 'white';
    div1.setAttribute('class','alert-tips');
    if(type){
      div1.setAttribute('class','alert-tips '+type);
    }
    div1.appendChild(span1);
    content[0].appendChild(div1);
    var id=div1.getAttribute('id');
    alertHide(id,type);
};

function isInteger(obj) {
	if(obj=='' || obj==undefined || obj==null) {
		return false
	}
	return obj%1 === 0;
}

function isNumber(n) {  
    return !isNaN(parseFloat(n)) && isFinite(n);
} 

function get_pics() {
	var html="";
	$("#pics").each(function () {  
		$(this).find('li').each(function() {
			if($(this).html().indexOf("button")!=-1){
				html=html+"<li style='border:none'>"+$(this).html()+"</li>";
			}else{
			    html=html+"<li>"+$(this).html()+"</li>";
			}
		});  
	});
	return html;
}


