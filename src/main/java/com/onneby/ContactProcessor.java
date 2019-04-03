package com.onneby;

import com.onneby.model.DestinationContact;
import com.onneby.model.SourceContact;
import org.springframework.batch.item.ItemProcessor;

public class ContactProcessor implements ItemProcessor<SourceContact, DestinationContact> {
    @Override
    public DestinationContact process(SourceContact sourceContact) throws Exception {
        return null;
    }
}
