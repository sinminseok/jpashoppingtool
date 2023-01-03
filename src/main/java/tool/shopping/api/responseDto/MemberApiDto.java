package tool.shopping.api.responseDto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class MemberApiDto {

    private Long id;

    public MemberApiDto(Long id){
        this.id = id;
    }


}
