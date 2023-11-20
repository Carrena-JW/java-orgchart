package carrena.orgchart.command.user;

import java.util.Optional;

public record CreateUserTitleCommand(String titleName,
                                     String titleIdentity,
                                     int titleStatus,
                                     int sortOrder,
                                     Optional<Long> id
                                ) implements UserCommand{

}
