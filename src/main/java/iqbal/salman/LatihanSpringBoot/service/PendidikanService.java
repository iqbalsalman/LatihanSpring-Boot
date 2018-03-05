package iqbal.salman.LatihanSpringBoot.service;

import iqbal.salman.LatihanSpringBoot.master.pendidikan.Pendidikan;
import iqbal.salman.LatihanSpringBoot.repository.PendidikanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class PendidikanService {

    @Autowired
    PendidikanRepository pendidikanRepository;

    @Transactional(readOnly = false)
    public Pendidikan save(Pendidikan p){
      return this.pendidikanRepository.save(p);
    }

    @Transactional(readOnly = false)
    public void delete(String idu){
        this.pendidikanRepository.delete(idu);
   }

   @Transactional(readOnly = true)
    public Pendidikan pendidikanFindbyID(String idu){
        return this.pendidikanRepository.findOne(idu);
   }

   public  List<Pendidikan> findAll(){
        return this.pendidikanRepository.findAll();
   }

}
