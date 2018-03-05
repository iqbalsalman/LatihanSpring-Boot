/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iqbal.salman.LatihanSpringBoot.master.rolesecurity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iqbal
 */
@Entity
@Table(name = "users", schema = "security")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "listRole")

public class UserSecurity {

    @Id
    @GenericGenerator(name = "userid_uuid", strategy = "uuid2")
    @GeneratedValue(generator = "userid_uuid")
    @Column(name = "user_id", length = 64, nullable = false, unique = true)
    private String id;

    @Column(name = "username", nullable = false, unique = true, length = 150)
    private String nama;

    @Column(name = "passwd", nullable = false)
    private String password;

    @Column(name = "is_active", nullable = false)
    private boolean active;

    @Column(name = "created_by")
    private String ceatedBy;

    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

    @NotNull(message = "tidak boleh kosong!")
    @NotEmpty(message = "tidak boleh string kosong!")
    @Size(min = 5, max = 25, message = "agama jumlah karakternya minal 5 sampai 50 karakter")
    @Column(name = "nama_lengkap ", nullable = false, length = 25)
    private  String nama_lengkap;

    @Column(name = "biodata")
    private  String biodata;

    @OneToMany
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false),
            schema = "security"
    )
    private List<RoleSecurity> listRole = new ArrayList<>();
    
}
