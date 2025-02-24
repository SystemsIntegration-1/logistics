package flux.logistic.application.dto;

import flux.logistic.domain.entities.Med;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DtoMed {
    UUID med_id;
    String med_name;
    int med_quantity;

    public DtoMed (Med med) {
        med_name = med.getName();
        med_quantity = med.getQuantity();
    }
}
