package com.oleksiiF.services;

import com.oleksiiF.model.Data;
import com.oleksiiF.model.DataTemplate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by OleksiiF on 20.04.2018.
 */
public class JSONServiceImplTest {

    JSONServiceImpl jsonServiceimpl;

    @Before
    public void init() {
        jsonServiceimpl = new JSONServiceImpl();

    }

    @Test
    public void getJSONObjects() throws Exception {
        String url = "https://lb.api-sandbox.openprocurement.org/api/2.4/contracts/" +
                "ffb2e977797440719208b510ed91548b/documents";
        Data dataActual = jsonServiceimpl.getJSONObjects(url);
        Data dataExpected = new Data();

        DataTemplate dataTemplate = new DataTemplate();
        dataTemplate.setId("abecf7b014574c869a9eef0e9fe0163d");
        dataExpected.setData(Arrays.asList(dataTemplate));

        Assert.assertEquals(dataExpected.getData().get(0).getId(), dataActual.getData().get(0).getId());

    }
}