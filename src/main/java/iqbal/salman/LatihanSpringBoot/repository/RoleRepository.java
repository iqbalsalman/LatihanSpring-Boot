/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iqbal.salman.LatihanSpringBoot.repository;


import iqbal.salman.LatihanSpringBoot.master.rolesecurity.RoleSecurity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author iqbal
 */
public interface RoleRepository extends CrudRepository<RoleSecurity, Long> {
        List<RoleSecurity> findAll();

    
}

