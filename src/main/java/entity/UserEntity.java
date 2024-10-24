/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

/**
 *
 * @author joaovitor
 */

@Entity
public class UserEntity extends PanacheEntityBase {
    
    @Id
    @SequenceGenerator(name = "seq_user", sequenceName = "seq_user", initialValue = 1)
    @GeneratedValue(generator = "seq_user", strategy = GenerationType.SEQUENCE)
    public Long id;
    
    public String userName;
    
}
