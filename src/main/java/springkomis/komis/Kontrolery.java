package springkomis.komis;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import springkomis.komis.klasy.ImgUrl;
import springkomis.komis.klasy.Samochod;
import springkomis.komis.repo.ImgUrlRepo;
import springkomis.komis.repo.SamochodRepo;

//  TO DO:
//  wybieranie samochodów z określonymi argumentami
//  alerty o wygasającym przeglądzie lub ubezpieczeniu 
//  dodawanie auta z nullem jako data (try 00.00.0000)
//  

@Controller
public class Kontrolery {
    @Autowired
    private SamochodRepo sRepo;
    @Autowired
    private ImgUrlRepo iRepo;

    @GetMapping(value = "/admin/dodajAuto")
    public String dodajAuto(Model model){
        model.addAttribute("autoIn", new Samochod());
        return "dodajAuto";
    }

    @PostMapping(value = "/admin/dodajAuto")
    public String dodajAuto(Model model, Samochod autoIn){
        Date teraz = new Date(System.currentTimeMillis());
        autoIn.setDataDodania(teraz);               
        sRepo.save(autoIn);
        return "redirect:/wyswietlAuta";
    }

    @GetMapping(value = "/admin/edytujAuto")
    public String edytuj(   @RequestParam(value="ID", defaultValue="0") String ID,
                            Model model){
        Integer id = Integer.parseInt(ID);
        model.addAttribute("autoEdit", sRepo.findById(id));
        return "editAuto";
    }

    @PostMapping(value = "/admin/edytujAuto")
    public String edyString(Model model, Samochod a){
        sRepo.save(a);
        return"redirect:/wyswietlAuta";
    }

    @GetMapping(value = "/wyswietlAuta")
    public String wyswietlAuta(Model model){
        model.addAttribute("autaOut", sRepo.findAll());
        return "wyswietlAuta";
    }
    @GetMapping(value = "/admin/wyswietlAuta")
    public String wyswietlAutaPracownik(Model model){
        model.addAttribute("autaOut", sRepo.findAll());
        return "wyswietlAutaPracownik";
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

    @PostMapping(value = "/addImg")
    public String addimgpost(@RequestParam("image")MultipartFile file,int id) throws IllegalStateException, IOException{
        System.out.println(file);
        System.out.println(id);
        // String path = System.getProperty("user.dir")+"/data/cars/"+id+"/";
        // System.out.println(path);
        // File theDir = new File(path);
        //     if (!theDir.exists()){
        //         theDir.mkdirs();
        //         ImgUrl img = new ImgUrl(sRepo.findByIdIs(id),file.getOriginalFilename());
        //         iRepo.save(img);
        //         file.transferTo(new File(path+file.getOriginalFilename()));
        //     }else{
        //         ImgUrl img = new ImgUrl(sRepo.findByIdIs(id),file.getOriginalFilename());
        //         iRepo.save(img);
        //         System.out.println(theDir.getAbsolutePath());
        //         file.transferTo(new File(path+file.getOriginalFilename()));
        //     }
        return "redirect:/wyswietlAuta";
    }



    
    @ExceptionHandler
    public String handlerException(Model model,Exception exception)
    {
        String message = exception.getMessage();
        model.addAttribute("errormessage", message);
        return "errorpage";
    }
}