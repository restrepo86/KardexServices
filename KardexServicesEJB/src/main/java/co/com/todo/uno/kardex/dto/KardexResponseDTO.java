package co.com.todo.uno.kardex.dto;

public class KardexResponseDTO {

    private final String code;
    private final String message;

    public KardexResponseDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
