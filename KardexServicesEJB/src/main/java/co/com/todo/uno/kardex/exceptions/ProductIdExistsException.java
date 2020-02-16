package co.com.todo.uno.kardex.exceptions;

public class ProductIdExistsException extends KardexRegisterEntryValidationsException {

    public ProductIdExistsException(String message) {
        super(message);
    }

}

