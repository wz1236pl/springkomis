package springkomis.komis;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        autoIn.setDataDodania(teraz);               
        sRepo.save(autoIn);

        return "redirect:/wyswietlAuta";
    }

    @GetMapping(value = "/edytujAuto")
    public String edytuj(   @RequestParam(value="ID", defaultValue="0") String ID,
                            Model model){
        System.out.println(ID);
        Integer id = Integer.parseInt(ID);
        model.addAttribute("autoEdit", sRepo.findById(id));
        return "editAuto";
    }

    @PostMapping(value = "/edytujAuto")
    public String edyString(Model model, Samochod samochod){
        System.out.println(samochod);
        return"";
    }

    @GetMapping(value = "/wyswietlAuta")
    public String wyswietlAuta(Model model){
        model.addAttribute("autaOut", sRepo.findAll());
        return "wyswietlAuta";
    }
    
    @GetMapping(value = "/cenaXY")
    public String cenaInXY( @RequestParam(value="cenaX", defaultValue="0") String cenaX,
                            @RequestParam(value="cenaY", defaultValue="0") String cenaY,
                            Model model){
        Double X = Double.parseDouble(cenaX); 
        Double Y = Double.parseDouble(cenaY);
        model.addAttribute("autaOut", sRepo.findByCenaBetween(X, Y));
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