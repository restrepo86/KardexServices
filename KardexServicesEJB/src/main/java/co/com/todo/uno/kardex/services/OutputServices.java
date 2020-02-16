package co.com.todo.uno.kardex.services;

import co.com.todo.uno.kardex.dto.RegisterOutputRequestDTO;
import co.com.todo.uno.kardex.entity.Output;
import co.com.todo.uno.kardex.repository.IOutputRepository;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.Date;

@Stateless
public class OutputServices {

    @Inject
    private IOutputRepository iOutputRepository;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void registerOutput(RegisterOutputRequestDTO registerOutputRequestDTO) {
        Output output = buildOutput(registerOutputRequestDTO);
        iOutputRepository.save(output);
    }

    private Output buildOutput(RegisterOutputRequestDTO registerOutputRequestDTO) {
        Output output = new Output();
        output.setAmount(registerOutputRequestDTO.getAmount());
        output.setDate(new Date());
        output.setTotalValue(registerOutputRequestDTO.getTotalValue());
        output.setUnitValue(registerOutputRequestDTO.getUnitValue());
        output.setProductId(registerOutputRequestDTO.getProductId());
        return output;
    }

}
