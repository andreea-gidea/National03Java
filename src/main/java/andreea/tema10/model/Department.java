package andreea.tema10.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Department {

        private int departmentNumber;
        private String departmentName;
        private String city;

}
