/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iqbal.salman.LatihanSpringBoot.service;


import iqbal.salman.LatihanSpringBoot.master.rolesecurity.RoleSecurity;
import iqbal.salman.LatihanSpringBoot.master.rolesecurity.UserSecurity;
import iqbal.salman.LatihanSpringBoot.repository.RoleRepository;
import iqbal.salman.LatihanSpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author iqbal
 */
@Repository
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<RoleSecurity> listRole() {
        return this.roleRepository.findAll();
    }

    public List<UserSecurity> findUser() {
        return this.userRepository.findAll();
    }

    @Transactional(readOnly = false)
    public UserSecurity save(UserSecurity x) {
        return userRepository.save(x);
    }
    @Transactional(readOnly = false)
    public void delete(List<UserSecurity> list) {
        this.userRepository.delete(list);
    }
    @Transactional(readOnly = false)
    public void delete(UserSecurity x) {
        this.userRepository.delete(x);
    }

    @Transactional(readOnly = false)
    public void delete(String x) {
        this.userRepository.delete(x);
    }

        public UserSecurity findByUsername(String username) {
        return this.userRepository.findByNama(username);
    }

//    @Transactional(readOnly = false)
//    public  void UpdateByid(String id, String nama, String password,String biodata, String nama_lengkap,boolean active){
//       this.userRepository.updateNamaUser(id,nama,password,biodata,nama_lengkap,active);
//    }

    public UserSecurity findById(String kode) {
        return userRepository.findOne(kode);
    }

}
