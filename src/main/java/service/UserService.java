/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.UserEntity;
import exception.UserNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 *
 * @author joaovitor
 */
@ApplicationScoped
public class UserService {

    @Transactional
    public UserEntity createUser(UserEntity userEntity) {
        UserEntity.persist(userEntity);
        return userEntity;
    }

    public List<UserEntity> findAll(Integer page, Integer pageSize) {
        return UserEntity.findAll().page(page, pageSize).list();
    }

    public UserEntity findById(Long id) {
        return (UserEntity) UserEntity.findByIdOptional(id)
                .orElseThrow(UserNotFoundException::new);
    }
    
    @Transactional
    public UserEntity updateUser(Long id, UserEntity userEntity) {
        var user = findById(id);
        user.userName = userEntity.userName;
        UserEntity.persist(user);
        return user;
    }
    
    @Transactional
    public void deleteById(Long id) {
        var user = findById(id);
        UserEntity.deleteById(user.id);
    }
}
