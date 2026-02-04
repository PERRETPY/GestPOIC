package fr.perretpy.gestpoic.mapper;

import fr.perretpy.gestpoic.dto.seance.CreateSeanceDto;
import fr.perretpy.gestpoic.model.Seance;
import org.springframework.stereotype.Component;

@Component
public class SeanceMapper implements Mapper<Seance, CreateSeanceDto, CreateSeanceDto, Seance, Seance> {
    @Override
    public Seance fromCreateDto(CreateSeanceDto createDto) {
        Seance seance = new Seance();
        seance.setPerceptionStandeAt(createDto.perceptionStandAt());
        seance.setNettoyageOn(createDto.nettoyageAt());
        seance.setNoteService(createDto.noteService());
        seance.setDescription(createDto.description());
        seance.setDateDebut(createDto.dateDebut());
        seance.setDateFin(createDto.dateFin());
        return seance;
    }

    @Override
    public void updateEntity(Seance entity, CreateSeanceDto updateDto) {
        entity.setPerceptionStandeAt(updateDto.perceptionStandAt());
        entity.setNettoyageOn(updateDto.nettoyageAt());
        entity.setNoteService(updateDto.noteService());
        entity.setDescription(updateDto.description());
        entity.setDateDebut(updateDto.dateDebut());
        entity.setDateFin(updateDto.dateFin());
    }

    @Override
    public Seance toDetailDto(Seance entity) {
        return entity;
    }

    @Override
    public Seance toListDto(Seance entity) {
        return entity;
    }
}
