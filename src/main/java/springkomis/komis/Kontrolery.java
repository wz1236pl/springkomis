package springkomis.komis;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import springkomis.komis.klasy.Samochod;
import springkomis.komis.repo.SamochodRepo;

@Controller
public class Kontrolery {
    @Autowired
    private SamochodRepo sRepo;

    @GetMapping(value = "/dodajAuto")
    public String dodajAuto(Model model){
        model.addAttribute("autoIn", new Samochod());

        return "dodajAuto";
    }

    @PostMapping(value = "/dodajAuto")
    public String dodajAuto(Model model, Samochod autoIn){
        Date teraz = new Date(System.currentTimeMillis());
        System.out.println(teraz);
        autoIn.setDataDodania(teraz);        
        sRepo.save(autoIn);

        return "redirect:/wyswietlAuta";
    }

    @GetMapping(value = "/wyswietlAuta")
    public String wyswietlAuta(Model model){
        model.addAttribute("autaOut", sRepo.findAll());
        return "wyswietlAuta";
    }
 

    @ExceptionHandler
    public String handlerException(Model model,Exception exception)
    {
        String message = exception.getMessage();
        model.addAttribute("errormessage", message);
        return "errorpage";
    }
}