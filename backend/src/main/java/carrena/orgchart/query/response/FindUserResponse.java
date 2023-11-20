package carrena.orgchart.query.response;

import carrena.orgchart.dto.UserDto;
import lombok.Builder;

import java.util.List;

@Builder
public class FindUserResponse {
    public List<UserDto> users;
    public Long totalCount;
    public Long currentPage;
}
