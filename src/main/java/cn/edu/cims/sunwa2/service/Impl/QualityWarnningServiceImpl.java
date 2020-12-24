package cn.edu.cims.sunwa2.service.Impl;


import cn.edu.cims.sunwa2.mapper.QualityWarnningMapper;
import cn.edu.cims.sunwa2.model.QualityWarnning;
import cn.edu.cims.sunwa2.service.QualityWarnningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QualityWarnningServiceImpl implements QualityWarnningService {
    @Autowired
    private QualityWarnningMapper qualityWarnningMapper;
    @Override
    public List<QualityWarnning> listAll() {
        return qualityWarnningMapper.listAll();
    }

    @Override
    public List<QualityWarnning> listSelected(String lineName, String orderNum, String type, String warnTime) {
        return qualityWarnningMapper.listSelected(lineName,orderNum,type,warnTime);
    }

    @Override
    public void save(QualityWarnning qualityWarnning) {
        qualityWarnningMapper.save(qualityWarnning);
    }
}
