package carrena.orgchart.command.user;

import java.util.Optional;

public record CreateUserPositionCommand(String positionName,
                                        String positionIdentity,
                                        int positionStatus,
                                        int sortOrder,
                                        Optional<Long> id
                                ) implements UserCommand{

}
