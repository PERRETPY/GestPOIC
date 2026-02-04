package fr.perretpy.gestpoic.controller;


import fr.perretpy.gestpoic.dto.grade.CreateGradeDto;
import fr.perretpy.gestpoic.dto.grade.GradeDetailDto;
import fr.perretpy.gestpoic.dto.grade.GradeListApiDto;
import fr.perretpy.gestpoic.model.Grade;
import fr.perretpy.gestpoic.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/grades")
public class GradeController extends CrudController<
        Grade,
        CreateGradeDto,
        CreateGradeDto,
        GradeDetailDto,
        GradeListApiDto,
        UUID>{

  private final GradeService gradeService;
  @Autowired
  public GradeController(GradeService gradeService) {
    super(gradeService);
    this.gradeService = gradeService;
  }

  @GetMapping("/armeeId/{armeeId}")
  public ResponseEntity<Page<GradeListApiDto>> getGradeByArmeeId(@PathVariable UUID armeeId, Pageable pageable) {
    this.logger.info("GET request on {} with parameters: {}", this.requestMapping, pageable);
    Page<GradeListApiDto> page = this.gradeService.getGradeByArmeeId(armeeId, pageable);
    return ResponseEntity.ok(page);
  }

}
