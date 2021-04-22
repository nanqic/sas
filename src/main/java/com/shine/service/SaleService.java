package com.shine.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shine.mapper.MySaleMapper;
import com.shine.model.vo.AnalysisVO;
import com.shine.model.vo.Result;
import com.shine.model.vo.SaleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    @Autowired
    private MySaleMapper mySaleMapper;

    public Result getPage(int page,int limit){
        if(limit!=0)PageHelper.startPage(page,limit);
        List<SaleView> list = mySaleMapper.findAll();
        PageInfo info = new PageInfo(list);

        return Result.success(list, info.getTotal());
    }
    public Result anaBySort(byte sid, String startTime, String endTime){
        AnalysisVO[] analysisVOS = mySaleMapper.getAnaBySid(sid,startTime,endTime);
        return Result.success(analysisVOS,0);
    }
    public Result anaByRegion(byte rid, String startTime, String endTime){
        AnalysisVO[] analysisVOS = mySaleMapper.getAnaByRegion(rid,startTime,endTime);
        return Result.success(analysisVOS,0);
    }
}
