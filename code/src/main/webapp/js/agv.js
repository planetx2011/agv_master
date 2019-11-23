$('#myTab a').click(function (e) {
    e.preventDefault();
    $(this).tab('show');
})


function displayMap() {
    console.log('click map');
}

function displayTaskInfo(parm) {
    $.ajax({
        url: '/agv/record/taskInfos',
        type: 'GET',
        dataType: 'json',
        async: false,
        data: {
            carId: parm === undefined ? '' : parm.carId,
            taskType: parm === undefined ? '' : parm.taskType,
            taskStartTm: parm === undefined ? '' : parm.taskStartTm,
            taskEndTm: parm === undefined ? '' : parm.taskEndTm
        },
        success: function (data) {
            //请求成功后执行的代码
            console.log('get task info success.');
            if (null === data || data.length === 0) {
                console.log('无有效任务记录！');
                return;
            }
            let agvIdHtml = "<option value='0'>全部</option>";
            let tableHtml = "";
            data.forEach(element => {
                agvIdHtml += '<option>' + element.agv_id + '</option>';
                tableHtml += '<tr><td>' + '1' + '</td><td>' + element.agv_id + '</td><td>' + element.taskName + '</td><td>' + element.taskDescript + '</td><td>' + element.endTime + '</td></tr>'
            });
            $('#task table tbody').html(tableHtml);
            $('#taskCarIds').html(agvIdHtml);
        },
        error: function (e) {
            //失败后执行的代码
            console.log('get task info failed.' + e);
        }
    });
}

function displayAgvInfo(parm) {
    $.ajax({
        url: '/agv/state/getAgvPosition',
        type: 'GET',
        dataType: 'json',
        async: false,
        data:{},
        success: function (data) {
            //请求成功后执行的代码
            console.log('get task info success.');
            let tableHtml = "";
            data.forEach(element => {
                tableHtml += '<tr><td>' + element.id + '</td><td>' + element.coordinate.x + '</td><td>' + element.coordinate.y + '</td></tr>'
            });
            
            $('#map table tbody').html(tableHtml);
        },
        error: function (e) {
            //失败后执行的代码
            console.log('get task info failed.' + e);
        }
    });
}

function displayErrInfo(parm) {
    $.ajax({
        url: '/agv/record/abnormalInfos',
        type: 'GET',
        dataType: 'json',
        async: false,
        data: {
            carId: parm === undefined ? '' : parm.carId,
            errType: parm === undefined ? '' : parm.errType,
            rfid: parm === undefined ? '' : parm.rfid,
            abStartTm: parm === undefined ? '' : parm.abStartTm,
            abEndTm: parm === undefined ? '' : parm.abEndTm
        },
        success: function (data) {
            //请求成功后执行的代码
            console.log('get abnormal info success.');
            if (null === data || data.length === 0) {
                console.log('无有效异常类型！');
                return;
            }
            let agvIdHtml = "<option value='0'>全部</option>";
            let tableHtml = "";
            data.forEach(element => {
                agvIdHtml += '<option>' + element.agv_id + '</option>';
                tableHtml += '<tr><td>' + '1' + '</td><td>' + element.agv_id + '</td><td>' + element.statusInfo + '</td><td>' + element.rfidNo + '</td><td>' + element.occurTime + '</td></tr>'
            });
            $('#errInfo table tbody').html(tableHtml);
            $('#abCarIds').html(agvIdHtml);
        },
        error: function (e) {
            //失败后执行的代码
            console.log('get abnormal info failed.' + e);
        }
    });

}

function queryAgvPosition() {
    const parm = {
    }
    displayAgvInfo(parm);
}

function queryTaskInfo() {
    const carId = $('#taskCarIds').val();
    const taskType = $('#taskType').val();
    const parm = {
        carId: carId === '0' ? '' : carId,
        taskType: taskType === '0' ? '' : taskType,
        taskStartTm: '',
        taskEndTm: ''
    }
    displayTaskInfo(parm);
}

function deleteTaskInfo() {

}

function queryAbnormalInfo() {
    const carId = $('#abCarIds').val();
    const taskType = $('#errType').val();
    const rfid = $('#rfid').val();
    const parm = {
        carId: carId === '0' ? '' : carId,
        errType: taskType === '0' ? '' : taskType,
        rfid: rfid === '0' ? '' : rfid,
        abStartTm: '',
        abEndTm: ''
    }
    displayErrInfo(parm);
}

function deleteAbnormalInfo() {

}

