package iqbal.salman.LatihanSpringBoot.service;

import iqbal.salman.LatihanSpringBoot.master.nasabah.Alamat_Rumah;
import iqbal.salman.LatihanSpringBoot.repository.AlamatRumahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class AlmataRumahService {

    @Autowired
    AlamatRumahRepository rumahRepository;


    public List<Alamat_Rumah>findAll(){
        return this.rumahRepository.findAll();
    }

    @Transactional
    public Alamat_Rumah save(Alamat_Rumah x){
        return this.rumahRepository.save(x);
    }
}
