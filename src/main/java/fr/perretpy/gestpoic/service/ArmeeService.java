package fr.perretpy.gestpoic.service;

import fr.perretpy.gestpoic.dto.armee.CreateArmeeDto;
import fr.perretpy.gestpoic.mapper.ArmeeMapper;
import fr.perretpy.gestpoic.model.Armee;
import fr.perretpy.gestpoic.repository.ArmeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ArmeeService extends CrudServiceImpl<
        Armee,
        CreateArmeeDto,
        CreateArmeeDto,
        Armee,
        Armee,
        UUID
        > {
    @Autowired
    public ArmeeService(ArmeeRepository armeeRepository, ArmeeMapper armeeMapper) {
        super(armeeRepository, armeeMapper);
    }
}
