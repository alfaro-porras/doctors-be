
package com.daniela.doctors.be.logic.patient;

public class Record {
    private String name;
    private int recordId;
    private int enabled;

    public Record() {
    }

    public Record(String name, int recordId, int enabled) {
        this.name = name;
        this.recordId = recordId;
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}
