package carrena.orgchart.command.user;

import java.util.Optional;

public record CreateUserRoleCommand(String roleName,
                                    String roleIdentity,
                                    int roleStatus,
                                    int sortOrder,
                                    Optional<Long> id
                                ) implements UserCommand{

}
