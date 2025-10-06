package api.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewPet {

    private int id;
    private CategoryNewPet category;
    private String name;
    private List<String> photoUrls;
    private List<TagsNewPet> tags;
    private String status;
}
