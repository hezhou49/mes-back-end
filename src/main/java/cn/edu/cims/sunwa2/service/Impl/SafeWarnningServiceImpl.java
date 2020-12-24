package cn.edu.cims.sunwa2.service.Impl;

import cn.edu.cims.sunwa2.mapper.SafeWarnningMapper;
import cn.edu.cims.sunwa2.model.SafeWarnning;
import cn.edu.cims.sunwa2.service.SafeWarnningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Wu on 2019/12/11.
 */
@Service
public class SafeWarnningServiceImpl implements SafeWarnningService {
    @Autowired
    private SafeWarnningMapper safeWarnningMapper;

    @Override
    public List<SafeWarnning> listAll() {
        return safeWarnningMapper.listAll();
    }

    @Override
    public List<SafeWarnning> listSelected(String lineName, String departure) {
        return safeWarnningMapper.listSelected(lineName, departure);
    }

    @Override
    public void save(SafeWarnning safeWarnning) {
        safeWarnningMapper.save(safeWarnning);
    }
}
