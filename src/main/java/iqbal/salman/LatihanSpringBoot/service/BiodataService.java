package iqbal.salman.LatihanSpringBoot.service;

import iqbal.salman.LatihanSpringBoot.master.nasabah.Biodata;
import iqbal.salman.LatihanSpringBoot.repository.BiodataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class BiodataService {

    @Autowired
    BiodataRepository biodataRepository;

    @Transactional(readOnly = false)
    public List<Biodata>findAll(){
        return this.biodataRepository.findAll();
    }

    @Transactional
    public Biodata save(Biodata x){
        return this.biodataRepository.save(x);
    }

    @Transactional(readOnly = true)
    public void delete(String id){
        this.biodataRepository.delete(id);
    }

    @Transactional
    public Biodata findAllID(String id){
        return this.biodataRepository.findOne(id);
    }
}
