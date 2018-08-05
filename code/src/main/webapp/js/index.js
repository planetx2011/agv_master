
$('#btnLogin').click(function(event) {
    $.ajax({
        url: 'login/checkout',
        type: 'POST',
        dataType: 'json',
        async: false,
        data: {
        	userName: $('#userName').val(),
        	password: $('#password').val()
        },
        success: function (data) {
            //请求成功后执行的代码
            console.log('login success');
            if (null === data || data.length === 0) {
                console.log('无有效任务记录！');
                return;
            }
            
            //if ('true' === data) {
            	window.location.href="./agvmonitor.html";
            //}            
        },
        error: function (e) {
            //失败后执行的代码
            console.log('login failed: ' + e);
        }
    });
})


