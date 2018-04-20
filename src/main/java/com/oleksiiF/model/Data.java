package com.oleksiiF.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by OleksiiF on 20.04.2018.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {

    @XmlElement
    private List<DataTemplate> data;

    public List<DataTemplate> getData() {
        return data;
    }

    public void setData(List<DataTemplate> data) {
        this.data = data;
    }
}
