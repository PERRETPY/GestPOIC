package fr.perretpy.gestpoic.service;

import fr.perretpy.gestpoic.dto.arme.CreateArmeDto;
import fr.perretpy.gestpoic.mapper.ArmeMapper;
import fr.perretpy.gestpoic.model.Arme;
import fr.perretpy.gestpoic.repository.ArmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ArmeService extends CrudServiceImpl<
        Arme,
        CreateArmeDto,
        CreateArmeDto,
        Arme,
        Arme,
        UUID
        > {
    @Autowired
    public ArmeService(ArmeRepository armeRepository, ArmeMapper armeMapper) {
        super(armeRepository, armeMapper);
    }
}
