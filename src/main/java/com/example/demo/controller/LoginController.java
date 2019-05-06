package com.example.demo.controller;

import com.example.demo.configuration.MvcConf;
import com.example.demo.models.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(MvcConf.class);

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
//    private UserService userSevice;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value={"/vhod"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vhod");
        return modelAndView;   }


    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value={"/"}, method = RequestMethod.GET)
    public ModelAndView welcome() {
        log.info("Called  welcome method");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("prods", productRepository.findAll());
        modelAndView.addObject("titles","");
        modelAndView.setViewName("welcome");

        return modelAndView;
    }
    @RequestMapping(value={"/poisk"}, method = RequestMethod.GET)
    public ModelAndView poisk() {

        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
    //@RequestMapping("/register")
//public ModelAndView registrform(ModelAndView modelAndView) {
//    modelAndView.setViewName("register");
//    modelAndView.addObject("user", new User());
//    return modelAndView;
//}
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String register(@ModelAttribute User user) {
//        user.setActive(1);
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        Set<Role> roles = new HashSet<>();
////        roles.add(roleRepository.findByName("CLIENT"));
//        user.setRoles(roles);
//        userRepository.save(user);
//        return "redirect:/login";
//    }
//@GetMapping("/registration")
//public String registration(){
//    return "registration";
//}
//
//    @PostMapping("/registration")
//    public String addUser(User user, Map<String, Object> model){
//        User userFromDb = userRepository.findByUsername(user.getUserName());
//
//        //Сообщаем если такой пользователь есть в базе данных
//        if (userFromDb != null){
//            model.put("message", "Данное имя пользователя не доступно!");
//            return "registration";
//        }
//
//        user.setActive(true);
//        //На вход ожидается коллекция в виде Set,
//        //но так как у нас всего одно значение мы можем
//        //использовать шорткат, из стандартной библиотеки,
//        //который создает set с одним единственным значением
//        user.setRoles(Collections.singleton(Role.ADMIN));
//        userRepository.save(user);
//        return "redirect:/login";
//    }
//    @RequestMapping(value="/registr", method = RequestMethod.GET)
//    public ModelAndView registr(){
//        ModelAndView modelAndView = new ModelAndView();
//        Product product= new Product();
//        modelAndView.addObject("product", product);
//        modelAndView.setViewName("/registr");
//        return  modelAndView;
//    }
//    @RequestMapping(value="/vhod", method = RequestMethod.GET)
//    public ModelAndView vhod(){
//        ModelAndView modelAndView = new ModelAndView();
//        Product product= new Product();
//        modelAndView.addObject("product", product);
//        modelAndView.setViewName("vhod");
//        return  modelAndView;
//    }
    @RequestMapping(value="/kont", method = RequestMethod.GET)
    public ModelAndView kont(){
        ModelAndView modelAndView = new ModelAndView();
        Product product= new Product();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("kont");
        return  modelAndView;
    }
    @RequestMapping(value="/new1", method = RequestMethod.GET)
    public ModelAndView new1(){
        ModelAndView modelAndView = new ModelAndView();
        Product product= new Product();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("new1");
        return  modelAndView;
    }
    @RequestMapping(value="/new2", method = RequestMethod.GET)
    public ModelAndView new2(){
        ModelAndView modelAndView = new ModelAndView();
        Product product= new Product();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("new2");
        return  modelAndView;
    }
    @RequestMapping(value="/new3", method = RequestMethod.GET)
    public ModelAndView new3(){
        ModelAndView modelAndView = new ModelAndView();
        Product product= new Product();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("new3");
        return  modelAndView;
    }
    @RequestMapping(value="/new4", method = RequestMethod.GET)
    public ModelAndView new4(){
        ModelAndView modelAndView = new ModelAndView();
        Product product= new Product();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("new4");
        return  modelAndView;
    }
    @RequestMapping(value="/podr", method = RequestMethod.GET)
    public ModelAndView podr(){
        ModelAndView modelAndView = new ModelAndView();
        Product product= new Product();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("podr");
        return  modelAndView;
    }
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
        Product product= new Product();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("register");
        return  modelAndView;
    }
//    @GetMapping("/registration")
//    public String registration() {
//        return "registration";
//    }
//
//    @PostMapping("/registration")
//    public String addUser(@Valid User user, BindingResult bindingResult, Model model) {
//        if (user.getPassword() != null && !user.getPassword().equals(user.getPassword2())) {
//            model.addAttribute("passwordError", "Passwords are different!");
//        }
//
//        if (bindingResult.hasErrors()) {
//            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
//
//            model.mergeAttributes(errors);
//
//            return "registration";
//        }
//        if (!userSevice.addUser(user)) {
//            model.addAttribute("usernameError", "User exists!");
//            return "registration";
//        }
//
//        return "redirect:/login";
//    }
//    @RequestMapping("/register")
//    public ModelAndView registrform(ModelAndView modelAndView) {
//        modelAndView.setViewName("register");
//        modelAndView.addObject("user", new User());
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String register(@ModelAttribute User user) {
//        user.setActive(1);
//        Set<Role> roles = new HashSet<>();
//
//        roles.add(roleRepository.findByName("CLIENT"));
//        user.setRoles(roles);
//        userRepository.save(user);
//        return "redirect:/login";
//    }



}
