package com.business.auth.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public Map<String, Object> getUser() {
        Map<String, Object> res = new HashMap<>();
        Iterable<User> list = userRepository.findAll();
        if(list.iterator().hasNext()) {
            res.put("success", true);
            res.put("data", list);
        }else {
            res.put("success", false);
            res.put("data", "no data found");
        }
        return res;
    }

    @PostMapping("")
    public Map<String, Object> createUser(@RequestBody Map<String, String> body) {
        Map<String, Object> res = new HashMap<>();
        User user = new User(body.get("email"),
        body.get("name"),
        body.get("password"),
        body.get("role"));

        User saveRes = userRepository.save(user);
        if(null != saveRes) {
            res.put("success", true);
            res.put("data", saveRes);
        }else {
            res.put("success", false);
            res.put("data", "create user failed");
        }

        return res;
    }

    @PutMapping("/{id}")
    public Map<String, Object> updateUser(@RequestBody Map<String, String> body, @PathVariable Long id) {
        Map<String, Object> res = new HashMap<>();
        if(userRepository.existsById(id)) {
            User other = new User(body.get("email"),
            body.get("name"),
            body.get("password"),
            body.get("role"));

            other.setId(id);
            userRepository.save(other);
            res.put("success", true);
            res.put("data", other);
        }else {
            res.put("success", false);
            res.put("message", "no data found");
        }
        
        return res;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteUser(@PathVariable Long id) {
        Map<String, Object> res = new HashMap<>();
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            res.put("success", true);
            res.put("data", id);
        }else {
            res.put("success", false);
            res.put("message", "no data found");
        }

        return res;
    }

}