package flux.logistic.application.mappers;

import flux.logistic.application.dto.DtoMed;
import flux.logistic.domain.entities.Med;

public class MedMapper {
    public static DtoMed medToDtoMed(Med medication){
        return new DtoMed(medication);
    }
}
