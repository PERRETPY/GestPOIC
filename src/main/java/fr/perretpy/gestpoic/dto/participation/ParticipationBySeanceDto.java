package fr.perretpy.gestpoic.dto.participation;

import fr.perretpy.gestpoic.model.Participation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParticipationBySeanceDto {
    UUID participationId;
    UUID seanceId;
    UUID personnelId;
    String gradeLibelleCourt;
    String nom;
    String prenom;

    public ParticipationBySeanceDto(Participation participation) {
        this.participationId = participation.getId();
        this.seanceId = participation.getSeance().getId();
        this.personnelId = participation.getPersonnel().getId();
        this.gradeLibelleCourt = participation.getPersonnel().getGrade().getLibelleCourt();
        this.nom = participation.getPersonnel().getNom();
        this.prenom = participation.getPersonnel().getPrenom();
    }
}
