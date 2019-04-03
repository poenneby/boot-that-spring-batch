package com.onneby;

import com.onneby.model.DestinationContact;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class ContactWriter implements ItemWriter<DestinationContact> {
    @Override
    public void write(List<? extends DestinationContact> list) throws Exception {

    }
}
