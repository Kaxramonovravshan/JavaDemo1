//package com.book.demo.controller;
//
//
//import com.book.demo.entity.Users;
//import com.book.demo.repasitory.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//
//@CrossOrigin
//@RestController
//@RequestMapping("user")
//public class RequestHandlerController {
//    private final UserRepo userRepo;
//    @Autowired
//    public RequestHandlerController(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }
//
//    List<Users> users = new ArrayList<>();
//    @GetMapping("/getUser")
//    public List<Users> GetUser(@RequestParam(required = false, defaultValue = "") String search){
//
//        List<Users> users = userRepo.findAllUsers();
//        return  users;
//    }
//
//    @PostMapping("/postUser")
//    public void PostUser(@RequestBody Users userReq){
//
//        userRepo.save(userReq);
//
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteUser(@PathVariable long id){
//        userRepo.deleteById(id);
//    }
//
//    @PutMapping("/editUser/{id}")
//    public void putUser(@PathVariable long id, @RequestBody Users userReq){
//        Optional<Users> userRepoById = userRepo.findById(id);
//        if(userRepoById.isPresent()){
//            Users users1 = userRepoById.get();
//            users1.setFirstName(userReq.getFirstName());
//            users1.setLastName(userReq.getLastName());
//            users1.setAge(userReq.getAge());
//            userRepo.save(users1);
//        }
//    }
//
//}
