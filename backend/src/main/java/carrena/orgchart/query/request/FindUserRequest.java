package carrena.orgchart.query.request;


public record FindUserRequest (Long limit, Long offset, String keyword){}

