package co.com.todo.uno.kardex.services;

import co.com.todo.uno.kardex.dto.EntryRequestDTO;
import co.com.todo.uno.kardex.entity.Entry;
import co.com.todo.uno.kardex.repository.IEntryRepository;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Stateless
public class EntryServices {

    @Inject
    private IEntryRepository iEntryRepository;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void registerEntry(EntryRequestDTO entryRequestDTO) {
        Entry entry = buildEntry(entryRequestDTO);
        iEntryRepository.save(entry);
    }

    private Entry buildEntry(EntryRequestDTO entryRequestDTO) {
        Entry entry = new Entry();
        entry.setAmount(entryRequestDTO.getAmount());
        entry.setDate(new Date());
        entry.setProductId(entryRequestDTO.getProductId());
        entry.setUnitValue(entryRequestDTO.getUnitValue());
        entry.setTotalValue(entryRequestDTO.getTotalValue());
        return entry;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Entry> findProductById(Long productId) {
        return iEntryRepository.findByProductId(productId);
    }

}
