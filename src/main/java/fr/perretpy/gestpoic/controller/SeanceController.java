package fr.perretpy.gestpoic.controller;

import fr.perretpy.gestpoic.dto.seance.CreateSeanceDto;
import fr.perretpy.gestpoic.model.Seance;
import fr.perretpy.gestpoic.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/seances")
public class SeanceController extends CrudController<
        Seance,
        CreateSeanceDto,
        CreateSeanceDto,
        Seance,
        Seance,
        UUID
        > {
    @Autowired
    public SeanceController(SeanceService seanceService) {
        super(seanceService);
    }
}
