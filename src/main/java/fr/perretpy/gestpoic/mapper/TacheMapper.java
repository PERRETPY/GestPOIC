package fr.perretpy.gestpoic.mapper;

import fr.perretpy.gestpoic.dto.tache.CreateTacheServiceDto;
import fr.perretpy.gestpoic.dto.tache.TacheDetailDto;
import fr.perretpy.gestpoic.dto.tache.TacheListApiDto;
import fr.perretpy.gestpoic.dto.tache.UpdateTacheDto;
import fr.perretpy.gestpoic.model.Tache;
import org.springframework.stereotype.Component;

@Component
public class TacheMapper implements Mapper<Tache, CreateTacheServiceDto, UpdateTacheDto, TacheDetailDto, TacheListApiDto> {
  @Override
  public Tache fromCreateDto(CreateTacheServiceDto createDto) {
    return null;
  }

  @Override
  public void updateEntity(Tache entity, UpdateTacheDto updateDto) {

  }

  @Override
  public TacheDetailDto toDetailDto(Tache entity) {
    return new TacheDetailDto(entity.getId(), entity.getSeance().getId(), entity.getLibelle(), entity.getEcheanceAt(), entity.getStatut());
  }

  @Override
  public TacheListApiDto toListDto(Tache entity) {
    return new TacheListApiDto(entity.getId(), entity.getSeance().getId(), entity.getLibelle(), entity.getEcheanceAt(), entity.getStatut());
  }
}
