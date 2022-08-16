package br.com.letscode.utils;

public enum NamedClientQuery {
    GET_ALL_CLIENTS(
"GET_ALL_CLIENTS",
"SELECT * FROM CLIENT"
    ),
    GET_CLIENT_BY_ID(
"GET_CLIENT_BY_ID",
"SELECT * FROM CLIENT WHERE id = :id"
    );
    private String name;
    private String query;

    private NamedClientQuery(String name, String query){
        this.name = name;
    }
    public String getNamedQuery(){
        return this.name;
    }

    public String getQuery() {
        return this.query;
    }
}
