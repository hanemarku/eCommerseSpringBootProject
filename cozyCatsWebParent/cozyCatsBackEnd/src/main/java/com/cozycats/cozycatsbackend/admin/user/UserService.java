
package com.cozycats.cozycatsbackend.admin.user;
import com.cozycats.cozycatscommon.entity.Role;
import com.cozycats.cozycatscommon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

//    @Autowired
//    private PasswordEncoder passwordEncoder;


    public List<User> listAll(){
        return (List<User>) userRepo.findAll();
    }

    public  List<Role> listRoles(){
        return (List<Role>) roleRepo.findAll();
    }

    public void save(User user) {
        //encodePassword(user);
        userRepo.save(user);
    }

//    private void encodePassword(User user){
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//    }


}