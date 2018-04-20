package com.oleksiiF.services;

import com.oleksiiF.model.Data;

import java.io.IOException;

/**
 * Created by OleksiiF on 20.04.2018.
 */
public interface JSONService {
    Data getJSONObjects(String url) throws IOException;
    String sendToDb(Data data);
}
