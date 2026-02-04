package fr.perretpy.gestpoic.controller;

import fr.perretpy.gestpoic.dto.armee.CreateArmeeDto;
import fr.perretpy.gestpoic.model.Armee;
import fr.perretpy.gestpoic.service.ArmeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/armees")
public class ArmeeController extends CrudController<
        Armee,
        CreateArmeeDto,
        CreateArmeeDto,
        Armee,
        Armee,
        UUID
        > {
    @Autowired
    public ArmeeController(ArmeeService armeeService) {
        super(armeeService);
    }
}
