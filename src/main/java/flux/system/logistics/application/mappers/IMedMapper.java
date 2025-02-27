package flux.system.logistics.application.mappers;

import flux.system.logistics.application.dto.DtoMed;
import flux.system.logistics.domain.entities.Med;
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
