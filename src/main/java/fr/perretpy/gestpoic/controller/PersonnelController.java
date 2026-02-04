package fr.perretpy.gestpoic.controller;


import fr.perretpy.gestpoic.dto.personnel.CreatePersonnelDto;
import fr.perretpy.gestpoic.dto.personnel.PersonnelDetailDto;
import fr.perretpy.gestpoic.dto.personnel.PersonnelListApiDto;
import fr.perretpy.gestpoic.model.Personnel;
import fr.perretpy.gestpoic.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/personnels")
public class PersonnelController extends CrudController<
        Personnel,
        CreatePersonnelDto,
        CreatePersonnelDto,
        PersonnelDetailDto,
        PersonnelListApiDto,
        UUID>{
  @Autowired
  public PersonnelController(PersonnelService personnelService) {
    super(personnelService);
  }

}
