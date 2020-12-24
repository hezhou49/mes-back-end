package cn.edu.cims.sunwa2.service.Impl;

import cn.edu.cims.sunwa2.mapper.WarnningMapper;
import cn.edu.cims.sunwa2.model.Warnning;
import cn.edu.cims.sunwa2.service.WarnningService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Wu on 2019/12/3.
 */
@Service
public class WarnningServiceImpl implements WarnningService {
    @Autowired
    private WarnningMapper warnningMapper;
    @Override
    public List<Warnning> listAll() {
        return warnningMapper.listAll();
    }

    @Override
    public List<Warnning> listSelected(String lineName, String equipmentName, String startTime,String endTime) {
        return warnningMapper.listSelected(lineName,equipmentName,startTime,endTime);
    }

    @Override
    public List<Warnning> unhandled(String warnstate) {
        return warnningMapper.unhandled(warnstate);
    }

    @Override
    public void update(String state, int id) {
        warnningMapper.update(state, id);
    }

    @Override
    public List<Warnning> fenye(String warnstate, int start, int limit) {
        return warnningMapper.fenye(warnstate, new RowBounds(start,limit));
    }

    @Override
    public void save(Warnning warnning) {
        warnningMapper.save(warnning);
    }

    @Override
    public int count(String equipmentName) {
        return warnningMapper.count(equipmentName);
    }


}
