package com.teachmeskills.test.service;

import com.teachmeskills.test.entity.Address;
import com.teachmeskills.test.entity.User;
import com.teachmeskills.test.dao.UserDao;
import com.teachmeskills.test.entity.dto.UserRegistrationDto;
import com.teachmeskills.test.entity.dto.UserUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;

    public void save(UserRegistrationDto userRegistrationDto){
        if (userDao.existByUsername(userRegistrationDto.getUsername())){
            throw new RuntimeException("User with the same username already exist");
        }
        User user = new User(0,
                userRegistrationDto.getName(),
                userRegistrationDto.getUsername(),
                userRegistrationDto.getPassword(),
                new Address(0, userRegistrationDto.getStreet()
                        , userRegistrationDto.getHome())
        );
        userDao.save(user);
    }

    public List<User> getAll(){
        List<User> users = userDao.getAll();
        if (users.size() == 0){
            throw new RuntimeException("There is not any user");
        }
        return userDao.getAll();
    }

    public void merge(UserUpdateDto userUpdateDto){
        if (userDao.existById(userUpdateDto.getId())){
            if (userDao.existByUsername(userUpdateDto.getUsername())){
                throw new RuntimeException("User with the same username already exist");
            }

            User user = new User(userUpdateDto.getId(),
                    userUpdateDto.getName(),
                    userUpdateDto.getUsername(),
                    userUpdateDto.getPassword(),
                    new Address(0, userUpdateDto.getStreet()
                            , userUpdateDto.getHome())
            );
            userDao.update(user);
        }else {
            throw new RuntimeException("There is not user with this id");
        }
    }

    public void delete(long id){
        if (userDao.existById(id)){
            userDao.delete(id);
        }else {
            throw new RuntimeException("There is not user with this id");
        }
    }

    public void mergeAddress(long id, String street, int home) {
        Optional<User> byId = userDao.getById(id);
        if (byId.isPresent()){
            User user = byId.get();
            user.setAddress(new Address(0, street, home));
            userDao.update(user);
        }else {
            throw new RuntimeException("There is not user with this id");
        }
    }
}
