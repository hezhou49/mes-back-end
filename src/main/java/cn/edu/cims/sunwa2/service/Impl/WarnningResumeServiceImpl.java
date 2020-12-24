package cn.edu.cims.sunwa2.service.Impl;

import cn.edu.cims.sunwa2.mapper.WarnningResumeMapper;
import cn.edu.cims.sunwa2.model.WarnningResume;
import cn.edu.cims.sunwa2.service.WarnningResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Wu on 2019/12/3.
 */
@Service
public class WarnningResumeServiceImpl implements WarnningResumeService {
    @Autowired
    private WarnningResumeMapper warnningResumeMapper;
    @Override
    public List<WarnningResume> listAll() {
        return warnningResumeMapper.listAll();
    }

    @Override
    public List<WarnningResume> listSelected(String lineName, String equipmentname, String startTime,String endTime) {
        return warnningResumeMapper.listSelected(lineName,equipmentname,startTime,endTime);
    }

    @Override
    public void save(WarnningResume warnningResume) {
        warnningResumeMapper.save(warnningResume);
    }
}
