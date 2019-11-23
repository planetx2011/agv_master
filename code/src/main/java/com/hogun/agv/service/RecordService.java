package com.hogun.agv.service;

import com.hogun.agv.mapper.RecordMapper;
import com.hogun.agv.model.AbnormalInfo;
import com.hogun.agv.model.TaskInfo;
import com.hogun.agv.util.JsonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/record")
public class RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @RequestMapping(value = "/taskInfos", method = RequestMethod.GET)
    public @ResponseBody String getAgvTaskInfos(@RequestParam("carId") String carId,
                                                @RequestParam("taskType") String taskType,
                                                @RequestParam("taskStartTm") String taskStartTm,
                                                @RequestParam("taskEndTm") String taskEndTm) {
        Map<String, String> parm = new HashMap<String, String>();
        parm.put("carId", carId);
        parm.put("taskType", taskType);
        parm.put("taskStartTm", taskStartTm);
        parm.put("taskEndTm", taskEndTm);
        List<TaskInfo> result = recordMapper.queryTaskRecord(parm);
        return JsonUtil.toJson(result);
    }

    @RequestMapping(value = "/abnormalInfos", method = RequestMethod.GET)
    public @ResponseBody String getAgvAbnormalInfos(@RequestParam("carId") String carId,
                                                    @RequestParam("errType") String errType,
                                                    @RequestParam("rfid") String rfid,
                                                    @RequestParam("abStartTm") String abStartTm,
                                                    @RequestParam("abEndTm") String abEndTm) {
        Map<String, String> parm = new HashMap<String, String>();
        parm.put("carId", carId);
        parm.put("errType", errType);
        parm.put("rfid", rfid);
        parm.put("abStartTm", abStartTm);
        parm.put("abEndTm", abEndTm);
        List<AbnormalInfo> result = recordMapper.queryAbnormalRecord(parm);
        return JsonUtil.toJson(result);
    }

}
