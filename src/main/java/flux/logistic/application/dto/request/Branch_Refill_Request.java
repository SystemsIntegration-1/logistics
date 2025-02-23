package flux.logistic.application.dto.request;

import flux.logistic.application.dto.DtoMed;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Branch_Refill_Request {
    UUID branch_id;
    String branch_name;
    List <DtoMed> requested_meds;
    String branch_contact_requester;
    Date timestamp;
}
