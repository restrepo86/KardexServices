package co.com.todo.uno.kardex.dto;

import javax.ws.rs.core.Response;

public class KardexHttpResponseDTO {

    private String code;
    private String message;
    private Response.Status statusResponseCode;

    public KardexHttpResponseDTO() {
        super();
    }

    public KardexHttpResponseDTO(String code, String message, Response.Status statusResponseCode) {
        this.code = code;
        this.message = message;
        this.statusResponseCode = statusResponseCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Response.Status getStatusResponseCode() {
        return statusResponseCode;
    }

    public void setStatusResponseCode(Response.Status statusResponseCode) {
        this.statusResponseCode = statusResponseCode;
    }
}
