package com.example.demo.controller;

import com.example.demo.pojo.Replay;
import com.example.demo.service.ReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


@RestController
public class ReplayController {
    @Autowired
    private ReplayService replayService;
    /*定义方法处理投诉回复的请求*/
    @PostMapping("/saveReplay")
    public Map<String,Object> saveReplay(@RequestBody Replay replay){
        Map<String,Object> result = new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败.....");
        try {
            replay.setRedate(new Date());
            replay.setScore(ThreadLocalRandom.current().nextInt(1,6));
            replayService.save(replay);
            result.put("code",200);
            result.put("msg","处理投诉回复成功.....");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    /*处理回复列表分页查询请求*/
    @GetMapping("/listReplay")
    public Map<String,Object> listReplay(Integer id
            ,@RequestParam(defaultValue = "1") Integer pageNum
            ,@RequestParam(defaultValue = "3") Integer pageSize){
        return replayService.queryReplayListService(id,pageNum,pageSize);}

}
