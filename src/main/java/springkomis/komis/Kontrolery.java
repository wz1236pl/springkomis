package springkomis.komis;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import springkomis.komis.klasy.ImgUrl;
import springkomis.komis.klasy.Samochod;
import springkomis.komis.klasy.Wyszukiwanie;
import springkomis.komis.repo.ImgUrlRepo;
import springkomis.komis.repo.SamochodRepo;

@Controller
public class Kontrolery {
    @Autowired
    private SamochodRepo sRepo;
    @Autowired
    private ImgUrlRepo iRepo;

    @GetMapping(value = "/")
    public String dodajAuto(Model model, Authentication auth){
        if(auth==null){
            model.addAttribute("szukaj",new Wyszukiwanie());
            model.addAttribute("autaOut", sRepo.findAllBySprzedanyIs(0));
            return "wyswietlAuta";
        }else{
            model.addAttribute("autaOut", sRepo.findAll());
            return"adminPage";
        }
    }

    @GetMapping(value = "/admin/home")
    public String admin(Model model, Authentication auth){
       return"redirect:/";
    }

    @PostMapping(value = "/szukaj")
    public String szukajAuto(Model model, Wyszukiwanie szukaj){
        List<Samochod> ListaAut = sRepo.findAll();
        for(int i=0; i<ListaAut.size(); i++){
            Samochod s = ListaAut.get(i);
            if(szukaj.getPrzebiegOd()!=0){
                if(szukaj.getPrzebiegOd()>s.getPrzebieg()){
                ListaAut.remove(s);
                i--;
                continue;
                }
            }
            if(szukaj.getPrzebiegDo()!=0){
                if(szukaj.getPrzebiegDo()<=s.getPrzebieg()){
                ListaAut.remove(s);
                i--;
                continue;
                }
            }
            if(szukaj.getRokOd()!=0){
                if(szukaj.getRokOd()>s.getRok()){
                ListaAut.remove(s);
                i--;
                continue;
                }
            }
            if(szukaj.getRokDo()!=0){
                if(szukaj.getRokDo()<=s.getRok()){
                ListaAut.remove(s);
                i--;
                continue;
                }
            }
            if(szukaj.getMocOd()!=0){
                if(szukaj.getMocOd()>s.getMoc()){
                ListaAut.remove(s);
                i--;
                continue;
                }
            }
            if(szukaj.getMocDo()!=0){
                if(szukaj.getMocDo()<=s.getMoc()){
                ListaAut.remove(s);
                i--;
                continue;
                }
            }
            if(!szukaj.getPaliwo().equals("")){
                if(!szukaj.getPaliwo().equals(s.getPaliwo())){
                ListaAut.remove(s);
                i--;
                continue;
                }
            }
            if(!szukaj.getTyp().equals("")){
                if(!szukaj.getTyp().equals(s.getTyp())){
                ListaAut.remove(s);
                i--;
                continue;
                }
            }
        }

        model.addAttribute("szukaj", szukaj);
        model.addAttribute("autaOut", ListaAut);

        System.out.println("szukaj : "+szukaj);
        return "wyswietlAuta";
    }

    @GetMapping(value = "/admin/dodajAuto")
    public String dodajAuto(Model model){
        return "dodajAuto";
    }

    @PostMapping(value = "/admin/dodajAuto")
    public String dodajAuto(Model model, Samochod auto, @RequestParam("zdj")MultipartFile[] files){
        try{
        Date teraz = new Date(System.currentTimeMillis());
        auto.setDataDodania(teraz);   
        if(auto.getDataPrzeglad().getTime()==-3600000){auto.setDataPrzeglad(null);}
        if(auto.getDataUbezpieczenia().getTime()==-3600000){auto.setDataUbezpieczenia(null);}
        Integer id = sRepo.save(auto).getId(); 
       for (MultipartFile f : files) {
        String path = System.getProperty("user.dir")+"\\data\\cars\\"+id+"\\";
        File theDir = new File(path);
            if (!theDir.exists()){
                theDir.mkdirs();
            }
            ImgUrl img = new ImgUrl(sRepo.findByIdIs(id),path+f.getOriginalFilename());
            iRepo.save(img);
            f.transferTo(new File(path+f.getOriginalFilename()));
       }
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
        // sRepo.save(autoIn);
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
    public String edyString(Model model, Samochod auto){
        if(auto.getDataPrzeglad().getTime()==-3600000){auto.setDataPrzeglad(null);}
        if(auto.getDataUbezpieczenia().getTime()==-3600000){auto.setDataUbezpieczenia(null);}
        sRepo.save(auto);
        return"redirect:/wyswietlAuta";
    }

    @GetMapping(value = "/wyswietlAuta")
    public String wyswietlAuta(Model model){
        model.addAttribute("szukaj", new Wyszukiwanie());
        model.addAttribute("autaOut", sRepo.findAll());
        return "wyswietlAuta";
    }
    @GetMapping(value = "/admin/wyswietlAuta")
    public String wyswietlAutaPracownik(Model model){
        model.addAttribute("szukaj", new Wyszukiwanie());
        model.addAttribute("autaOut", sRepo.findAll());
        return "wyswietlAutaPracownik";
    }
    
    @GetMapping(value = "/cenaXY")
    public String cenaInXY( @RequestParam(value="cenaX", defaultValue="0") String cenaX,
                            @RequestParam(value="cenaY", defaultValue="0") String cenaY,
                            Model model){
        Integer X = Integer.parseInt(cenaX); 
        Integer Y = Integer.parseInt(cenaY);
        model.addAttribute("autaOut", sRepo.findByCenaBetween(X, Y));
        return "wyswietlAuta";
    }

    @PostMapping(value = "/addImg")
    public String addimgpost(@RequestParam("image")MultipartFile file,int id) throws IllegalStateException, IOException{
        String path = System.getProperty("user.dir")+"\\data\\cars\\"+id+"\\";
        File theDir = new File(path);
            if (!theDir.exists()){
                theDir.mkdirs();
            }
            ImgUrl img = new ImgUrl(sRepo.findByIdIs(id),path+file.getOriginalFilename());
            iRepo.save(img);
            file.transferTo(new File(path+file.getOriginalFilename()));
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