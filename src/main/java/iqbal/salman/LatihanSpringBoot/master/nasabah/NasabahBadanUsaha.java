/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iqbal.salman.LatihanSpringBoot.master.nasabah;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author iqbal
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class NasabahBadanUsaha extends Nasabah{
    @Column(name = "nomor_npwp", length = 62)
    private String nomorNpwp;
}
