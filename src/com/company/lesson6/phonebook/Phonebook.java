package com.company.lesson6.phonebook;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    private List<Record> records = new ArrayList<>();

    public void addRecord(Record record) {
        records.add(record);
    }

    public Record find(String name) {
        for (Record record : records) {
            if (record != null
                    && name != null
                    && name.equals(record.getName())) {
                return record;
            }
        }
        return null;
    }

    public List<Record> findAll(String name) {
        List<Record> recordsByName = new ArrayList<>();
        for (Record record : records) {
            if (record != null
                    && name != null
                    && name.equals(record.getName())) {
                recordsByName.add(record);
            }
        }
        return recordsByName.isEmpty() ? null : recordsByName;
    }
}
