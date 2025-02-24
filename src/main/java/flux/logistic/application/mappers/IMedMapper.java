package flux.logistic.application.mappers;

import flux.logistic.application.dto.DtoMed;
import flux.logistic.domain.entities.Med;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IMedMapper {
    IMedMapper INSTANCE = Mappers.getMapper(IMedMapper.class);

    @Mapping(target = "med_id", ignore = true)
    DtoMed mapMedToDtoMed(Med med);

    Med mapMedDtoToMed(DtoMed dtoMed);

}
