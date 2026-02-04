package fr.perretpy.gestpoic.controller;

import fr.perretpy.gestpoic.dto.arme.CreateArmeDto;
import fr.perretpy.gestpoic.model.Arme;
import fr.perretpy.gestpoic.service.ArmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/armes")
public class ArmeController extends CrudController<
        Arme,
        CreateArmeDto,
        CreateArmeDto,
        Arme,
        Arme,
        UUID
        > {
    @Autowired
    public ArmeController(ArmeService armeService) {
        super(armeService);
    }
}
