/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iqbal.salman.LatihanSpringBoot.master.pendidikan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 *
 * @author iqbal
 *
 */
@Entity
@Table(name = "pendidikan",schema = "master")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pendidikan {


    @Id
    @GenericGenerator(name = "uuid_idp", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_idp")
    @Column(name = "id", nullable = false, unique = true, length = 5)
    private String id;

    @NotEmpty(message = "Data Tidak Boleh Kosong")
    @Column(name = "nama", nullable = false, length = 150)
    private String nama;

    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

    @Column(name = "created_by", nullable = false, length = 225)
    private String createdBy;


}
