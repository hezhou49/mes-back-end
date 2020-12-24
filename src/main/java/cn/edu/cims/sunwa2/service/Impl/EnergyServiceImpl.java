package cn.edu.cims.sunwa2.service.Impl;

import cn.edu.cims.sunwa2.mapper.EnergyMapper;
import cn.edu.cims.sunwa2.model.Energy;
import cn.edu.cims.sunwa2.service.EnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author hezhou
 * @Date 2020/3/15 9:57
 */
@Service
public class EnergyServiceImpl implements EnergyService {
    @Autowired
    EnergyMapper energyMapper;
    @Override
    public List<Energy> listAll() {
        return energyMapper.listAll();
    }

    @Override
    public Energy listMostRecent() {
        return energyMapper.listMostRecent();
    }

    @Override
    public List<Energy> listSelected(String linename,String date) {
        return energyMapper.listSelected(linename,date);
    }

    @Override
    public List<String> listDistinct(String column) {
        return energyMapper.listDistinct(column);
    }

    @Override
    public Energy listTop(String column,String time) {
        return energyMapper.listTop(column,time);
    }

    @Override
    public void update(int value, Date date) {
        energyMapper.update(value,date);
    }

    @Override
    public void save(Energy energy) {
        energyMapper.save(energy);
    }


}

