package fr.perretpy.gestpoic.controller;

import fr.perretpy.gestpoic.dto.tache.CreateTacheServiceDto;
import fr.perretpy.gestpoic.dto.tache.TacheDetailDto;
import fr.perretpy.gestpoic.dto.tache.TacheListApiDto;
import fr.perretpy.gestpoic.dto.tache.UpdateTacheDto;
import fr.perretpy.gestpoic.model.Tache;
import fr.perretpy.gestpoic.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/taches")
public class TacheController extends CrudController<
        Tache,
        CreateTacheServiceDto,
        UpdateTacheDto,
        TacheDetailDto,
        TacheListApiDto,
        UUID
        > {
    @Autowired
    public TacheController(TacheService tacheService) {
        super(tacheService);
    }
}
