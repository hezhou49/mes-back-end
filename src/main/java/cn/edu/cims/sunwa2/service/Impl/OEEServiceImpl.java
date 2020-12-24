package cn.edu.cims.sunwa2.service.Impl;

import cn.edu.cims.sunwa2.mapper.OEEMapper;
import cn.edu.cims.sunwa2.model.OEE;
import cn.edu.cims.sunwa2.service.OEEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OEEServiceImpl implements OEEService {
    @Autowired
    private OEEMapper oeeMapper;

    @Override
    public List<OEE> listAll() {
        return oeeMapper.listAll();
    }

    @Override
    public List<String> listDistinct() {
        return oeeMapper.listDistinct();
    }

    @Override
    public List<OEE> listTop(List<String> list) {
        return  oeeMapper.listTop(list);
    }

    @Override
    public OEE findByDateAndLineAndName(String date, String line, String name) {
        return oeeMapper.findByDateAndLineAndName(date, line, name);
    }
}
