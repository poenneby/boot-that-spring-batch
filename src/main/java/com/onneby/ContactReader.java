package com.onneby;

import com.onneby.model.SourceContact;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class ContactReader implements ItemReader<SourceContact> {
    @Override
    public SourceContact read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }
}
